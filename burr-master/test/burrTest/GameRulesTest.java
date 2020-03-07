/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burrTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import burr.GameRules;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Emre K
 */
public class GameRulesTest {
   private GameRules gameRules1;
     private GameRules gameRules2;

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
        gameRules1 = new GameRules(4,7,80,2);
        gameRules2 = new GameRules(-1,-2,-3,-4);
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /*
     This method checks entered value is correct as entered 
    */
    @Test
    public void testPlayUntilThisNumber() {
     assertEquals(80, gameRules1.getPlayUntilThisNumber());
    }

    /*
     Checking values that is preventing negativ values as input  
    */
    @Test
    public void isPossibleToSetMinusValue() {
        assertNotEquals(-4, gameRules2.getCurrentPlayer());
        assertNotEquals(-3, gameRules2.getDividerToSkip());
        assertNotEquals(-2, gameRules2.getPlayUntilThisNumber());
    }
    
}
