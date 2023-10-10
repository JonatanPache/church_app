package com.jonatan.church.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.jonatan.church.Controller.IPersonaController;
import com.jonatan.church.Controller.PersonaController;
import com.jonatan.church.R;

import java.util.HashMap;
import java.util.Map;

public class PersonaActivity extends AppCompatActivity implements IPersonaView {

    IPersonaController personaController;
    Button btnSave;
    EditText txtName, txtCi, txtPhone;
    Chip chk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona);

        personaController = new PersonaController(this);

        btnSave = findViewById(R.id.btnSave);

        txtCi = (EditText) findViewById(R.id.txtCi);
        txtName = (EditText)findViewById(R.id.txtNombre);
        txtPhone = (EditText) findViewById(R.id.txtPhone);
        chk = (Chip) findViewById(R.id.chip);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personaController.save();
            }
        });
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> userData = new HashMap<>();
        userData.put("ci", txtCi.getText().toString());
        userData.put("nombre", txtName.getText().toString());
        userData.put("rol", chk.isChecked());
        if (chk.isCheckable()) {
            userData.put("phone", txtPhone.getText().toString());
        }
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