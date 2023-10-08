package com.jonatan.church.Model;

public class Usuario implements IUsuario{

    private String nombre,ci;
    private int id, tipoUsuario, phone;

    /**
     * Usuario Visitante
     */
    public Usuario(){
        this.nombre = String.valueOf(' ');
        this.ci = String.valueOf(' ');
        this.id = -1;
        this.tipoUsuario = -1;
    }
    public int saveVisita(){
        return 0;
    }
    public int saveMiembro(){
        return 0;
    }
    @Override
    public int getId() {
        return this.id;
    }
    @Override
    public String getNombre() {
        return this.nombre;
    }
    @Override
    public String getCi() {
        return this.ci;
    }
    @Override
    public int getTipoUsuario() {
        return this.tipoUsuario;
    }
    @Override
    public int getPhone() {
        return this.phone;
    }
    @Override
    public void updateTipoUsuario() {

    }
    @Override
    public int isValido() {
        return 0;
    }
    @Override
    public void setData(String data) {

    }
}
