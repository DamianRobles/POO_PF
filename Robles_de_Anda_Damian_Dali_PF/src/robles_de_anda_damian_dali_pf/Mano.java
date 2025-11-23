package robles_de_anda_damian_dali_pf;

import java.util.ArrayList;

public class Mano {

    // * campos
    private ArrayList<Carta> cartasEnMano;

    // * constructor
    public Mano() {
        this.cartasEnMano = new ArrayList<Carta>();
    }

    // * metodo para agregar carta a la mano
    public void agregarCarta(Carta carta) {
        this.cartasEnMano.add(carta);
    }

    // * metodo para obtener las cartas en la mano
    public ArrayList<Carta> obtenerCartasMano() {
        return cartasEnMano;
    }

    // * metodo para limpiar la mano
    public void limpiarMano() {
        this.cartasEnMano.clear();
    }

    // * metodo para calcular el puntaje de una mano
    public int calcularPuntaje(){
        int puntaje = 0;
        for(int i = 0; i < cartasEnMano.size(); i++){
            puntaje += cartasEnMano.get(i).getValorNumerico();
        }
        return puntaje;
    }

}
