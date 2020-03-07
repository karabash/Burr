package burr;

import javax.swing.JOptionPane;

/**
 * @author Hamza,Emre, Ayan
 * @version 1.8.0_201
 */
public class Player {

    //Instance fields
    private int counter = 0;
    private GameRules rules;
    private int dividerToSkip;
    private int playerNumber;
    private String name;

    /**
     * Constructor
     *
     * @param r - rules for the game
     * @param playerNr
     * @param divider - divider for the game
     */
    public Player(GameRules r, int playerNr, int divider) {
        rules = r;
        this.playerNumber = playerNr;
        dividerToSkip = divider;
    }

    /**
     * @return the playerNumber
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * @param playerNumber the playerNumber to set
     */
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid Input! Enter a userName", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            this.name = name;
        }
    }

    /**
     * Checks the GameRule class for info on the games state
     *
     * @return a string depending on the outcome.
     */
    public String play() {
        String s = "";
        if (rules.getCurrentNumber() % dividerToSkip == 0) {
            s = "Player " + getPlayerNumber() + ": Burr";
        } else if (rules.getCurrentNumber() > 10
                && (String.valueOf(rules.getCurrentNumber()).charAt(0)) == (String.valueOf(rules.getCurrentNumber()).charAt(1))) {
            s = "Player " + getPlayerNumber() + ": Burr";
        } else if (String.valueOf(rules.getCurrentNumber()).endsWith(String.valueOf(rules.getDividerToSkip()))) {
            s = "Player " + getPlayerNumber() + ": Burr";
        } else {
            s = "Player " + getPlayerNumber() + ": " + rules.getCurrentNumber();
        }
        rules.increaseCurrentNumber();
        return s;
    }

    /**
     * This method retrieves user name
     *
     * @return String
     */
    String askUserName() {
        String userInput = JOptionPane.showInputDialog("Enter an player name?");
        this.setName(userInput);
        return this.getName();

    }
}
