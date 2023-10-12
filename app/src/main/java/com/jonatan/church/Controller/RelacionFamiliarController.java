package com.jonatan.church.Controller;

import com.jonatan.church.Model.Persona;
import com.jonatan.church.Model.RelacionFamiliar;
import com.jonatan.church.View.IPersonaView;
import com.jonatan.church.View.IRelacionFamiliarView;

public class RelacionFamiliarController implements IRelacionFamiliarController {
    private RelacionFamiliar relacionFamiliar;    //model
    private IRelacionFamiliarView relacionFamiliarView;    //view
    public RelacionFamiliarController(IRelacionFamiliarView relacionFamiliarView){
        this.relacionFamiliarView = relacionFamiliarView;
        this.relacionFamiliar =  new RelacionFamiliar(relacionFamiliarView.getContext());
    }

    @Override
    public void save() {
        this.relacionFamiliar.setData(this.relacionFamiliarView.getData());
        int codeSave = this.relacionFamiliar.isValido();
        if (codeSave == 0){ // le falta nombre
            this.relacionFamiliarView.OnSaveError(" Por favor ingrese un CI Persona 1 correcto");
        } else if (codeSave == 1) {
            this.relacionFamiliarView.OnSaveError("Por favor ingrese un CI Persona 1 correcto");
        } else if (codeSave == 2){
            this.relacionFamiliarView.OnSaveError("Por favor ingreso un Tipo de Relacion Familiar Correcto.");
        } else { // ok
            long code = this.relacionFamiliar.save();
            if (code == -1) {
                this.relacionFamiliarView.OnSaveError("Error");
            } else {
                this.relacionFamiliarView.OnSaveSuccess("Relacion Familiar Creado");
            }
        }
    }

}
