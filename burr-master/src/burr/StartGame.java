package burr;

/**
 * @author Hamza,Emre, Ayan
 * @version 1.8.0_201
 */
public class StartGame {

    private Gui gui = new Gui();
  
    /**
     * This method calls all Gui methods to start the game
     */
    public void start() {
        final int totalPlayers = gui.askHowManyPlayers();
        final int round = gui.askHowManyTimesPlays();
        final int startPlayerNum = gui.whichPlayerWantToStart(totalPlayers);
        final int divider = gui.inputDivider(totalPlayers);

        GameRules gr = new GameRules(totalPlayers, divider, round, startPlayerNum);
        gr.startGame();

    }
}
