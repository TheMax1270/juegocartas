package juegocartas;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Carta {

    /* Atributo privado para almacenar el número de la carta
     * 1 = As de Trebol, 14 = As de Pica, 27 = As de Corazon, 40 = As de Diamante
     * 2 = 2 de Trebol, 15 = 2 de Pica, 28 = 2 de Corazon, 41 = 2 de Diamante
     * 3 = 3 de Trebol, 16 = 3 de Pica, 29 = 3 de Corazon, 42 = 3 de Diamante
     * ...
     * 13 = K de Trebol, 26 = K de Pica, 39 = K de Corazon, 52 = K de Diamante
     */
    private int indice;
    private static Random r = new Random();

    // Constructor que genera una carta aleatoria
    public Carta() {
        indice = r.nextInt(52) + 1;
    }

    // Devuelve la pinta de la carta (Trebol, Pica, Corazon, Diamante)
    public PintaCarta getPinta() {
        if (indice <= 13)
            return PintaCarta.TREBOL;
        else if (indice <= 26)
            return PintaCarta.PICA;
        else if (indice <= 39)
            return PintaCarta.CORAZON;
        else
            return PintaCarta.DIAMANTE;
    }

    // Devuelve el nombre de la carta (As, Dos, Tres... K)
    public NombreCarta getNombre() {
        int numero = indice % 13;
        if (numero == 0) {
            numero = 13;
        }
        return NombreCarta.values()[numero - 1];
    }

    // Mostrar la carta 
    public void mostrarCarta(int x, int y, JPanel pnl, boolean tapada) {
        String nombreImagen;

        // Obtener el nombre del archivo de la carta
        if (tapada)
            nombreImagen = "/imagenes/Tapada.jpg";
        else
            nombreImagen = "/imagenes/carta" + indice + ".jpg";

        // Cargar la imagen
        ImageIcon imagen = new ImageIcon(getClass().getResource(nombreImagen));

        // Instanciar label para mostrar la imagen
        JLabel lblCarta = new JLabel(imagen);

        // Definir posición y dimensiones de la imagen
        lblCarta.setBounds(x, y, imagen.getIconWidth(), imagen.getIconHeight());

        // Mostrar la carta en la ventana
        pnl.add(lblCarta);
    }

   
    
}
