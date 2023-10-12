package com.jonatan.church.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.jonatan.church.Controller.IRelacionFamiliarController;
import com.jonatan.church.Controller.RelacionFamiliarController;
import com.jonatan.church.Model.TipoRelacionFamiliar;
import com.jonatan.church.R;
import java.util.List;
import java.util.Map;

public class RelacionFamiliarActivity extends AppCompatActivity implements IRelacionFamiliarView {
    private Button btnSave;
    private EditText ciPersona1, ciPersona2;
    private Spinner tipoRelacionSpinner;
    private TipoRelacionFamiliar tipoRelacionFamiliarModel;
    private List<TipoRelacionFamiliar> tipoRelacionList; // Debes llenar esta lista con los tipos de relación desde tu modelo
    private int selectedTipoRelacionId = -1; // Inicialmente no se ha seleccionado ninguno
    private IRelacionFamiliarController relacionFamiliarController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relacion_familiar);

        relacionFamiliarController = new RelacionFamiliarController(this);

        btnSave = findViewById(R.id.btnSaveRelacionFamiliar);
        ciPersona1 = findViewById(R.id.txtCIPersona1);
        ciPersona2 = findViewById(R.id.txtCIPersona2);
        tipoRelacionSpinner = findViewById(R.id.tipoRelacionSpinner);

        //instanciando el model de tipo relacion familiar
        tipoRelacionFamiliarModel = new TipoRelacionFamiliar(this);

        // Llena la lista de tipos de relación desde tu modelo
        tipoRelacionList = tipoRelacionFamiliarModel.getAll();

        // Crea un adaptador personalizado para mostrar solo los nombres en el Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return super.getView(position, convertView, parent);
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                return super.getDropDownView(position, convertView, parent);
            }
        };

        for (TipoRelacionFamiliar tipoRelacion : tipoRelacionList) {
            adapter.add(tipoRelacion.getNombre()); // Agrega solo el nombre al adaptador
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Configura el adaptador para el Spinner
        tipoRelacionSpinner.setAdapter(adapter);
        // Agrega un listener para manejar la selección del usuario
        tipoRelacionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Obtiene el objeto TipoRelacionFamiliar correspondiente
                TipoRelacionFamiliar selectedTipoRelacion = tipoRelacionList.get(position);

                // Actualiza el ID seleccionado
                selectedTipoRelacionId = selectedTipoRelacion.getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Cuando no se selecciona ningún elemento
            }
        });
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