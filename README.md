❌⭕ Tris (Tic-Tac-Toe)
Questo progetto è una semplice e classica implementazione del gioco del Tris in Java, con interfaccia grafica realizzata tramite Swing. È un'ottima risorsa per imparare i concetti di base della programmazione event-driven.

📖 Descrizione
Il Tris è un gioco da tavolo per due giocatori, "X" e "O", che si affrontano a turno per segnare tre dei propri simboli in linea su una griglia 3x3. Le linee possono essere orizzontali, verticali o diagonali. L'obiettivo è vincere prima che il proprio avversario ci riesca o che la griglia si riempia, causando un pareggio.

🚀 Avvio del progetto
1. Esecuzione tramite file JAR 🟢
All'interno della cartella del progetto è già presente il file tris.jar pronto all'uso. Puoi eseguire il gioco in diversi modi:

🖱️ Doppio click sul file tris.jar (se Java è installato sul tuo sistema operativo)

💻 Da linea di comando:
   sh    java -jar tris.jar    

🪟 Su Windows: puoi usare lo script run.bat (doppio click o da terminale):
   bat    run.bat    

🐧🍏 Su Linux/Mac: puoi usare lo script run.sh (da terminale):
   sh    ./run.sh    

2. Esecuzione dal codice sorgente 🛠️
Se vuoi compilare ed eseguire il progetto dal codice sorgente:

☕ Assicurati di avere Java (JDK 8 o superiore) e Maven installati.

📦 Compila il progetto con Maven per scaricare le dipendenze e creare il pacchetto:
   sh    mvn clean package    

▶️ Esegui la classe principale:
   sh    java -cp target/classes com.tris.game.TrisGame    

🗂️ Struttura del progetto
src/main/java/com/tris/game/ — Contiene il codice sorgente Java del gioco.

src/main/resources/ — Contiene le risorse del gioco, come immagini o suoni (se presenti).

tris.jar — File eseguibile del gioco.

pom.xml — File di configurazione Maven per la gestione del progetto.

run.bat — Script di avvio rapido per sistemi operativi Windows.

run.sh — Script di avvio rapido per sistemi operativi Linux e Mac.

📋 Requisiti
Java Development Kit (JDK) 8 o superiore ☕

Maven (per la compilazione dal sorgente) ⚙️

🎮 Controlli
Click del mouse: Clicca su una delle caselle vuote per posizionare il tuo simbolo.

👤 Autore
Alessio Zaccato

