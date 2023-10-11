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
        if (codeSave == 0) { // nombre vacio
            this.actividadView.OnSaveError("Ingrese un Nombre");
        } else if (codeSave == 1) { //descripcion vacio
            this.actividadView.OnSaveError("Ingrese una descripcion");
        } else if (codeSave == 2) { // fecha no ingresada
            this.actividadView.OnSaveError("Ingrese la fecha de la actividad");
        } else {
            this.actividad.save();
            this.actividadView.OnSaveSuccess("Actvidad creada exitosamente");
        }
    }
}
