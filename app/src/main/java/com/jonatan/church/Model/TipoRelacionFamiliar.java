package com.jonatan.church.Model;

import android.content.Context;
import android.text.TextUtils;

import com.jonatan.church.db.DbActividad;
import com.jonatan.church.db.DbTipoRelacionFamiliar;

import java.util.ArrayList;
import java.util.Map;

public class TipoRelacionFamiliar implements ITipoRelacionFamiliar{
    private int id;
    private String nombre;
    private DbTipoRelacionFamiliar dbTipoRelacionFamiliar;

    public TipoRelacionFamiliar(Context context){
        this.id = 0;
        this.nombre = String.valueOf(' ');
        this.dbTipoRelacionFamiliar = new DbTipoRelacionFamiliar(context);
    }

    public TipoRelacionFamiliar(){
        this.id = 0;
        this.nombre = String.valueOf(' ');
    }
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setData(Map<String, Object> data) {
        this.nombre = (String) data.get("nombre");
    }

    @Override
    public ArrayList<TipoRelacionFamiliar> getAll() {
        ArrayList<Map<String, Object>> arrayList = this.dbTipoRelacionFamiliar.getAllTipoRelacionFamiliar();
        ArrayList<TipoRelacionFamiliar> tipoRelacionFamiliarList = new ArrayList<>();

        for (Map<String, Object> map : arrayList) {
            TipoRelacionFamiliar tipoRelacionFamiliar = new TipoRelacionFamiliar();
            tipoRelacionFamiliar.setId((int) map.get("id"));
            tipoRelacionFamiliar.setNombre((String) map.get("nombre"));
            tipoRelacionFamiliarList.add(tipoRelacionFamiliar);
        }

        return tipoRelacionFamiliarList;
    }

    @Override
    public long save() {
        return this.dbTipoRelacionFamiliar.insertTipoRelacionFamiliar(getNombre());
    }

    @Override
    public int isValido() {
        if (TextUtils.isEmpty( getNombre() ) ) {
            return 0;
        } else {
            return -1;
        }
    }
}
