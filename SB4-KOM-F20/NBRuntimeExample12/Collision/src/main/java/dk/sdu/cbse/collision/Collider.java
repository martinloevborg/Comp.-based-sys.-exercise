
package dk.sdu.cbse.collision;

import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.World;
import dk.sdu.cbse.common.entityparts.PositionPart;
import dk.sdu.cbse.common.entityparts.LifePart;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;
import org.openide.util.lookup.ServiceProvider;

@ServiceProvider(service = IPostEntityProcessingService.class)
public class Collider implements IPostEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {      
        for (Entity entity : world.getEntities()) {
            for (Entity collisionDetection : world.getEntities()) {
                LifePart entityLife = entity.getPart(LifePart.class);
                LifePart collisionLife = collisionDetection.getPart(LifePart.class);
               
                if (entity.getID().equals(collisionDetection.getID())) {
                    continue;
                }

                if (this.Collides(entity, collisionDetection)) {
                    if (entityLife.getLife() > 0) {
                        entityLife.setLife(entityLife.getLife() - 1);
                        entityLife.setIsHit(true);
                        if (entityLife.getLife() <= 0) {
                            world.removeEntity(entity);
                        }
                    }
                }
            }
        }
    }

    public Boolean Collides(Entity entity, Entity entity2) {
        PositionPart entMov = entity.getPart(PositionPart.class);
        PositionPart entMov2 = entity2.getPart(PositionPart.class);
        float dx = (float) entMov.getX() - (float) entMov2.getX();
        float dy = (float) entMov.getY() - (float) entMov2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        if (distance < (entity.getRadius() + entity2.getRadius())) {
            return true;
        }
        return false;
    }

}
