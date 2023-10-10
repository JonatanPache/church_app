package com.jonatan.church.Model;

import java.util.Date;
import java.util.Map;

public interface IActividad {
    int getIdActividad();
    String getNombre();
    String getDescripcion();
    String getFechaInicio();
    String getFechaFinal();
    void setData(Map<String, Object> data);
    long save();
    int isValido();
}
