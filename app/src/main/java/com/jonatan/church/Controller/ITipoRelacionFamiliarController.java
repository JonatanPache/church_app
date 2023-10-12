package com.jonatan.church.Controller;

import com.jonatan.church.Model.TipoRelacionFamiliar;

import java.util.ArrayList;

public interface ITipoRelacionFamiliarController {
    void save();

    ArrayList<TipoRelacionFamiliar> getAllTipoRelacion();
}
