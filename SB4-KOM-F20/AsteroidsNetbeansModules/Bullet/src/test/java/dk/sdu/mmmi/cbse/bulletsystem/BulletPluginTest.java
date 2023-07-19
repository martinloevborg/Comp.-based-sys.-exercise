/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bruger
 */
public class BulletPluginTest {
    
    //private IQueue q;
    
    public BulletPluginTest() {
    }
    /*
    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    */
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        //q = new CheckRepWrapper(new Queue(2));
    }
    
    @AfterEach
    public void tearDown() {
        //q.empty()
    }

    /**
     * Test of start method, of class BulletPlugin.
     */
    @org.junit.jupiter.api.Test
    public void testStart() {
        System.out.println("start");
        GameData gameData = null;
        World world = null;
        BulletPlugin instance = new BulletPlugin();
        instance.start(gameData, world);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stop method, of class BulletPlugin.
     */
    @org.junit.jupiter.api.Test
    public void testStop() {
        System.out.println("stop");
        GameData gameData = null;
        World world = null;
        BulletPlugin instance = new BulletPlugin();
        instance.stop(gameData, world);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    //---
    @Test
    public void testBulletPlugin(){
        /*
        boolean res = q.empty();
        assertTrue(res);

        res = q.enqueue(1);
        assertTrue(res);

        res = q.enqueue(2);
        assertTrue(res);

        q.enqueue(3);
        assertTrue(q.getTail() == 0);
        */
    }
}
