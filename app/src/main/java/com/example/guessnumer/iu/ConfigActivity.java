package com.example.guessnumer.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guessnumer.R;
import com.example.guessnumer.data.PartidaGuessNumer;

/**
 * <h1>Proyecto GuessNumer</h1>
 * Esta es la ConfigActivity que se encarga de :
 * <ol>
 *     <li>Recoger el nombre del usuario y el numero de intentos que quiere realizar</li>
 *     <li>Crear un crea un bundle con el objeto de la clase PartidaGuessNumer con el usuario y los intentos y la pasa en un intent a la siguiente activity</li>
 * </ol>
 *
 * @author Daniel Ruiz
 * @version 1.0
 */
public class ConfigActivity extends AppCompatActivity {

    private EditText etUsuario;
    private  EditText etNumTries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        etUsuario = findViewById(R.id.etUser);
        etNumTries = findViewById(R.id.etNumTries);
        Button btnJugar = findViewById(R.id.btnJugar);
        btnJugar.setOnClickListener(view -> sendInfoBundle());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        etNumTries = null;
        etUsuario = null;
    }

    public void sendInfoBundle() {
        Bundle bundleInfoJuego = new Bundle();
        if (etUsuario.getText().toString().trim().equals("") || etNumTries.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Uno o ambos campos se encuentran vacios por favor introduzca un valor", Toast.LENGTH_SHORT).show();
            return;
        }
        PartidaGuessNumer partida = new PartidaGuessNumer(etUsuario.getText().toString(),Integer.parseInt(etNumTries.getText().toString()),false);
        bundleInfoJuego.putParcelable("partida", partida);
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtras(bundleInfoJuego);
        startActivity(intent);
    }
}