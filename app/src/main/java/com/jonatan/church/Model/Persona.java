package com.jonatan.church.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.jonatan.church.View.PersonaActivity;
import com.jonatan.church.db.DbHelper;
import com.jonatan.church.db.DbPersona;

import java.util.Map;

public class Persona implements IPersona {

    private String nombre,ci,phone;
    private int id, rol;
    DbPersona dbPersona;
    /**
     * Usuario Visitante
     */
    public Persona(Context context){
        this.nombre = String.valueOf(' ');
        this.ci = String.valueOf(' ');
        this.id = -1;
        this.rol = 0;
        this.phone = null;
        this.dbPersona = new DbPersona(context);
    }
    public long save(){
        return this.dbPersona.insertPersona(getCi(),getNombre(),getPhone(),getRol());
    }
      @Override
    public String getNombre() {
        return this.nombre;
    }
    @Override
    public String getCi() {
        return this.ci;
    }
    @Override
    public int getRol() {
        return this.rol;
    }
    @Override
    public String getPhone() {
        return this.phone;
    }
    @Override
    public void updateTipoUsuario() {

    }
    @Override
    public int isValido() {
        if (TextUtils.isEmpty( getCi() ) ) {
            return 0;
        } else if (TextUtils.isEmpty( getNombre())) {
            return 1;
        } else if (getRol()==1) {  //es miembro?
            return (TextUtils.isEmpty( getPhone())) ?2:-1;
        } else {
            return -2;
        }
    }
    @Override
    public void setData(Map<String, Object> data) {
        Log.d("data from view", data.toString());
        this.ci = (String) data.get("ci");
        this.nombre = (String) data.get("nombre");
        this.rol = (Boolean) data.get("rol") ? 1 : 0;
        if (this.rol == 1) {
            this.phone = (String) data.get("phone");
        }
    }
}
