package dk.sdu.cbse.enemy;

import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.World;
import dk.sdu.cbse.common.entityparts.MovingPart;
import dk.sdu.cbse.common.entityparts.PositionPart;
import dk.sdu.cbse.common.entityparts.LifePart;
import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.commonenemy.Enemy;
import java.util.Random;
import org.openide.util.lookup.ServiceProvider;

@ServiceProvider(service = IEntityProcessingService.class)
public class EnemyControlSystem implements IEntityProcessingService{
    
    private Entity enemy;
    
    @Override
    public void process(GameData gameData, World world) {
        for (Entity enemy : world.getEntities(Enemy.class)) {
            PositionPart positionPart = enemy.getPart(PositionPart.class);
            MovingPart movingPart = enemy.getPart(MovingPart.class);
            LifePart lifePart = enemy.getPart(LifePart.class);

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
            
            lifePart.process(gameData, enemy);
            movingPart.process(gameData, enemy);
            positionPart.process(gameData, enemy);
            updateShape(enemy);
            movingPart.setLeft(false);
            movingPart.setUp(false);
            movingPart.setRight(false);
        }
    }
    
    private void updateShape(Entity enemy) {
        float[] shapex = new float[4];
        float[] shapey = new float[4];
        PositionPart positionPart = enemy.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * enemy.getRadius());
        shapey[0] = (float) (y + Math.sin(radians) * enemy.getRadius());

        shapex[1] = (float) (x + Math.cos(radians - 4 * 3.1415f / 5) * enemy.getRadius());
        shapey[1] = (float) (y + Math.sin(radians - 4 * 3.1145f / 5) * enemy.getRadius());

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * enemy.getRadius() * 0.5);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * enemy.getRadius() * 0.5);

        shapex[3] = (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * enemy.getRadius());
        shapey[3] = (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * enemy.getRadius());

        enemy.setShapeX(shapex);
        enemy.setShapeY(shapey);
    }

    
}
