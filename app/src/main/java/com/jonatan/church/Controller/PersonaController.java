package com.jonatan.church.Controller;

import android.content.Context;

import com.jonatan.church.Model.Persona;
import com.jonatan.church.View.IPersonaView;

public class PersonaController implements IPersonaController {
    private Persona persona;    //model
    private IPersonaView personaView;    //view
    public PersonaController(IPersonaView personaView){
        this.personaView = personaView;
        this.persona =  new Persona(personaView.getContext());
    }

    @Override
    public void save() {
        persona.setData(personaView.getData());
        int codeSave = persona.isValido();
        if (codeSave == 0){ // le falta nombre
            personaView.OnSaveError(" Por favor ingrese CI correcto");
        } else if (codeSave == 1) {
            personaView.OnSaveError("Por favor ingrese nombre");
        } else if (codeSave == 2){
            personaView.OnSaveError("Please enter phone");
        } else if ( codeSave == -1){ // es miembro
            long code = persona.save();
            if (code == -1) {
                personaView.OnSaveError("Miembro con Duplicado CI");
            } else {
                personaView.OnSaveSuccess("Miembro creado");
            }
        } else {    // es visita
            long code = persona.save();
            if(code == -1){// code==-1 constrain
                personaView.OnSaveError("Persona Visitante con CI duplicado");
            }else{  //code==0 ok
                personaView.OnSaveSuccess("Persona Visitante Creada");
            }

        }

    }

    @Override
    public void registrarMiembro() {

    }
}
