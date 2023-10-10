package com.jonatan.church.Model;

import android.content.Context;
import android.util.Log;

import com.jonatan.church.db.DbActividad;
import com.jonatan.church.db.DbPersona;

import java.util.Date;
import java.util.Map;

public class Actividad implements IActividad{
    private int id;
    private String nombre, descripcion, fechaInicio, fechaFinal;
    private DbActividad dbActividad;

    public Actividad(Context context){
        this.id = 0;
        this.nombre = String.valueOf(' ');
        this.descripcion = String.valueOf(' ');
        this.fechaInicio = String.valueOf(' ');
        this.fechaFinal = String.valueOf(' ');
        this.dbActividad = new DbActividad(context);
    }
    @Override
    public int getIdActividad() {
        return this.id;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getDescripcion() {
        return this.descripcion;
    }
    @Override
    public String getFechaInicio() {return this.fechaInicio;}
    @Override
    public String getFechaFinal() {return this.fechaFinal;}
    @Override
    public void setData(Map<String, Object> data) {
        this.nombre = (String) data.get("nombre");
        this.descripcion = (String) data.get("descripcion");
        this.fechaInicio = (String) data.get("fecha_inicio");
        this.fechaFinal = (String) data.get("fecha_final");
    }

    @Override
    public long save() {
        return this.dbActividad.insertActividad(getNombre(),getDescripcion(),getFechaInicio(),getFechaFinal());
    }

    @Override
    public int isValido() {
        return 0;
    }
}
