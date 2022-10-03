package com.example.guessnumer.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.example.guessnumer.data.PartidaGuessNumer;
import com.example.guessnumer.databinding.ActivityEndPlayBinding;

/**
 * <h1>Proyecto GuessNumer</h1>
 * Esta es la EndPlayActivity que se encarga de :
 * <ol>
 *     <li>Recoger el nombre del usuario y el numero de intentos que quiere realizar</li>
 *     <li>Crear un escuchador/listener del evento OnClick</li>
 *     <li>Crear un crea un bundle con el objeto de la clase PartidaGuessNumer con el usuario y los intentos y la pasa en un intent a la siguiente activity</li>
 * </ol>
 *
 * @author Daniel Ruiz
 * @version 2.0
 */
public class EndPlayActivity extends AppCompatActivity {
    private ActivityEndPlayBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityEndPlayBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        Bundle bundle = getIntent().getExtras();
        PartidaGuessNumer partida = bundle.getParcelable("partida");
        resultadoPartida(partida);
    }

    @SuppressLint("SetTextI18n")
    public void resultadoPartida(PartidaGuessNumer partida)
    {
        if (partida.isVictoria()) {
            bind.tvTextoFinal.setText("!Felicidades¡ Acertaste despues de fallar "+partida.getVecFalladas()+" veces.");
        }else {
            bind.tvTextoFinal.setText("!Fallaste¡ el número secreto era "+partida.getNumSecreto());
        }
    }
}