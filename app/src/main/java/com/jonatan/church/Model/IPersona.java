package com.jonatan.church.Model;

import java.util.Map;

public interface IPersona {

    String getNombre();
    String getCi();
    int getRol();
    String getPhone();
    void updateTipoUsuario();
    int isValido();
    void setData(Map<String, Object> data);
    long save();
}
