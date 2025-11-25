package robles_de_anda_damian_dali_pf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaTablero extends JFrame{

    // * campos de la lógica
    private final Baraja baraja;
    private final Mano manoJugador;
    private final Mano manoCrupier;
    private Boolean juegoTerminado;
    private int scoreJugador;
    private int scoreCrupier;

    // * campos de la interfaz
    private JPanel jpnlTablero;
    private JPanel jpnlBotones;
    private JButton btnPedirCarta;
    private JButton btnPlantarse;
    private JButton btnNuevaPartida;
    private JLabel jlblInfoCrupier;
    private JLabel jlblInfoJugador;
    private JLabel jlblCartasCrupier;
    private JLabel jlblCartasJugador;
    private int tamFuentePuntaje;
    private int tamFuenteScore;
    private int tamFuenteCartas;
    private Color colorCartas;
    private JPanel jpnlInfo;
    private JLabel jlblScoreJugador;
    private JLabel jlblScoreCrupier;
    

    //! constructor
    //!=================================================================================================================
    public VentanaTablero(){
        // * colocar título a la ventana
        super("Robles de Anda Damian Dali - BlackJack");

        // * inicializar logica del juego
        baraja = new Baraja();
        manoJugador = new Mano();
        manoCrupier = new Mano();
        juegoTerminado = true;
        scoreJugador = 0;
        scoreCrupier = 0;

        // * hacer visible la ventana
        this.setVisible(true);
        
        // * configurar ventana
        this.setBounds(500, 100, 800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // * inicializar componentes de la interfaz
        inicializarComponentes();
        // * configurar manejadores de eventos
        manejadorDeEventos();

        // * iniciar juego
        iniciarJuego();

    }

    //! inicializarComponentes
    //!=================================================================================================================
    private void inicializarComponentes(){
        //? tamaño de fuentes y colores
        tamFuenteCartas = 130;
        tamFuentePuntaje = tamFuenteCartas / 4;
        tamFuenteScore = tamFuenteCartas / 6;
        colorCartas = new Color(165, 32, 25);

        //? PANEL DE TABLERO Y BOTONES
        // * inicializar panel de tablero
        jpnlTablero = new JPanel(new GridLayout(4, 1));
        // * se asigna el color verde oscuro al fondo del tablero
        jpnlTablero.setBackground(Color.WHITE);
        // * inicializar panel de información
        jpnlInfo = new JPanel(new GridLayout(1, 2));

        // * inicializar áreas de texto
        jlblInfoCrupier = new JLabel(); 
        jlblInfoJugador = new JLabel();
        jlblCartasCrupier = new JLabel();
        jlblCartasJugador = new JLabel();
        jlblScoreJugador = new JLabel("Score Jugador: " + scoreJugador);
        jlblScoreCrupier = new JLabel("Score Crupier: " + scoreCrupier);


        //? inicializar panel de botones y botones
        // * inicializar panel de botones
        jpnlBotones = new JPanel(new GridLayout(1, 3));
        // * inicializar botones
        btnPedirCarta = new JButton("Pedir Carta");
        btnPlantarse = new JButton("Plantarse");
        btnNuevaPartida = new JButton("Nueva Partida");

        //? agregar botones al panel de botones
        // * agregar botones al panel de botones
        jpnlBotones.add(btnPedirCarta);
        jpnlBotones.add(btnPlantarse);
        jpnlBotones.add(btnNuevaPartida);

        // * agregar áreas de puntaje al panel de información
        jpnlInfo.add(jlblScoreCrupier);
        jpnlInfo.add(jlblScoreJugador);


        //? agregar áreas de texto al tablero
        jpnlTablero.add(jlblInfoCrupier);
        jpnlTablero.add(jlblCartasCrupier);
        jpnlTablero.add(jlblInfoJugador);
        jpnlTablero.add(jlblCartasJugador);

        //? FORMATO DE TEXTOS
        // * cambiar tamaño del texto a las áreas de texto
        jlblInfoCrupier.setFont(new Font("Serif", Font.PLAIN, tamFuentePuntaje));
        jlblInfoJugador.setFont(new Font("Serif", Font.PLAIN, tamFuentePuntaje));
        jlblCartasCrupier.setFont(new Font("Serif", Font.PLAIN, tamFuenteCartas));
        jlblCartasJugador.setFont(new Font("Serif", Font.PLAIN, tamFuenteCartas));
        jlblScoreCrupier.setFont(new Font("Serif", Font.PLAIN, tamFuenteScore));
        jlblScoreJugador.setFont(new Font("Serif", Font.PLAIN, tamFuenteScore));
        // * centrar texto en las áreas de texto
        jlblInfoCrupier.setHorizontalAlignment(JLabel.CENTER);
        jlblInfoJugador.setHorizontalAlignment(JLabel.CENTER);
        jlblCartasCrupier.setHorizontalAlignment(JLabel.CENTER);
        jlblCartasJugador.setHorizontalAlignment(JLabel.CENTER);
        jlblScoreCrupier.setHorizontalAlignment(JLabel.CENTER);
        jlblScoreJugador.setHorizontalAlignment(JLabel.CENTER);

        // * cambiar color a las áreas de texto de las cartas a rojo oscuro
        jlblCartasJugador.setForeground(colorCartas);
        jlblCartasCrupier.setForeground(colorCartas);


        //? AGREGAR COMPONENTES A LA VENTANA 
        // * agregar paneles a la ventana
        this.add(jpnlInfo, BorderLayout.NORTH);
        this.add(jpnlTablero, BorderLayout.CENTER);
        this.add(jpnlBotones, BorderLayout.SOUTH);        
    }

    //! iniciarJuego
    //!=================================================================================================================
    private void iniciarJuego(){
        // * reiniciar baraja
        baraja.reiniciarBaraja();
        // * limpiar manos
        manoJugador.limpiarMano();
        manoCrupier.limpiarMano();
        // * reiniciar estado del juego
        juegoTerminado = false;
        // * dar cartas iniciales
        manoJugador.agregarCarta(baraja.darCarta());
        manoJugador.agregarCarta(baraja.darCarta());
        manoCrupier.agregarCarta(baraja.darCarta());
        if(manoJugador.obtenerCartasMano().size() == 2 && manoJugador.calcularPuntaje() == 21){
            // * determinar ganador
            ganadorDelJuego();
        }
        // * actualizar interfaz y botones
        actualizarBotones();
        actualizarInterfaz();
    }

    //! actualizarInterfaz
    //!=================================================================================================================
    private void actualizarInterfaz(){
        // * metodo para actualizar las cartas y puntajes en la interfaz
        // * actualizar info del crupier
        jlblInfoCrupier.setText("Cartas del Crupier con puntaje: " + manoCrupier.calcularPuntaje());
        jlblCartasCrupier.setText("");
        for(Carta carta : manoCrupier.obtenerCartasMano()){
            if(!juegoTerminado){                
                jlblCartasCrupier.setText(jlblCartasCrupier.getText() + " " + carta.getCartaGrafica() + " " + "🂠");
                break;
            } else {
                jlblCartasCrupier.setText(jlblCartasCrupier.getText() + " " + carta.getCartaGrafica());
            }
        }

        // * actualizar info del jugador
        jlblInfoJugador.setText("Cartas del Jugador con puntaje: " + manoJugador.calcularPuntaje());
        jlblCartasJugador.setText("");
        for(Carta carta : manoJugador.obtenerCartasMano()){
            jlblCartasJugador.setText(jlblCartasJugador.getText() + " " + carta.getCartaGrafica());
        }

        // * actualizar los scores
        jlblScoreCrupier.setText("Score Crupier: " + scoreCrupier);
        jlblScoreJugador.setText("Score Jugador: " + scoreJugador);
    }

    //! actualizarBotones
    //!=================================================================================================================
    private void actualizarBotones(){
        // * metodo para actualizar el estado de los botones
        // * si el juego no ha terminado, habilitar botones de pedir y plantarse 
        btnPedirCarta.setEnabled(!juegoTerminado); 
        btnPlantarse.setEnabled(!juegoTerminado);
        // * si el juego ha terminado, habilitar boton de nuevo juego 
        btnNuevaPartida.setEnabled(juegoTerminado);
    }

    //! manejadorDeEventos
    //!=================================================================================================================
    private void manejadorDeEventos(){
        // * manejar evento de pedir carta
        btnPedirCarta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // * dar carta al jugador
                manoJugador.agregarCarta(baraja.darCarta());
                // * actualizar interfaz
                actualizarInterfaz();
                // * verificar si el jugador se pasó de 21
                if(manoJugador.calcularPuntaje() > 21){
                    ganadorDelJuego();
                }
                // * verificar si el jugador tiene 21
                if(manoJugador.calcularPuntaje() == 21){
                    revelarCartaCrupier();
                    ganadorDelJuego();
                }
            }
        });

        // * manejar evento de plantarse
        btnPlantarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // * finalizar el turno del jugador
                juegoTerminado = true;
                // * turno del crupier
                while (manoCrupier.calcularPuntaje() < 17) {
                    revelarCartaCrupier();
                }
                // * determinar ganador
                ganadorDelJuego();
            }
        });

        // * manejar evento de nueva partida
        btnNuevaPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJuego();
            }
        });

        
    }

    //! ganadorDelJuego
    //!=================================================================================================================
    private void ganadorDelJuego(){
        // * metodo para determinar el ganador del juego
        // * obtener puntajes para manejar condiciones de victoria más fácil
        int puntajeJugador = manoJugador.calcularPuntaje();
        int puntajeCrupier = manoCrupier.calcularPuntaje();
        // * marcar juego como terminado
        juegoTerminado = true;

        // * determinar ganador según reglas de BlackJack
        // * condiciones de victoria
        // * revisar condiciones en orden de prioridad
        if(puntajeJugador == 21 && manoJugador.obtenerCartasMano().size() == 2){ // * blackjack
            scoreJugador++;
            revelarCartaCrupier();
            JOptionPane.showMessageDialog(this, "¡Blackjack! ¡Felicidades, has ganado!", "Fin del Juego", JOptionPane.WARNING_MESSAGE);
        } else if(puntajeJugador == 21){ // * 21 normal
            scoreJugador++;
            revelarCartaCrupier();
            JOptionPane.showMessageDialog(this, "¡Has alcanzado 21! ¡Felicidades, has ganado!", "Fin del Juego", JOptionPane.WARNING_MESSAGE);
        } else if(puntajeJugador > 21){ // * jugador se pasó de 21
            scoreCrupier++;
            revelarCartaCrupier();
            JOptionPane.showMessageDialog(this, "¡Te pasaste! Has perdido.", "Fin del Juego", JOptionPane.ERROR_MESSAGE);
        } else if(puntajeCrupier > 21){ // * crupier se pasó de 21
            scoreJugador++;
            actualizarInterfaz();
            JOptionPane.showMessageDialog(this, "El crupier se pasó. ¡Has ganado!", "Fin del Juego", JOptionPane.WARNING_MESSAGE);
        } else if(puntajeJugador > puntajeCrupier){ // * jugador tiene mayor puntaje
            scoreJugador++;
            actualizarInterfaz();
            JOptionPane.showMessageDialog(this, "¡Felicidades! Has ganado.", "Fin del Juego", JOptionPane.WARNING_MESSAGE);
        } else if(puntajeJugador < puntajeCrupier){ // * crupier tiene mayor puntaje
            scoreCrupier++;
            actualizarInterfaz();
            JOptionPane.showMessageDialog(this, "El crupier gana. Has perdido.", "Fin del Juego", JOptionPane.ERROR_MESSAGE);
        } else { // * empate
            scoreJugador++;
            scoreCrupier++;
            actualizarInterfaz();
            JOptionPane.showMessageDialog(this, "¡Es un empate!", "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);
        }
        actualizarBotones();
    }

    //! metodo para que el crupier revele su segunda carta
    //!=================================================================================================================
    private void revelarCartaCrupier(){
        // * dar carta al crupier
        manoCrupier.agregarCarta(baraja.darCarta());
        // * actualizar interfaz
        actualizarInterfaz();
    }

}
