package com.jonatan.church.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbRelacionFamiliar extends DbHelper{

    Context context;
    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use for locating paths to the the database
     */
    public DbRelacionFamiliar(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertPersona(String ci, String nombre, String phone, int rol){
        try {
            DbHelper dbHelper = new DbHelper(this.context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("ci", ci);
            values.put("nombre", nombre);
            values.put("phone", phone);
            values.put("rol", rol);
            return db.insert("Persona", null, values);
        }catch (SQLException e){
            e.getMessage();
        }
        return 0;
    }
}
