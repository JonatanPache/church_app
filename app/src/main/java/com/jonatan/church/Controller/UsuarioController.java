package com.jonatan.church.Controller;

import com.jonatan.church.Model.Usuario;
import com.jonatan.church.View.UsuarioView;

public class UsuarioController implements IUsuarioController{
    private Usuario usuario;    //model
    private UsuarioView usuarioView;    //view
    public UsuarioController(UsuarioView usuarioView){
        this.usuarioView = usuarioView;
        this.usuario =  new Usuario();
    }
    @Override
    public void registrarVisita() {
        usuario.setData(usuarioView.getData());
        int codeUsuario = usuario.isValido();
        if (codeUsuario==0){ // le falta nombre

        }else{
            usuario.saveVisita();
            // mensaje en la view
        }

    }

    @Override
    public void registrarMiembro() {

    }
}
