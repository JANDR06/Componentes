package es.ieslavereda.componentes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox;
    private TextView textViexCB;
    private RadioGroup sexoRG;
    private TextView textViewS;
    private ArrayList<Usuario> usuarios;
    private TextInputEditText nombre;
    private TextInputEditText apellidos;
    private Button aceptar;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.checkBox01);
        textViexCB = findViewById(R.id.textViewCB);
        sexoRG = findViewById(R.id.radioGroup);
        textViewS = findViewById(R.id.textViewSeleccion);
        nombre = findViewById(R.id.nombre);
        apellidos = findViewById(R.id.apellidos);
        aceptar = findViewById(R.id.buttonAdd);
        spinner = findViewById(R.id.spinner);

        if (savedInstanceState != null) {
            usuarios = (ArrayList<Usuario>) savedInstanceState.getSerializable("usuarios");

        } else {
            usuarios = new ArrayList<>();
            usuarios.add(new Usuario("Alejandro", "Jorge Pastor"));
            usuarios.add(new Usuario("Xavier", "Rosillo Guerrero"));
        }

        ArrayAdapter<Usuario> miAdaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, usuarios);
        spinner.setAdapter(miAdaptador);

        checkBox.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkBox.isChecked()) {
                    textViexCB.setText("CheckBox activado");

                } else {
                    textViexCB.setText("CheckBox desactivado");
                }
            }
        });

        sexoRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButtonHombre)  {
                    textViewS.setText("HOMBRE");
                } else if (i == R.id.radioButtonMujer) {
                    textViewS.setText("MUJER");
                } else {
                    textViewS.setText("OTRO");
                }

            }
        });

    }

    @Override
    protected void onSaveInstanceState (@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("usuario", usuarios);
    }
}