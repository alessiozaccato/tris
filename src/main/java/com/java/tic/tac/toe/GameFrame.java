package com.java.tic.tac.toe;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.*;
import javax.swing.*;

/**
 * La classe GameFrame gestisce la finestra principale del gioco e la navigazione
 * tra le diverse schermate (schermata iniziale, partita in corso e schermata
 * di fine partita). È il punto di ingresso dell'applicazione.
 */
public class GameFrame {
    private JFrame frame; // La finestra principale dell'applicazione

    // Variabili per i pannelli delle diverse schermate
    private JPanel startPanel;
    private GamePanel gamePanel;

    /**
     * Costruttore della classe GameFrame.
     * Inizializza la finestra principale e mostra la schermata iniziale.
     */
    public GameFrame() {
        // Imposta le proprietà base della finestra
        frame = new JFrame("Tris - Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Termina il programma quando si chiude la finestra
        frame.setSize(400, 450); // Imposta le dimensioni della finestra
        frame.setLocationRelativeTo(null); // Centra la finestra sullo schermo
        
        // Mostra la schermata iniziale all'avvio
        showStartScreen();
        
        // Rende la finestra visibile
        frame.setVisible(true);
    }
    
    /**
     * Metodo per mostrare la schermata iniziale del gioco.
     * Crea un pannello con un titolo e un pulsante per avviare la partita.
     */
    private void showStartScreen() {
        startPanel = new JPanel();
        startPanel.setLayout(new BorderLayout());

        // Crea e configura l'etichetta del titolo
        JLabel title = new JLabel("Tic-Tac-Toe", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        startPanel.add(title, BorderLayout.CENTER);

        // Crea e configura il pulsante "Nuova Partita"
        JButton startButton = new JButton("Nuova Partita");
        startButton.setFont(new Font("Arial", Font.PLAIN, 24));
        // Aggiunge un ActionListener che avvia il gioco al click
        startButton.addActionListener(_ -> startGame());
        
        // Crea un pannello per il pulsante e lo aggiunge a startPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        startPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Imposta startPanel come contenuto della finestra
        frame.setContentPane(startPanel);
        // Aggiorna il layout per visualizzare i cambiamenti
        frame.revalidate();
        frame.repaint();
    }
    
    /**
     * Metodo chiamato dal pulsante "Nuova Partita" per avviare il gioco.
     * Sostituisce la schermata iniziale con il GamePanel.
     */
    private void startGame() {
        // Crea una nuova istanza di GamePanel, passando un riferimento a questa classe
        gamePanel = new GamePanel(this);
        // Sostituisce il contenuto della finestra con il GamePanel
        frame.setContentPane(gamePanel);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Permette a GamePanel di ripristinare la schermata di gioco senza bottone.
     * Viene usato dopo che la partita è stata resettata.
     */
    public void showGamePanelOnly() {
        frame.setContentPane(gamePanel);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Metodo chiamato da GamePanel quando la partita termina.
     * Mostra il risultato e un pulsante per giocare ancora.
     * @param message Il messaggio da visualizzare (es. "X ha vinto!" o "Pareggio!")
     */
    public void showPlayAgainButton(String message) {
        // Crea un pannello per la schermata di fine partita
        JPanel panel = new JPanel(new BorderLayout());
        
        // Aggiunge un'etichetta con il messaggio di fine partita
        JLabel messageLabel = new JLabel(message, SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(messageLabel, BorderLayout.NORTH);
        
        // Mantiene il GamePanel esistente al centro
        panel.add(gamePanel, BorderLayout.CENTER);
        
        // Crea e configura il pulsante "Gioca ancora"
        JButton playAgain = new JButton("Gioca ancora");
        playAgain.setFont(new Font("Arial", Font.PLAIN, 20));
        // Aggiunge un ActionListener che resetta la partita al click
        playAgain.addActionListener(_ -> gamePanel.resetGame());
        
        // Crea un pannello per il pulsante e lo aggiunge
        JPanel btnPanel = new JPanel();
        btnPanel.add(playAgain);
        panel.add(btnPanel, BorderLayout.SOUTH);
        
        // Imposta il nuovo pannello come contenuto della finestra
        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Metodo main che è il punto di partenza dell'applicazione.
     * Avvia il programma in modo sicuro sul thread di gestione degli eventi di Swing.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameFrame::new);
    }
}