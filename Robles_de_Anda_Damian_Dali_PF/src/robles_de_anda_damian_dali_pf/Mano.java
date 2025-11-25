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
        // * inicializar puntaje en 0
        int puntaje = 0;
        // * bandera para saber si hay un as en la mano
        boolean asEnMano = false;

        // * recorrer las cartas en la mano
        for(int i = 0; i < cartasEnMano.size(); i++){
            // * obtener carta en la posición i
            Carta carta = cartasEnMano.get(i);
            // * sumar valor numérico de la carta al puntaje
            puntaje += carta.getValorNumerico();
            // * si la carta es un as, marcar la bandera
            if(carta.getValor().equals("As")){
                asEnMano = true;
            }
        }
        // * si hay un as y el puntaje es 11 o menos, contar el as como 11
        // * si hay más de 1 as en mano, se usa de soft hand automáticamente (solo 1 as cuenta como 11)
        if(asEnMano == true && puntaje <= 11){
            puntaje += 10;
        }

        return puntaje;
    }

}
