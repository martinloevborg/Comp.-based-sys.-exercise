/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import dk.sdu.mmmi.cbse.main.Game;
import java.util.Random;

/**
 *
 * @author Bruger
 */
public class Enemy extends SpaceObject {

    private boolean left;
    private boolean right;
    private boolean up;

    private float maxSpeed;
    private float acceleration;
    private float deceleration;

    public Enemy() {

        x = Game.WIDTH / 2;
        y = Game.HEIGHT / 2;

        maxSpeed = 300;
        acceleration = 200;
        deceleration = 10;

        shapex = new float[4];
        shapey = new float[4];

        radians = 3.1415f / 2;
        rotationSpeed = 3;

    }

    private void setShape() {
        shapex[0] = x + MathUtils.cos(radians) * 8;
        shapey[0] = y + MathUtils.sin(radians) * 8;

        shapex[1] = x + MathUtils.cos(radians - 4 * 3.1415f / 5) * 8;
        shapey[1] = y + MathUtils.sin(radians - 4 * 3.1145f / 5) * 8;

        shapex[2] = x + MathUtils.cos(radians + 3.1415f) * 5;
        shapey[2] = y + MathUtils.sin(radians + 3.1415f) * 5;

        shapex[3] = x + MathUtils.cos(radians + 4 * 3.1415f / 5) * 8;
        shapey[3] = y + MathUtils.sin(radians + 4 * 3.1415f / 5) * 8;
    }

    public void setLeft(boolean b) {
        left = b;
    }

    public void setRight(boolean b) {
        right = b;
    }

    public void setUp(boolean b) {
        up = b;
    }

    public void update(float dt) { //måske skal det være en blanding?
        Random rand = new Random();

        float rng = rand.nextFloat();

        if (rng > 0.1f && rng < 0.9f) {
            setUp(true);
        }

        if (rng < 0.2f) {
            setLeft(true);
        }

        if (rng > 0.8f) {
            setRight(true);
        }
        /* fra asteroidsserviceloader - enemy- enemycontrolsystem
        @Override
        public void process(GameData gameData, World world) {
            for (Entity enemy : world.getEntities(Enemy.class)) {
                PositionPart positionPart = enemy.getPart(PositionPart.class);
                MovingPart movingPart = enemy.getPart(MovingPart.class);

                Random rand = new Random();

                float rng = rand.nextFloat();

                if (rng > 0.1f && rng < 0.9f) {
                    movingPart.setUp(true);
                }

                if (rng < 0.2f) {
                    movingPart.setLeft(true);
                }

                if (rng > 0.8f) {
                    movingPart.setRight(true);
                }

                movingPart.process(gameData, enemy);
                positionPart.process(gameData, enemy);
                updateShape(enemy);
                movingPart.setLeft(false);
                movingPart.setUp(false);
            }
        }
         */
 /* fra player
        // turning
        if (left) {
            radians += rotationSpeed * dt;
        } else if (right) {
            radians -= rotationSpeed * dt;
        }

        // accelerating
        if (up) {
            dx += MathUtils.cos(radians) * acceleration * dt;
            dy += MathUtils.sin(radians) * acceleration * dt;
        }

        // deceleration
        float vec = (float) Math.sqrt(dx * dx + dy * dy);
        if (vec > 0) {
            dx -= (dx / vec) * deceleration * dt;
            dy -= (dy / vec) * deceleration * dt;
        }
        if (vec > maxSpeed) {
            dx = (dx / vec) * maxSpeed;
            dy = (dy / vec) * maxSpeed;
        }

        // set position
        x += dx * dt;
        y += dy * dt;

        // set shape
        setShape();

        // screen wrap
        wrap();
         */
    }

    public void draw(ShapeRenderer sr) {

        sr.setColor(1, 1, 1, 1);

        sr.begin(ShapeType.Line);

        for (int i = 0, j = shapex.length - 1;
                i < shapex.length;
                j = i++) {

            sr.line(shapex[i], shapey[i], shapex[j], shapey[j]);

        }

        sr.end();

    }

}
