package com.jonatan.church;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jonatan.church.View.ActividadActivity;
import com.jonatan.church.View.PersonaActivity;
import com.jonatan.church.View.RelacionFamiliarActivity;
import com.jonatan.church.View.TipoRelacionFamiliarActivity;

public class MainActivity extends AppCompatActivity {
    Button btnPersona, btnActividad, btnTipoRelacionFamiliar, btnRelacionFamiliar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPersona = findViewById(R.id.btnPersona);
        btnActividad = findViewById(R.id.btnActividad);
        btnTipoRelacionFamiliar = findViewById(R.id.btnTipoRelacionFamiliar);
        btnRelacionFamiliar = findViewById(R.id.btnRelacionFamiliar);
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

        btnTipoRelacionFamiliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TipoRelacionFamiliarActivity.class);
                startActivity(intent);
            }
        });

        btnRelacionFamiliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RelacionFamiliarActivity.class);
                startActivity(intent);
            }
        });
    }
}