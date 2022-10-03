package com.example.guessnumer.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.guessnumer.data.PartidaGuessNumer;
import com.example.guessnumer.databinding.ActivityConfigBinding;

/**
 * <h1>Proyecto GuessNumer</h1>
 * Esta es la ConfigActivity que se encarga de :
 * <ol>
 *     <li>Recoger el nombre del usuario y el numero de intentos que quiere realizar</li>
 *     <li>Crear un crea un bundle con el objeto de la clase PartidaGuessNumer con el usuario y los intentos y la pasa en un intent a la siguiente activity</li>
 * </ol>
 *
 * @author Daniel Ruiz
 * @version 2.0
 */
public class ConfigActivity extends AppCompatActivity {

    private ActivityConfigBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityConfigBinding.inflate(getLayoutInflater());
        View viewB = bind.getRoot();
        setContentView(viewB);
        bind.btnJugar.setOnClickListener(view -> sendInfoBundle());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind = null;
    }

    public void sendInfoBundle() {
        Bundle bundleInfoJuego = new Bundle();
        if (bind.etUser.getText().toString().trim().equals("") || bind.etNumTries.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Uno o ambos campos se encuentran vacios por favor introduzca un valor", Toast.LENGTH_SHORT).show();
            return;
        }
        PartidaGuessNumer partida = new PartidaGuessNumer(bind.etUser.getText().toString(),Integer.parseInt(bind.etNumTries.getText().toString()),false);
        bundleInfoJuego.putParcelable("partida", partida);
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtras(bundleInfoJuego);
        startActivity(intent);
    }
}