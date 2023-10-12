package com.jonatan.church.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbRelacionFamiliar extends DbHelper{

    Context context;
    private String TABLE_NAME = "RelacionFamiliar";
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

    public long insertRelacionFamiliar(int ci_persona_1, int ci_persona_2, int tipo_relacion_id){
        try {
            DbHelper dbHelper = new DbHelper(this.context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("ci_persona_1", ci_persona_1);
            values.put("ci_persona_2", ci_persona_2);
            values.put("tipo_relacion_id", tipo_relacion_id);
            return db.insert(TABLE_NAME, null, values);
        }catch (SQLException e){
            e.getMessage();
        }
        return 0;
    }
}
