package com.jonatan.church.View;

import android.content.Context;

import java.util.Map;

public interface ITipoRelacionFamiliarView {

    Map<String, Object> getData();
    void OnSaveSuccess( String message);
    void OnSaveError( String message);
    Context getContext();
}
