package com.jonatan.church.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jonatan.church.Controller.ActividadController;
import com.jonatan.church.Controller.IActividadController;
import com.jonatan.church.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class ActividadActivity extends AppCompatActivity implements IActividadView{
    EditText txtName, txtDetalle, txtHoraStart,txtHoraEnd,txtDate;
    Button btnSave;
    IActividadController actividadController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad);

        actividadController = new ActividadController(this);

        txtName = findViewById(R.id.txtNombreActividad);
        txtDetalle = findViewById(R.id.txtDetalleActividad);
        txtHoraStart = findViewById(R.id.txtHoraInicio);
        txtHoraEnd = findViewById(R.id.txtHoraFinal);
        txtDate = findViewById(R.id.txtFecha);
        btnSave = findViewById(R.id.btnSaveActividad);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actividadController.save();
            }
        });
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> userData = new HashMap<>();
        userData.put("nombre", txtName.getText().toString());
        userData.put("descripcion", txtDetalle.getText().toString());

        String fechaStr = txtDate.getText().toString();
        String horaStartStr = txtHoraStart.getText().toString();
        String horaEndStr = txtHoraEnd.getText().toString();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

            Date fecha = dateFormat.parse(fechaStr);
            Date horaStart = timeFormat.parse(horaStartStr);
            Date horaEnd = timeFormat.parse(horaEndStr);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);

            Date datetimeStart = new Date(calendar.getTimeInMillis() + horaStart.getTime());
            Date datetimeEnd = new Date(calendar.getTimeInMillis() + horaEnd.getTime());

            SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String datetimeStartStr = datetimeFormat.format(datetimeStart);
            String datetimeEndStr = datetimeFormat.format(datetimeEnd);

            userData.put("fecha_inicio", datetimeStartStr);
            userData.put("fecha_final", datetimeEndStr);
        } catch (ParseException e) {
            OnSaveError(e.getMessage());
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