package robles_de_anda_damian_dali_pf;

public class Robles_de_Anda_Damian_Dali_PF {

    public static void main(String[] args) {
        
        // * crear baraja
        Baraja baraja;
        Mano manoJugador;
        Mano manoCrupier;

        baraja = new Baraja();
        manoJugador = new Mano();
        manoCrupier = new Mano();

        baraja.reiniciarBaraja();

        manoJugador.agregarCarta(baraja.darCarta());
        manoJugador.agregarCarta(baraja.darCarta());
        manoCrupier.agregarCarta(baraja.darCarta());
        manoCrupier.agregarCarta(baraja.darCarta());
        
        System.out.println("Cartas en la mano del jugador:");
        for(Carta carta : manoJugador.obtenerCartasMano()){
            System.out.println(carta.getValor() + " de " + carta.getPalo());
        }
        System.out.println("Puntaje de la mano del jugador: " + manoJugador.calcularPuntaje());
        System.out.println("Cartas en la mano del crupier:");
        for(Carta carta : manoCrupier.obtenerCartasMano()){
            System.out.println(carta.getValor() + " de " + carta.getPalo());
        }
        System.out.println("Puntaje de la mano del crupier: " + manoCrupier.calcularPuntaje());
        
        
    }
    
}
