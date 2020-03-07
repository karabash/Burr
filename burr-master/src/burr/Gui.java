/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burr;

import javax.swing.JOptionPane;

/**
 * This class provides Gui
 * @author Hamza,Emre, Ayan
 * @version 1.8.0_201
 */
public class Gui {

    private String userInput;

    /**
     * This is a constructor
     */
    public Gui() {
        super();
    }

    /**
     * This method takes in the number of rounds
     *
     * @return int
     */
    public int askHowManyTimesPlays() {
        userInput = JOptionPane.showInputDialog("How many rounds do you want to play?");
        boolean isItDigit = this.checkIsDigit(userInput, "Invalid Input! Enter a digit");

        if (userInput.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid Input! Enter a digit", "Error", JOptionPane.ERROR_MESSAGE);
            askHowManyTimesPlays();
        } else if (isItDigit == false) {
            askHowManyTimesPlays();
        }
        return Integer.parseInt(userInput);
    }

    /**
     * This method takes in the number of players
     *
     * @return int
     */
    public int askHowManyPlayers() {
        userInput = JOptionPane.showInputDialog("How many player gonna play Burr?");
        boolean isItDigit = this.checkIsDigit(userInput, "Invalid Input! Enter a digit");
        if (isItDigit == false) {
            askHowManyPlayers();
        }
        return Integer.parseInt(userInput);
    }

    /**
     * This method decides which player is going to start.
     *
     * @param totalPlayer
     * @return int
     */
    public int whichPlayerWantToStart(int totalPlayer) {
        userInput = JOptionPane.showInputDialog("which player would like to start the game?");
        boolean isItDigit = this.checkIsDigit(userInput, "Invalid Input! Enter a digit");
        if (isItDigit == false) {
            whichPlayerWantToStart(totalPlayer);
        } else {
            if (totalPlayer < Integer.parseInt(userInput)) {
                JOptionPane.showMessageDialog(null, "StartPlayer number can't be higher than total player!", "Error", JOptionPane.ERROR_MESSAGE);
                whichPlayerWantToStart(totalPlayer);
            }
        }
        return Integer.parseInt(userInput);
    }

    /**
     * This method takes divide number from user input.
     *
     * @param totalPlayer
     * @return int
     */
    public int inputDivider(int totalPlayer) {
        userInput = JOptionPane.showInputDialog("Enter a divider number!");
        int convertedUserInputToint = Integer.parseInt(userInput);
        boolean isItDigit = this.checkIsDigit(userInput, "Invalid Input! Enter a digit");

        if (isItDigit == false) {
            whichPlayerWantToStart(totalPlayer);
        }
        return convertedUserInputToint;
    }

    /**
     * This method checks if user input is digit or not.
     *
     * @param userInput
     * @param message
     * @return boolean
     */
    private boolean checkIsDigit(String userInput, String message) {
        boolean isItValid = false;
        for (int i = 0; i < userInput.length(); i++) {
            if (Character.isDigit(userInput.charAt(i)) == false) {
                JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                isItValid = true;
            }
        }
        return isItValid;
    }

}
