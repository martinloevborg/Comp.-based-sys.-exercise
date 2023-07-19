package dk.sdu.mmmi.cbse.enemy1;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;
import java.util.Random;
import dk.sdu.mmmi.cbse.common.enemy.Enemy;

/*
@ServiceProviders(value = {
    @ServiceProvider(service = IGamePluginService.class)
})
*/
public class EnemyPlugin implements IGamePluginService {

    private Entity enemy;

    @Override
    public void start(GameData gameData, World world) {
        enemy = createEnemy(gameData);
        world.addEntity(enemy);
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(enemy);
    }

    private Entity createEnemy(GameData gameData) {
        enemy = new Enemy();
        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 300;
        float rotationSpeed = 5;
        float x = new Random().nextFloat() * gameData.getDisplayWidth();
        float y = new Random().nextFloat() * gameData.getDisplayHeight();
        float radians = 3.1415f / 2;

        float[] color = new float[4];
        color[0] = 1.0f;
        color[1] = 0.0f;
        color[2] = 0.0f;
        color[3] = 1.0f;
        
        enemy.add(new LifePart(1));
        enemy.setRadius(8);
        enemy.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        enemy.add(new PositionPart(x, y, radians));
        //enemy.setColor(color);
        return enemy;
    }
}
