package com.jonatan.church.Model;

import java.util.ArrayList;
import java.util.Map;

public interface ITipoRelacionFamiliar {
    int getId();
    void setId(int id);
    String getNombre();
    void setNombre(String nombre);
    void setData(Map<String, Object> data);

    ArrayList<TipoRelacionFamiliar> getAll();
    long save();
    int isValido();
}
