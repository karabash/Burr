package burrTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import burr.GameRules;
import burr.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author why_e
 */
public class PlayerTest {
    private int nrOfPLayers;
    private int divider;
    private GameRules gr;
    private Player player;
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         nrOfPLayers = 35;
        divider = 13;
        gr =  new GameRules(4,7,80,2);
        player = new Player(gr,100,divider);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testReturnString() {
        String res = player.play();

        // Den har sortens assert kraver att man har med "-ea" som argument till JVM:en, annars misslyckas ALDRIG
        // testerna. Nagon av oss ska komma ihag att ta med det i presentationen! :)
        assert "Player 100: 1".equals(res) : "Expected correct return string, got " + res;

        // For att den har assertmetoden (och manga andra som assertNotNull, assertSame...) ska funka maste man
        // gora import static org.testng.AssertJUnit.*; Den ar annars smidigare, eftersom den automatiskt skriver ut
        // expected och actual. Och for att man slipper sitta och undra varfor testerna aldrig misslyckas nar man
        // har glomt "-ea"...
        assertEquals("Player 100: 1", res);
    }
}
