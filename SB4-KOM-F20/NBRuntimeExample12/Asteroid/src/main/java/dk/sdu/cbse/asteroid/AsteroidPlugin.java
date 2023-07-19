package dk.sdu.cbse.asteroid;

import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.World;
import dk.sdu.cbse.common.entityparts.LifePart;
import dk.sdu.cbse.common.entityparts.MovingPart;
import dk.sdu.cbse.common.entityparts.PositionPart;
import dk.sdu.cbse.common.services.IGamePluginService;
import org.openide.util.lookup.ServiceProvider;
import dk.sdu.cbse.commonasteroids.Asteroid;

@ServiceProvider(service = IGamePluginService.class)
public class AsteroidPlugin
        implements IGamePluginService {

    @Override
    public void start(GameData gameData, World world) {

        Entity asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }

    @Override
    public void stop(GameData gameData, World world) {
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            world.removeEntity(asteroid);
        }
    }

    private Entity createAsteroid(GameData gameData) {
        Entity asteroid = new Asteroid();
        float speed = (float) Math.random() * 10f + 20f;
        float radians = 3.1415f * 2 * (float) Math.random();

        asteroid.add(new MovingPart(0, speed, speed, 0));
        asteroid.add(new PositionPart(30, 30, radians));
        asteroid.add(new LifePart(3));
        asteroid.setRadius(20);

        return asteroid;
    }
}
