package com.jonatan.church.Controller;

import com.jonatan.church.Model.Actividad;
import com.jonatan.church.View.IActividadView;

public class ActividadController implements IActividadController{
    private Actividad actividad;
    private IActividadView actividadView;
    public ActividadController(IActividadView actividadView){
        this.actividadView = actividadView;
        this.actividad = new Actividad(actividadView.getContext());
    }
    @Override
    public void save() {
        this.actividad.setData(actividadView.getData());
        int codeSave = this.actividad.isValido();
        if (codeSave == 0){ // le falta nombre
            this.actividad.save();
            this.actividadView.OnSaveSuccess("Actividad Creada");
        }
    }
}
