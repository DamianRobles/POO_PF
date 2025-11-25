package robles_de_anda_damian_dali_pf;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {

    // * campos
    public final ArrayList<Carta> cartas;


    // * constructor
    public Baraja() {
        this.cartas = new ArrayList<>();
        crearBaraja();
    }

    // * metodo para crear la baraja
    private void crearBaraja(){
        // * limpiar arreglo de cartas antes de crear nueva baraja para cuando se juegue otra vez
        this.cartas.clear();

        // * definir palos y valores
        String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        String[] valores = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String simbolo;
        String[] cartasCorazones = {"🂱", "🂲", "🂳", "🂴", "🂵", "🂶", "🂷", "🂸", "🂹", "🂺", "🂻" , "🂽", "🂾"};
        String[] cartasDiamantes = {"🃁", "🃂", "🃃", "🃄", "🃅", "🃆", "🃇", "🃈", "🃉", "🃊", "🃋", "🃍", "🃎"};
        String[] cartasTreboles = {"🃑", "🃒", "🃓", "🃔", "🃕", "🃖", "🃗", "🃘", "🃙", "🃚", "🃛", "🃝", "🃞"};
        String[] cartasPicas = {"🂡", "🂢", "🂣", "🂤", "🂥", "🂦", "🂧", "🂨", "🂩", "🂪", "🂫", "🂭", "🂮"};

        // * llenar arreglo de cartas
        for(int i = 0; i < palos.length; i++){
            for(int j = 0; j < valores.length; j++){
                // * asignar símbolo gráfico de la carta
                simbolo = (palos[i].equals("Corazones") ? cartasCorazones[j] :
                    palos[i].equals("Diamantes") ? cartasDiamantes[j] :
                    palos[i].equals("Tréboles") ? cartasTreboles[j] : cartasPicas[j]);
                // * asignar valor numérico
                if(j >= 10){
                    // * J, Q, K
                    this.cartas.add(new Carta(palos[i], valores[j], 10, simbolo));
                } else {
                    // * resto de cartas de 1 al 10
                    this.cartas.add(new Carta(palos[i], valores[j], j + 1, simbolo));
                    
                }
            }
        } // * fin de llenar arreglo
    }

    /*
     * metodo para Barajear la baraja
     */
    private void barajear(){
        // * usar Collections.shuffle para barajear la baraja
        Collections.shuffle(cartas);
    }

    // * metodo para obtener las cartas de la baraja
    public Carta darCarta(){
        if(cartas.isEmpty()){
            return null; // * si no hay cartas, regresar null
        }
        // * se retorna el valor de la carta "repartida" y se remueve la carta que "se repartió"
        // * se remueuve la última carta del arreglo para no afectar el índice de las demás cartas
        return cartas.remove(cartas.size() - 1);
    }

    // * metodo para reiniciar la baraja
    public void reiniciarBaraja(){
        crearBaraja();
        barajear();
    }

}
