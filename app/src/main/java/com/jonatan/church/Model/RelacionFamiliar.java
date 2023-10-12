package com.jonatan.church.Model;

import android.content.Context;
import android.text.TextUtils;

import com.jonatan.church.db.DbRelacionFamiliar;
import com.jonatan.church.db.DbTipoRelacionFamiliar;

import java.util.ArrayList;
import java.util.Map;

public class RelacionFamiliar implements IRelacionFamiliar{
    private int id, ci_persona_1, ci_persona_2, tipo_relacion_id;
    private DbRelacionFamiliar dbRelacionFamiliar;

    public RelacionFamiliar(Context context){
        this.id = -1;
        this.ci_persona_1 = -1;
        this.ci_persona_2 = -1;
        this.tipo_relacion_id = -1;
        this.dbRelacionFamiliar = new DbRelacionFamiliar(context);
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
    public int getCiPersona1() {
        return this.ci_persona_1;
    }

    @Override
    public int getCiPersona2() {
        return this.ci_persona_2;
    }

    @Override
    public int getIdTipoRelacionFamiliar() {
        return this.tipo_relacion_id;
    }

    @Override
    public void setData(Map<String, Object> data) {
        this.ci_persona_1 = (int) data.get("ci_persona_1");
        this.ci_persona_2 = (int) data.get("ci_persona_2");
        this.tipo_relacion_id = (int) data.get("tipo_relacion_id");
    }

    @Override
    public long save() {
        return this.dbRelacionFamiliar.insertRelacionFamiliar(getCiPersona1(),getCiPersona2(),getIdTipoRelacionFamiliar());
    }

    @Override
    public int isValido() {
        if (getCiPersona1() < 0 ) { // cipersona no validp
            return 0;
        } else if (getCiPersona2() < 0){
            return 1;
        } else if (getIdTipoRelacionFamiliar()<1) {
            return 2;
        } else {    //ok
            return -1;
        }
    }
}
