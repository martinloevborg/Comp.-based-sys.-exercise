package dk.sdu.cbse.common.entityparts;

import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.GameData;

public class LifePart implements EntityPart {

    private int life;
    private boolean isHit = false;
    private boolean dead = false;

    public LifePart(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setIsHit(boolean isHit) {
        this.isHit = isHit;
    }

    public boolean isDead() {
        return dead;
    }

    @Override
    public void process(GameData gameData, Entity entity) {
        if (isHit) {
            life = - 1;
            isHit = false;
        }
        if (life <= 0) {
            dead = true;
        }

    }

}
