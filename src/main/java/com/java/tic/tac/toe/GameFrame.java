package com.java.tic.tac.toe;



import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameFrame {
    public static void main(String[] args) {
        // La chiamata a SwingUtilities.invokeLater assicura che l'interfaccia
        // grafica venga creata in modo sicuro dal thread di Swing.
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tris - Tic-Tac-Toe");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400); // Imposta le dimensioni della finestra
            frame.add(new GamePanel()); // Aggiunge il pannello del gioco
            frame.setVisible(true);
        });
    }
}