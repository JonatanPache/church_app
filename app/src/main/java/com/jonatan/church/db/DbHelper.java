package com.jonatan.church.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "church.db";
    public static final String TABLE_CONTACT = "t_contact";


    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use for locating paths to the the database
     */
    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS TipoRelacionFamiliar ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre TEXT NOT NULL ,"+
                "created_at DATETIME NOT NULL ,"+
                "updated_at DATETIME NOT NULL)");

        db.execSQL("CREATE TABLE IF NOT EXISTS Cargo ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre TEXT NOT NULL ,"+
                "descripcion TEXT ,"+
                "created_at DATETIME NOT NULL ,"+
                "updated_at DATETIME NOT NULL)");

        db.execSQL("CREATE TABLE IF NOT EXISTS Ingreso ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre TEXT NOT NULL ,"+
                "descripcion TEXT ,"+
                "created_at DATETIME NOT NULL ,"+
                "updated_at DATETIME NOT NULL)");

        db.execSQL("CREATE TABLE IF NOT EXISTS Persona ("+
                "ci INTEGER PRIMARY KEY NOT NULL,"+
                "nombre TEXT NOT NULL,"+
                "phone TEXT ,"+
                "rol TEXT DEFAULT 'VISITANTE',"+
                "created_at DATETIME NOT NULL ,"+
                "updated_at DATETIME NOT NULL)");

        db.execSQL("CREATE TABLE IF NOT EXISTS Actividad ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre TEXT NOT NULL,"+
                "descripcion TEXT NOT NULL,"+
                "fecha_inicio DATETIME NOT NULL ,"+
                "fecha_final DATETIME NOT NULL , "+
                "created_at DATETIME NOT NULL ,"+
                "updated_at DATETIME NOT NULL)");

        db.execSQL("CREATE TABLE IF NOT EXISTS RelacionFamiliar ("+
                "ci_persona_1 INTEGER NOT NULL,"+
                "ci_persona_2 INTEGER NOT NULL,"+
                "tipo_relacion_id INTEGER NOT NULL,"+
                "created_at DATETIME NOT NULL ,"+
                "updated_at DATETIME NOT NULL,"+
                "FOREIGN KEY (ci_persona_1) REFERENCES Persona(ci)," +
                "FOREIGN KEY (ci_persona_2) REFERENCES Persona(ci), "+
                "FOREIGN KEY (tipo_relacion_id) REFERENCES TipoRelacionFamiliar(id))");

        db.execSQL("CREATE TABLE IF NOT EXISTS AsignaCargo ("+
                "persona_id INTEGER NOT NULL ,"+
                "cargo_id INTEGER NOT NULL ,"+
                "fecha_inicio DATETIME NOT NULL ,"+
                "fecha_final DATETIME NOT NULL , "+
                "estado INTEGER DEFAULT 1,"+
                "created_at DATETIME NOT NULL ,"+
                "updated_at DATETIME NOT NULL,"+
                "FOREIGN KEY (persona_id) REFERENCES Persona(ci)," +
                "FOREIGN KEY (cargo_id) REFERENCES Cargo(id) )");

        db.execSQL("CREATE TABLE IF NOT EXISTS Visita ("+
                "ci_persona_1 INTEGER NOT NULL,"+
                "ci_persona_2 INTEGER NOT NULL,"+
                "tipo_relacion_id INTEGER NOT NULL,"+
                "created_at DATETIME NOT NULL ,"+
                "updated_at DATETIME NOT NULL,"+
                "FOREIGN KEY (ci_persona_1) REFERENCES Persona(ci)," +
                "FOREIGN KEY (ci_persona_2) REFERENCES Persona(ci), "+
                "FOREIGN KEY (tipo_relacion_id) REFERENCES TipoRelacionFamiliar(id))");

        db.execSQL("CREATE TABLE IF NOT EXISTS NotaIngreso ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "actividad_id INTEGER NOT NULL ,"+
                "titulo TEXT NOT NULL ,"+
                "total INTEGER NOT NULL ,"+
                "created_at DATETIME NOT NULL ,"+
                "updated_at DATETIME NOT NULL,"+
                "FOREIGN KEY (actividad_id) REFERENCES Actividad(id))");

        db.execSQL("CREATE TABLE IF NOT EXISTS DetalleIngreso ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nota_ingreso_id INTEGER NOT NULL ,"+
                "ingreso_id INTEGER NOT NULL ,"+
                "monto INTEGER NOT NULL ,"+
                "created_at DATETIME NOT NULL ,"+
                "updated_at DATETIME NOT NULL ,"+
                "FOREIGN KEY (nota_ingreso_id) REFERENCES NotaIngreso(id),"+
                "FOREIGN KEY (ingreso_id) REFERENCES Ingreso(id))");
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     *
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Persona");
        onCreate(db);
    }
}
