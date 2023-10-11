package com.jonatan.church.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jonatan.church.R;

import java.util.Map;

public class RelacionFamiliar_Activity extends AppCompatActivity implements IRelacionFamiliarView {
    Button btnSave;
    EditText ciPersona1, ciPersona2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relacion_familiar);

        btnSave = findViewById(R.id.btnSaveRelacionFamiliar);
        ciPersona1 = findViewById(R.id.txtCIPersona1);
        ciPersona2 = findViewById(R.id.txtCIPersona2);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public Map<String, Object> getData() {
        return null;
    }

    @Override
    public void OnSaveSuccess(String message) {

    }

    @Override
    public void OnSaveError(String message) {

    }

    @Override
    public Context getContext() {
        return null;
    }
}