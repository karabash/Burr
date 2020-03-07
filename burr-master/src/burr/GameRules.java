package burr;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Ayan, Emre, Hamza
 * @version 1.8.0_201
 */
public class GameRules {

    /* ToDo  
    * player is will be able to write a number or burr 
     */
    //Instance fields
    private int currentNumber;
    private int currentPlayer;
    private int playUntilThisNumber;
    private int dividerToSkip;
    private int numberOfPlayers;
    private List<Player> playerlist;
    private static final int STARTBURR = 1;

    /**
     * Constructor
     *
     * @param numberOfPlayers
     * @param divider
     * @param playUntilThisNumber
     * @param currentPlayer
     */
    public GameRules(int numberOfPlayers, int divider, int playUntilThisNumber, int currentPlayer) {
        playerlist = new ArrayList<>();
        setCurrentNumber(GameRules.STARTBURR);
        this.setCurrentPlayer(--currentPlayer);
        this.setPlayUntilThisNumber(playUntilThisNumber);
        this.setDividerToSkip(dividerToSkip);
        this.setNumberOfPlayers(numberOfPlayers);
        fillPlayerList(this.getNumberOfPlayers());
    }

    /**
     * @return the dividerToSkip
     */
    public int getDividerToSkip() {
        return dividerToSkip;
    }

    /**
     * @param dividerToSkip the dividerToSkip to set
     */
    public void setDividerToSkip(int dividerToSkip) {
        if (dividerToSkip >= 1) {
            this.dividerToSkip = dividerToSkip;
        } else {
            this.dividerToSkip = 7;
        }
    }

    /**
     * @return Returns the answer.
     */
    public int getTheAnswer() {
        return 42;
    }

    /**
     * @return Returns the number that is about to be "said" by one of the
     * players.
     */
    /**
     * Increases the number to be said by one.
     */
    public void increaseCurrentNumber() {
        this.setCurrentNumber(this.getCurrentNumber() + 1);
    }

    /**
     * Fills a list of players after the parameters given from the MindRoad.main
     * Initialize Players and asks user their name class.
     *
     * @param numberOfPlayers
     */
    private final void fillPlayerList(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            Player p = new Player(this, i + 1, getDividerToSkip());
            playerlist.add(p);
            playerlist.get(i).askUserName();
        }

    }

    /**
     * Lets the players take turns to play the game of "Burr", passing the turn
     * between players until the playUntilThisNumber is reached. The result is
     * shown on the screen
     */
    void startGame() {
        StringBuilder sb = new StringBuilder();
        while (this.getCurrentNumber() <= this.getPlayUntilThisNumber()) {
            sb.append(playerlist.get(this.getCurrentPlayer() % playerlist.size()).getName()).append(" ").append(playerlist.get(currentPlayer++ % playerlist.size()).play()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb);
    }

    /**
     * @param currentNumber the currentNumber to set
     */
    private void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    /**
     *
     * @return currentNumber
     */
    public int getCurrentNumber() {
        return currentNumber;
    }

    /**
     * @return the currentPlayer
     */
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * @param currentPlayer the currentPlayer to set
     */
    private void setCurrentPlayer(int currentPlayer) {
        if (currentPlayer >= 1) {
            this.currentPlayer = currentPlayer;
        } else {
            this.currentPlayer = 0;
        }
    }

    /**
     * @return the playUntilThisNumber
     */
    public int getPlayUntilThisNumber() {
        return playUntilThisNumber;
    }

    /**
     * @param playUntilThisNumber the playUntilThisNumber to set
     */
    private final void setPlayUntilThisNumber(int playUntilThisNumber) {
        if (playUntilThisNumber < 0) {
            this.playUntilThisNumber = 15;
        } else {
            this.playUntilThisNumber = playUntilThisNumber;
        }
    }

    /**
     * @return the numberOfPlayers
     */
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    /**
     * @param numberOfPlayers the numberOfPlayers to set
     */
    private final void setNumberOfPlayers(int numberOfPlayers) {
        if (numberOfPlayers <= 2) {
            JOptionPane.showMessageDialog(null, "You entered a number less than 2 so the game automatically start for 2 players", "Error", JOptionPane.WARNING_MESSAGE);
            this.numberOfPlayers = 2;
        } else {
            this.numberOfPlayers = numberOfPlayers;
        }
    }

}
