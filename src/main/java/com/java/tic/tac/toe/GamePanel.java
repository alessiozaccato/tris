package com.java.tic.tac.toe;


import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel {
    private JButton[][] buttons = new JButton[3][3];

    private String currentPlayer = "X";
    private boolean isGameOver = false;

    public GamePanel() {
        setLayout(new GridLayout(3, 3)); // Imposta un layout a griglia 3x3

        initializeButtons();
    }

    private void initializeButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 60)); // Rende il testo grande
                buttons[i][j].setFocusable(false); // Evita che i pulsanti ricevano il focus
                buttons[i][j].addActionListener(e -> onButtonClick((JButton) e.getSource()));
                add(buttons[i][j]);
            }
        }
    }

    // Questo è il metodo che viene chiamato quando un pulsante viene cliccato
    private void onButtonClick(JButton button) {
        if (isGameOver || !button.getText().isEmpty()) {
            // Ignora il click se il gioco è finito o la casella è già occupata
            return;
        }

        button.setText(currentPlayer); // Imposta il testo del pulsante con il simbolo del giocatore

        // Controlla se il giocatore attuale ha vinto
        if (checkForWin()) {
            isGameOver = true;
            JOptionPane.showMessageDialog(this, "Il giocatore " + currentPlayer + " ha vinto!");
        } else if (isBoardFull()) { // Controlla se è un pareggio
            isGameOver = true;
            JOptionPane.showMessageDialog(this, "La partita è un pareggio!");
        } else {
            // Cambia turno
            currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
        }
    }

    private boolean checkForWin() {
        // Controlliamo le righe, le colonne e le diagonali

        // Righe
        for (int i = 0; i < 3; i++) {
            if (checkLine(buttons[i][0], buttons[i][1], buttons[i][2]))
                return true;
        }

        // Colonne
        for (int j = 0; j < 3; j++) {
            if (checkLine(buttons[0][j], buttons[1][j], buttons[2][j]))
                return true;
        }

        // Diagonali
        if (checkLine(buttons[0][0], buttons[1][1], buttons[2][2]))
            return true;
        if (checkLine(buttons[0][2], buttons[1][1], buttons[2][0]))
            return true;

        return false;
    }

    // Metodo ausiliario per controllare se 3 pulsanti formano una linea
    private boolean checkLine(JButton b1, JButton b2, JButton b3) {
        String text = b1.getText();
        return !text.isEmpty() && text.equals(b2.getText()) && text.equals(b3.getText());
    }

    // Metodo per controllare se tutte le caselle sono piene
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

}