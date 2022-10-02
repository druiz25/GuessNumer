package com.example.guessnumer.data;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/**
 * <h1>Proyecto GuessNumer</h1>
 * Esta es la clase PartidaGuessNumer que se encarga de :
 * <ol>
 *     <li>Recoger todos los datos necesarios para la partida</li>
 *     <li>Aqui se intenta adivinar el numero mientras se comprueba si se acerto o no, y si se supera el numero de intentos</li>
 *     <li>Al cumplir una de las dos condiciones para terminar la partida que son acertar el numero o quedarte sin aciertos, se creara un bundle para rellenar los valores de numero a adivinar, los intentos fallidos y la condicion de la partida</li>
 * </ol>
 *
 * @author Daniel Ruiz
 * @version 1.0
 */
public class PartidaGuessNumer implements Serializable, Parcelable {
    private final String usuario;
    private Integer numTries;
    private Integer vecFalladas;
    private Integer numSecreto;
    private  boolean victoria;


    /**
     * Este constructor solo se usara al principio porque el numero de fallos y el numero secreto no se crean
     * hasta que empieza la partida
     */
    public PartidaGuessNumer(String usuario, Integer numTries, boolean victoria) {
        this.usuario = usuario;
        this.numTries = numTries;
        this.numSecreto = null;
        this.victoria = victoria;
    }

    public PartidaGuessNumer(String usuario, Integer numTries, Integer vecFalladas, Integer numSecreto, boolean victoria) {
        this.usuario = usuario;
        this.numTries = numTries;
        this.vecFalladas = vecFalladas;
        this.numSecreto = numSecreto;
        this.victoria = victoria;
    }

    public boolean isVictoria() {
        return victoria;
    }

    public String getUsuario() {
        return usuario;
    }

    public Integer getNumTries() {
        return numTries;
    }

    public void setNumTries(Integer numTries) {
        this.numTries = numTries;
    }

    public Integer getNumSecreto() {
        return numSecreto;
    }

    public Integer getVecFalladas() {
        return vecFalladas;
    }

    public void setVecFalladas(Integer vecFalladas) {
        this.vecFalladas = vecFalladas;
    }

    public void setNumSecreto(Integer numSecreto) {
        this.numSecreto = numSecreto;
    }


    //region metodos de la interfaz Parceable

    public static final Creator<PartidaGuessNumer> CREATOR = new Creator<PartidaGuessNumer>() {
        @Override
        public PartidaGuessNumer createFromParcel(Parcel in) {
            return new PartidaGuessNumer(in);
        }

        @Override
        public PartidaGuessNumer[] newArray(int size) {
            return new PartidaGuessNumer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(usuario);
        if (numTries == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(numTries);
        }
        if (vecFalladas == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(vecFalladas);
        }
        if (numSecreto == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(numSecreto);
        }
        parcel.writeByte((byte) (victoria ? 1 : 0));
    }

    protected PartidaGuessNumer(Parcel in) {
        usuario = in.readString();
        if (in.readByte() == 0) {
            numTries = null;
        } else {
            numTries = in.readInt();
        }
        if (in.readByte() == 0) {
            vecFalladas = null;
        } else {
            vecFalladas = in.readInt();
        }
        if (in.readByte() == 0) {
            numSecreto = null;
        } else {
            numSecreto = in.readInt();
        }
        victoria = in.readByte() != 0;
    }


    //endregion
}
