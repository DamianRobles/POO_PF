package robles_de_anda_damian_dali_pf;

import java.util.ArrayList;
import java.util.Random;

public class Baraja {

    // * campos
    private final ArrayList<Carta> cartas;
    private final Random numAleat;

    // * constructor
    public Baraja() {
        this.cartas = new ArrayList<Carta>();
        this.numAleat = new Random();
        crearBaraja();
    }

    // * metodo para crear la baraja
    private void crearBaraja(){
        // * limpiar arreglo de cartas antes de crear nueva baraja para cuando se juegue otra vez
        this.cartas.clear();

        // * definir palos y valores
        String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        String[] valores = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        // * llenar arreglo de cartas
        for(int i = 0; i < palos.length; i++){
            for(int j = 0; j < valores.length; j++){
                // * asignar valor numérico
                if(j >= 10){
                    // * J, Q, K
                    this.cartas.add(new Carta(palos[i], valores[j], 10));
                } else {
                    // * resto de cartas de 2 al 10
                    this.cartas.add(new Carta(palos[i], valores[j], j + 1));
                }
            }
        } // * fin de llenar arreglo
    }

    /*
     * metodo para Barajear con el algoritmo de Fisher-Yates 
     * por que es el metodo más eficiente de mezclar listas aleatoriamente
     */
    private void barajear(){
        for(int i = 0; i < cartas.size(); i++){
            // * obtener indice aleatorio * entre 0 y el tamaño del arreglo - 1 por que inicia en 0
            int indiceAleatorio = numAleat.nextInt(cartas.size());

            // * intercambiar cartas
            // * primero se guarda la carta en la posición i en una variable temporal
            Carta temp = cartas.get(i);
            // * luego se asigna la carta en la posición del índice aleatorio a la posición i
            cartas.set(i, cartas.get(indiceAleatorio));
            // * finalmente se asigna la carta guardada en la variable temporal a la posición del índice aleatorio
            cartas.set(indiceAleatorio, temp);            
        }
    }

    // * metodo para obtener las cartas de la baraja
    public Carta darCarta(){
        if(cartas.isEmpty()){
            return null; // * si no hay cartas, regresar null
        }
        // * remover y regresar la carta del tope (final de la lista)
        return cartas.remove(cartas.size() - 1);
    }

    // * metodo para reiniciar la baraja
    public void reiniciarBaraja(){
        crearBaraja();
        barajear();
    }

}
