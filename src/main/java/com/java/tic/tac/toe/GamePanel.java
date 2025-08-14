package com.java.tic.tac.toe;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe GamePanel gestisce il pannello di gioco effettivo.
 * Contiene la griglia dei pulsanti, la logica di gioco, il controllo dei turni
 * e l'intelligenza artificiale della CPU.
 */
public class GamePanel extends JPanel {
    // Array bidimensionale di JButton che rappresenta la griglia del Tris
    private JButton[][] buttons = new JButton[3][3];
    
    // Variabile per tenere traccia del giocatore attuale ("X" = Umano, "O" = CPU)
    private String currentPlayer = "X";
    
    // Flag che indica se la partita è terminata
    private boolean isGameOver = false;
    
    // Riferimento al GameFrame per poter interagire con la finestra principale
    private GameFrame parentFrame;

    /**
     * Costruttore di GamePanel.
     * @param parentFrame Un riferimento alla finestra principale del gioco.
     */
    public GamePanel(GameFrame parentFrame) {
        this.parentFrame = parentFrame;
        // Imposta il layout del pannello come una griglia 3x3
        setLayout(new GridLayout(3, 3));
        initializeButtons();
    }

    /**
     * Inizializza tutti i pulsanti della griglia.
     * Crea un JButton per ogni cella e configura il suo aspetto e il suo comportamento.
     */
    private void initializeButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 60));
                buttons[i][j].setFocusable(false);
                // Aggiunge un ActionListener per gestire il click del giocatore
                buttons[i][j].addActionListener(e -> onButtonClick((JButton) e.getSource()));
                add(buttons[i][j]);
            }
        }
    }

    /**
     * Metodo chiamato quando un pulsante viene cliccato.
     * Gestisce la logica del turno del giocatore umano.
     */
    private void onButtonClick(JButton button) {
        // La mossa è valida solo se il gioco non è finito, la casella è vuota e il turno è del giocatore umano
        if (isGameOver || !button.getText().isEmpty() || !currentPlayer.equals("X")) {
            return;
        }

        // Imposta il simbolo del giocatore "X" sul pulsante cliccato
        button.setText(currentPlayer);

        // Controlla se il giocatore "X" ha vinto
        if (checkForWin()) {
            isGameOver = true;
            // Mostra la schermata di fine partita
            parentFrame.showPlayAgainButton("Player ha vinto!");
        } else if (isBoardFull()) { // Controlla se la partita è un pareggio
            isGameOver = true;
            parentFrame.showPlayAgainButton("La partita è un pareggio!");
        } else {
            // Se la partita continua, passa il turno alla CPU
            currentPlayer = "O";
            // Disabilita i pulsanti per evitare che l'utente clicchi durante il turno della CPU
            setButtonsEnabled(false);
            
            // Crea un Timer per introdurre un ritardo prima della mossa della CPU (migliora l'esperienza utente)
            Timer timer = new Timer(700, e -> {
                cpuTurn(); // Chiama il metodo per la mossa della CPU
                ((Timer) e.getSource()).stop(); // Ferma il timer dopo un solo tick
            });
            timer.setRepeats(false); // Assicura che il timer si attivi una sola volta
            timer.start();
        }
    }

    /**
     * Implementa la logica del turno della CPU.
     * Per ora, la CPU fa una mossa casuale su una casella vuota.
     */
    private void cpuTurn() {
        if (isGameOver) {
            return;
        }

        // Trova tutte le caselle vuote
        List<JButton> emptyButtons = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    emptyButtons.add(buttons[i][j]);
                }
            }
        }

        if (!emptyButtons.isEmpty()) {
            // Sceglie una casella vuota a caso
            int randomIndex = (int) (Math.random() * emptyButtons.size());
            JButton cpuMoveButton = emptyButtons.get(randomIndex);
            
            // Imposta il simbolo della CPU "O" sul pulsante
            cpuMoveButton.setText(currentPlayer);

            // Controlla se la CPU ha vinto
            if (checkForWin()) {
                isGameOver = true;
                parentFrame.showPlayAgainButton("CPU ha vinto!");
            } else if (isBoardFull()) { // Controlla se c'è un pareggio
                isGameOver = true;
                parentFrame.showPlayAgainButton("La partita è un pareggio!");
            } else {
                // Se la partita continua, passa il turno al giocatore umano
                currentPlayer = "X";
                setButtonsEnabled(true); // Riabilita i pulsanti per l'utente
            }
        }
    }

    /**
     * Abilita o disabilita i pulsanti vuoti della griglia.
     * Viene usato per "bloccare" l'utente durante il turno della CPU.
     * @param enabled Se true, abilita i pulsanti; se false, li disabilita.
     */
    private void setButtonsEnabled(boolean enabled) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                     buttons[i][j].setEnabled(enabled);
                }
            }
        }
    }

    /**
     * Controlla se uno dei giocatori ha vinto la partita.
     * @return true se c'è una linea vincente, false altrimenti.
     */
    private boolean checkForWin() {
        // Controlla le righe, le colonne e le diagonali per una linea vincente
        for (int i = 0; i < 3; i++) {
            if (checkLine(buttons[i][0], buttons[i][1], buttons[i][2])) return true; // Righe
            if (checkLine(buttons[0][i], buttons[1][i], buttons[2][i])) return true; // Colonne
        }
        if (checkLine(buttons[0][0], buttons[1][1], buttons[2][2])) return true; // Diagonale principale
        if (checkLine(buttons[0][2], buttons[1][1], buttons[2][0])) return true; // Diagonale secondaria

        return false;
    }

    /**
     * Metodo ausiliario per controllare se tre pulsanti formano una linea vincente.
     * @return true se i pulsanti hanno lo stesso simbolo non vuoto, false altrimenti.
     */
    private boolean checkLine(JButton b1, JButton b2, JButton b3) {
        String text = b1.getText();
        return !text.isEmpty() && text.equals(b2.getText()) && text.equals(b3.getText());
    }

    /**
     * Controlla se tutte le caselle della griglia sono state riempite.
     * @return true se la griglia è piena, false altrimenti.
     */
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Resetta lo stato del gioco per una nuova partita.
     * Pulisce la griglia, resetta il turno e riabilita i pulsanti.
     */
    public void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
        currentPlayer = "X";
        isGameOver = false;
        // Chiede a GameFrame di mostrare solo il pannello di gioco pulito
        parentFrame.showGamePanelOnly();
    }
}