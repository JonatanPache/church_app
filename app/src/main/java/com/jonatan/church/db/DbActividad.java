package com.jonatan.church.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DbActividad extends DbHelper{

    Context context;
    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use for locating paths to the the database
     */
    public DbActividad(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertActividad(String nombre, String descripcion, String fecha_inicio, String fecha_final){
        try {
            DbHelper dbHelper = new DbHelper(this.context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("descripcion", descripcion);
            values.put("fecha_inicio", fecha_inicio);
            values.put("fecha_final", fecha_final);// Obtén la fecha y hora actual
            Calendar calendar = Calendar.getInstance();
            // Especifica el formato de fecha deseado
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // Convierte la fecha actual al formato deseado
            String fechaActual = dateFormat.format(calendar.getTime());
            values.put("created_at", fechaActual);
            values.put("updated_at", fechaActual);
            return db.insert("Actividad", null, values);
        }catch (SQLException e){
            e.getMessage();
        }
        return 0;
    }
}
