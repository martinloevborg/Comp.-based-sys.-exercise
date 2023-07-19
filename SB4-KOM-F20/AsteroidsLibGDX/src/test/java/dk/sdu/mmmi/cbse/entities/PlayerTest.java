/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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
public class PlayerTest {
    
    //private IQueue q;
    
    public PlayerTest() {
    }
    
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
     * Test of setLeft method, of class Player.
     */
    @Test
    public void testSetLeft() {
        System.out.println("setLeft");
        boolean b = false;
        Player instance = new Player();
        instance.setLeft(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRight method, of class Player.
     */
    @Test
    public void testSetRight() {
        System.out.println("setRight");
        boolean b = false;
        Player instance = new Player();
        instance.setRight(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUp method, of class Player.
     */
    @Test
    public void testSetUp() {
        System.out.println("setUp");
        boolean b = false;
        Player instance = new Player();
        instance.setUp(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Player.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        float dt = 0.0F;
        Player instance = new Player();
        instance.update(dt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of draw method, of class Player.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        ShapeRenderer sr = null;
        Player instance = new Player();
        instance.draw(sr);
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
