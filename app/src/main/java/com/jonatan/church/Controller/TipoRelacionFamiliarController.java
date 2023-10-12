package com.jonatan.church.Controller;

import android.util.Log;

import com.jonatan.church.Model.Persona;
import com.jonatan.church.Model.TipoRelacionFamiliar;
import com.jonatan.church.View.IPersonaView;
import com.jonatan.church.View.ITipoRelacionFamiliarView;

import java.util.ArrayList;

public class TipoRelacionFamiliarController implements ITipoRelacionFamiliarController {
    private TipoRelacionFamiliar tipoRelacionFamiliar;    //model
    private ITipoRelacionFamiliarView tipoRelacionFamiliarView;    //view
    public TipoRelacionFamiliarController(ITipoRelacionFamiliarView tipoRelacionFamiliarView){
        this.tipoRelacionFamiliarView = tipoRelacionFamiliarView;
        this.tipoRelacionFamiliar =  new TipoRelacionFamiliar(tipoRelacionFamiliarView.getContext());

        Log.d("lista",this.tipoRelacionFamiliar.getAll().toString());
    }

    @Override
    public void save() {
        this.tipoRelacionFamiliar.setData(this.tipoRelacionFamiliarView.getData());
        int codeSave = this.tipoRelacionFamiliar.isValido();
        if (codeSave == 0){ // le falta nombre
            this.tipoRelacionFamiliarView.OnSaveError(" Por favor ingrese nombre");
        } else {    // ok
            long code = this.tipoRelacionFamiliar.save();
            if(code == -1){// code==-1 constrain
                this.tipoRelacionFamiliarView.OnSaveError("Error");
            }else{  //code==0 ok
                this.tipoRelacionFamiliarView.OnSaveSuccess("Tipo Relacion Familiar Creada");
            }

        }

    }

    @Override
    public ArrayList<TipoRelacionFamiliar> getAllTipoRelacion() {
        Log.d("lista",this.tipoRelacionFamiliar.getAll().toString());
        return null;
    }


}
