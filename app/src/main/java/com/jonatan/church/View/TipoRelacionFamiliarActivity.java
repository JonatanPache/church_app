package com.jonatan.church.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jonatan.church.Controller.ITipoRelacionFamiliarController;
import com.jonatan.church.Controller.TipoRelacionFamiliarController;
import com.jonatan.church.R;

import java.util.HashMap;
import java.util.Map;

public class TipoRelacionFamiliarActivity extends AppCompatActivity implements ITipoRelacionFamiliarView{
    ITipoRelacionFamiliarController tipoRelacionFamiliarController;
    Button btnSave;
    EditText txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_relacion_familiar);

        tipoRelacionFamiliarController = new TipoRelacionFamiliarController(this);
        btnSave = findViewById(R.id.btnSaveTipoRelacionFamiliar);
        txtName = findViewById(R.id.txtNombreTipoRelacionFamiliar);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipoRelacionFamiliarController.save();
            }
        });
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> userData = new HashMap<>();
        userData.put("nombre", txtName.getText().toString());
        return userData;
    }

    @Override
    public void OnSaveSuccess(String message) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnSaveError(String message) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return this;
    }
}