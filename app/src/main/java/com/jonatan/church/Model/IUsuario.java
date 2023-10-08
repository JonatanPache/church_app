package com.jonatan.church.Model;

public interface IUsuario {

    int getId();
    String getNombre();
    String getCi();
    int getTipoUsuario();
    int getPhone();
    void updateTipoUsuario();
    int isValido();
    void setData(String data);
    int saveVisita();
    int saveMiembro();
}
