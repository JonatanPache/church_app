package com.jonatan.church.Model;

import java.util.ArrayList;
import java.util.Map;

public interface IRelacionFamiliar {
    int getId();
    void setId(int id);
    int getCiPersona1();
    int getCiPersona2();
    int getIdTipoRelacionFamiliar();
    void setData(Map<String, Object> data);
    long save();
    int isValido();
}
