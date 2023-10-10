package com.jonatan.church;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jonatan.church.View.ActividadActivity;
import com.jonatan.church.View.PersonaActivity;

public class MainActivity extends AppCompatActivity {
    Button btnPersona, btnActividad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPersona = findViewById(R.id.btnPersona);
        btnActividad = findViewById(R.id.btnActividad);
        btnPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PersonaActivity.class);
                startActivity(intent);
            }
        });

        btnActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActividadActivity.class);
                startActivity(intent);
            }
        });
    }
}