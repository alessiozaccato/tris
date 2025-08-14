
# ❌⭕ Tris (Tic-Tac-Toe)
Gioco del Tris (Tic-Tac-Toe) in Java con interfaccia grafica Swing. Modalità Player vs CPU, colori personalizzati e schermata iniziale moderna.


## 📖 Descrizione
Il Tris è un gioco da tavolo su griglia 3x3. In questa versione giochi contro la CPU:
- **Player** (X, colore blu)
- **CPU** (O, colore rosso)
Vince chi allinea 3 simboli in orizzontale, verticale o diagonale. Se la griglia si riempie senza vincitori, la partita è pari.


## 🚀 Avvio del progetto

### 1. Esecuzione dal codice sorgente
Assicurati di avere Java (JDK 8 o superiore) e Maven installati.

Per compilare:
```sh
mvn clean package
```
Per eseguire:
```sh
java -cp target/classes com.java.tic.tac.toe.GameFrame
```

### 2. Esecuzione tramite IDE
Apri il progetto in un IDE Java (come IntelliJ IDEA, Eclipse o VS Code) ed esegui la classe `GameFrame`.


## 🗂️ Struttura del progetto
- `src/main/java/com/java/tic/tac/toe/` — Codice sorgente Java del gioco
- `src/main/resources/` — Risorse aggiuntive (non obbligatorie)
- `pom.xml` — Configurazione Maven




## 📋 Requisiti
- Java Development Kit (JDK) 8 o superiore ☕
- Maven (per la compilazione dal sorgente) ⚙️


## 🎮 Funzionalità e controlli
- Schermata iniziale con titolo e bottone "Nuova Partita"
- Griglia 3x3, click su una casella vuota per posizionare la X (Player)
- La CPU gioca automaticamente dopo il Player
- X blu (Player), O rosso (CPU)
- Al termine: messaggio di vittoria/pareggio e bottone "Gioca ancora"


## 👤 Autore
Alessio Zaccato

