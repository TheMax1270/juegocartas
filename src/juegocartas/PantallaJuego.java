package juegocartas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PantallaJuego extends JFrame {

    private Jugador jugador1 = new Jugador();
    private Jugador jugador2 = new Jugador();

    private JButton btnRepartir;
    private JButton btnVerificar;
    private JButton btnEscalera;
    private JButton btnPuntaje;
    private JPanel pnlJugador1;
    private JPanel pnlJugador2;
    private JTabbedPane tpJugadores;

    public PantallaJuego() {
        setTitle("Juego de Cartas");
        setSize(620, 370);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel pnlBotones = new JPanel();
        btnRepartir = new JButton("Repartir");
        btnVerificar = new JButton("Verificar");
        btnEscalera = new JButton("Escaleras");
        btnPuntaje = new JButton("Puntaje");

        btnVerificar.setEnabled(false);
        btnEscalera.setEnabled(false);
        btnPuntaje.setEnabled(false);

        pnlBotones.add(btnRepartir);
        pnlBotones.add(btnVerificar);
        pnlBotones.add(btnEscalera);
        pnlBotones.add(btnPuntaje);

        add(pnlBotones, BorderLayout.NORTH);

        tpJugadores = new JTabbedPane();

        pnlJugador1 = new JPanel(null);
        pnlJugador1.setBackground(Color.GREEN);
        tpJugadores.addTab("Martín Estrada Contreras", pnlJugador1);

        pnlJugador2 = new JPanel(null);
        pnlJugador2.setBackground(Color.CYAN);
        tpJugadores.addTab("Raúl Vidal", pnlJugador2);

        add(tpJugadores, BorderLayout.CENTER);

        btnRepartir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jugador1.repartir();
                jugador2.repartir();

                jugador1.mostrar(pnlJugador1, false); // destapadas
                jugador2.mostrar(pnlJugador2, false); // destapadas

                btnVerificar.setEnabled(true);
                btnEscalera.setEnabled(true);
                btnPuntaje.setEnabled(true);
            }
        });

        btnVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int pestaña = tpJugadores.getSelectedIndex();
                String mensaje = (pestaña == 0) ? jugador1.obtenerFiguras() : jugador2.obtenerFiguras();
                JOptionPane.showMessageDialog(null, mensaje);
            }
        });

        btnEscalera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int pestaña = tpJugadores.getSelectedIndex();
                String mensaje = (pestaña == 0) ? jugador1.getEscaleras() : jugador2.getEscaleras();
                JOptionPane.showMessageDialog(null, mensaje);
            }
        });

        btnPuntaje.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int pestaña = tpJugadores.getSelectedIndex();
                String mensaje = (pestaña == 0) ? jugador1.getPuntaje() : jugador2.getPuntaje();
                JOptionPane.showMessageDialog(null, mensaje);
            }
        });
    }
}
