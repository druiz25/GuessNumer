package com.example.guessnumer.iu;
import com.example.guessnumer.data.PartidaGuessNumer;
import com.example.guessnumer.databinding.ActivityPlayBinding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Random;

/**
 * <h1>Proyecto GuessNumer</h1>
 * Esta es la PlayActivity que se encarga de :
 * <ol>
 *     <li>Recoger el bundle con el usuario y numero de intentos de la ConfigActivity</li>
 *     <li>Aqui se intenta adivinar el numero mientras se comprueba si se acerto o no, y si se supera el numero de intentos</li>
 *     <li>Al cumplir una de las dos condiciones para terminar la partida que son acertar el numero o quedarte sin aciertos, se creara un bundle para rellenar los valores de numero a adivinar, los intentos fallidos y la condicion de la partida</li>
 * </ol>
 *
 * @author Daniel Ruiz
 * @version 2.0
 */
public class PlayActivity extends AppCompatActivity {

    private ActivityPlayBinding bind;
    private final Random rnd = new Random();
    private Integer numVecFall;
    private Integer numAdiv;
    private Integer numInten;
    private String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityPlayBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        Bundle bundle = getIntent().getExtras();
        PartidaGuessNumer partida = bundle.getParcelable("partida");
        numInten = partida.getNumTries();
        usuario = partida.getUsuario();
        numAdiv = rnd.nextInt(100-1) + 1;
        numVecFall = 0;
        bind.btnResponder.setOnClickListener(view -> comprobarRespuesta());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind = null;
    }

    public void comprobarRespuesta() {
        if (bind.etRespuesta.getText().toString().trim().equals(""))
        {
            Toast.makeText(this, "Debe introducir un valor antes de preguntar si es correcto", Toast.LENGTH_SHORT).show();
            return;
        }
        if (bind.etRespuesta.getText().toString().equals(numAdiv.toString())) {
            Bundle bundleFinPartida = new Bundle();
            PartidaGuessNumer resultadoFinal = new  PartidaGuessNumer(usuario, numInten, numVecFall ,numAdiv , true);
            bundleFinPartida.putParcelable("partida", resultadoFinal);
            Intent intent = new Intent(this, EndPlayActivity.class);
            intent.putExtras(bundleFinPartida);
            startActivity(intent);
        }else {
            if (Integer.parseInt(bind.etRespuesta.getText().toString()) < numAdiv) {
                bind.tvResultado.setText("El numero introducido es menor que el numero secreto");
            }else {
                bind.tvResultado.setText("El numero introducido es mayor que el numero secreto");
            }
            numInten--;
            numVecFall++;
        }
        if (numInten.equals(0))
        {
            Bundle bundleFinPartida = new Bundle();
            PartidaGuessNumer resultadoFinal = new  PartidaGuessNumer(usuario, numInten, numVecFall ,numAdiv , false);
            bundleFinPartida.putParcelable("partida", resultadoFinal);
            Intent intent = new Intent(this, EndPlayActivity.class);
            intent.putExtras(bundleFinPartida);
            startActivity(intent);
        }
        bind.etRespuesta.setText("");
    }
}