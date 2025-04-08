package juegocartas;

import java.util.Random;
import javax.swing.JPanel;

public class Jugador {

    public int TOTAL_CARTAS = 10;
    private Carta[] cartas;

    public void repartir() {
        cartas = new Carta[TOTAL_CARTAS];
        for (int i = 0; i < cartas.length; i++) {
            cartas[i] = new Carta();
        }
    }

    public void mostrar(JPanel pnl, boolean tapada) {
        pnl.removeAll();
        for (int i = 0; i < cartas.length; i++) {
            cartas[i].mostrarCarta(5 + i * 40, 5, pnl, tapada);
        }
        pnl.repaint();
    }

    public String obtenerFiguras() {
        String mensaje = "No hay grupos";

        int[] contadores = new int[NombreCarta.values().length];
        for (int i = 0; i < cartas.length; i++) {
            contadores[cartas[i].getNombre().ordinal()]++;
        }

        int totalGrupos = 0;
        for (int i = 0; i < contadores.length; i++) {
            if (contadores[i] >= 2) {
                totalGrupos++;
            }
        }
        if (totalGrupos > 0) {
            mensaje = "Los grupos encontrados fueron:\n";
            for (int i = 0; i < contadores.length; i++) {
                if (contadores[i] >= 2) {
                    mensaje += Grupo.values()[contadores[i]] + " de " + NombreCarta.values()[i] + "\n";
                }
            }
        }
        return mensaje;
    }

    public String getEscaleras() {
        String mensaje = "No hay escaleras";
        int[] contadores = new int[PintaCarta.values().length];

        for (int i = 0; i < cartas.length; i++) {
            contadores[cartas[i].getPinta().ordinal()]++;
        }

        int totalGrupos = 0;
        for (int i = 0; i < contadores.length; i++) {
            if (contadores[i] >= 2) {
                totalGrupos++;
            }
        }

        if (totalGrupos > 0) {
            mensaje = "Los grupos encontrados fueron:\n";
            for (int i = 0; i < contadores.length; i++) {
                if (contadores[i] >= 2) {
                    mensaje += Grupo.values()[contadores[i]] + " de " + PintaCarta.values()[i] + "\n";
                }
            }
        }

        return mensaje;
    }

    public String getPuntaje() {
        int[] contadores = new int[NombreCarta.values().length];
    
        
        for (Carta carta : cartas) {
            contadores[carta.getNombre().ordinal()]++;
        }
    
        int puntaje = 0;
        for (Carta carta : cartas) {
            int indiceNombre = carta.getNombre().ordinal();
            // Solo contar cartas que no forman parte de grupos (menos de 2)
            if (contadores[indiceNombre] < 2) {
                String nombre = carta.getNombre().name();
                if (nombre.equals("ACE") || nombre.equals("JACK") || nombre.equals("QUEEN") || nombre.equals("KING")) {
                    puntaje += 10;
                } else {
                    puntaje += indiceNombre + 1;
                }
            }
        }
    
        return "El puntaje del jugador es: " + puntaje;
    }
    
}
