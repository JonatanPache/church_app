package com.jonatan.church.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.jonatan.church.Model.TipoRelacionFamiliar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class DbTipoRelacionFamiliar extends DbHelper{

    Context context;
    private static final String TABLE_NAME = "TipoRelacionFamiliar";
    private static final String KEY_ID = "id";
    private static final String KEY_NOMBRE = "nombre";
    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use for locating paths to the the database
     */
    public DbTipoRelacionFamiliar(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertTipoRelacionFamiliar(String nombre){
        try {
            DbHelper dbHelper = new DbHelper(this.context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaActual = dateFormat.format(calendar.getTime());
            values.put("created_at", fechaActual);
            values.put("updated_at", fechaActual);
            return db.insert(TABLE_NAME, null, values);
        }catch (SQLException e){
            e.getMessage();
        }
        return 0;
    }

    public ArrayList<Map<String, Object>> getAllTipoRelacionFamiliar() {
        ArrayList<Map<String, Object>> tipoRelacionFamiliarArrayList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Map<String, Object> tipoRelacion = new HashMap<>();
                tipoRelacion.put("id", c.getInt(c.getColumnIndexOrThrow(KEY_ID)));
                tipoRelacion.put("nombre", c.getString(c.getColumnIndexOrThrow(KEY_NOMBRE)) );
                // adding to list
                tipoRelacionFamiliarArrayList.add(tipoRelacion);
            } while (c.moveToNext());
        }
        return tipoRelacionFamiliarArrayList;
    }
}
