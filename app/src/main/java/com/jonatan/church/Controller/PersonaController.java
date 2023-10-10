package com.jonatan.church.Controller;

import android.content.Context;

import com.jonatan.church.Model.Persona;
import com.jonatan.church.View.IPersonaView;

public class PersonaController implements IPersonaController {
    private Persona persona;    //model
    private IPersonaView usuarioView;    //view
    public PersonaController(IPersonaView usuarioView){
        this.usuarioView = usuarioView;
        this.persona =  new Persona(usuarioView.getContext());
    }

    @Override
    public void save() {
        persona.setData(usuarioView.getData());
        int codeSave = persona.isValido();
        if (codeSave == 0){ // le falta nombre
            usuarioView.OnSaveError(" Por favor ingrese CI correcto");
        } else if (codeSave == 1) {
            usuarioView.OnSaveError("Por favor ingrese nombre");
        } else if (codeSave == 2){
            usuarioView.OnSaveError("Please enter phone");
        } else if ( codeSave == -1){ // es miembro
            persona.saveMiembro();
            usuarioView.OnSaveSuccess("Create persona Successful");
        } else {    // es visita
            long code = persona.saveVisita();
            if(code == -1){// code==-1 constrain
                usuarioView.OnSaveError("Persona con CI duplicado");
            }else{  //code==0 ok
                usuarioView.OnSaveSuccess("Persona Creada");
            }

        }

    }

    @Override
    public void registrarMiembro() {

    }
}
