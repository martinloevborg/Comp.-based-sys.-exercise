package dk.sdu.cbse.asteroid;

import dk.sdu.cbse.commonasteroids.Asteroid;
import dk.sdu.cbse.commonasteroids.IAsteroidSplitter;
import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.World;
import dk.sdu.cbse.common.entityparts.MovingPart;
import dk.sdu.cbse.common.entityparts.PositionPart;
import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.commonasteroids.Asteroid;
import dk.sdu.cbse.commonasteroids.IAsteroidSplitter;
import org.openide.util.lookup.ServiceProvider;
import dk.sdu.cbse.common.entityparts.LifePart;

@ServiceProvider(service = IEntityProcessingService.class)
public class AsteroidControlSystem implements IEntityProcessingService {

    private IAsteroidSplitter asteroidSplit = new AsteroidSplitter();

    @Override
    public void process(GameData gameData, World world) {
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            PositionPart positionPart = asteroid.getPart(PositionPart.class);
            MovingPart movingPart = asteroid.getPart(MovingPart.class);
            LifePart lifePart = asteroid.getPart(LifePart.class);

            int numPoints = 12;
            float speed = (float) Math.random() * 10f + 20f;

            if (lifePart.getLife() == 1) {
                numPoints = 8;
                speed = (float) Math.random() * 30f + 70f;
            } else {
                numPoints = 10;
                speed = (float) Math.random() * 10f + 50f;
            }

            movingPart.process(gameData, asteroid);
            positionPart.process(gameData, asteroid);

            movingPart.setSpeed(speed);
            movingPart.setUp(true);
            if (lifePart.isHit()) {
                asteroidSplit.createSplitAsteroid(asteroid, world);
            }
            setShape(asteroid, numPoints);
        }
    }

    public void setAsteroidSplitter(IAsteroidSplitter asteroidSplitter) {
        this.asteroidSplit = asteroidSplitter;
    }

    public void removeAsteroidSplitter(IAsteroidSplitter asteroidSplitter) {
        this.asteroidSplit = null;
    }

    private void setShape(Entity entity, int numPoints) {

        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        float[] shapex = new float[numPoints];
        float[] shapey = new float[numPoints];
        float angle = 0;
        for (int i = 0; i < numPoints; i++) {
            shapex[i] = x + (float) Math.cos(angle + radians) * 26;
            shapey[i] = y + (float) Math.sin(angle + radians) * 26;
            angle += 2 * 3.1415f / numPoints;
        }

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }
}
