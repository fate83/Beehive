package de.stealmycode.beehive.model.world.animals;

import java.util.List;

import de.stealmycode.beehive.model.world.AbstractDrawableObject;
import de.stealmycode.beehive.model.world.Field;
import de.stealmycode.beehive.model.world.FieldProperty;
import de.stealmycode.beehive.model.world.IAttackable;
import de.stealmycode.beehive.model.world.Pathfinder;
import de.stealmycode.beehive.model.world.World;
import de.stealmycode.beehive.utils.Position;

public abstract class AbstractMovableObject extends AbstractDrawableObject implements IMovable, IAttackable {
    
    private List<Position> path = null;
    
    @Override
    public abstract int getAttack();

    @Override
    public abstract int getDefense();

    @Override
    public abstract int getHealth();

    private float progress = 0.0f;
    
    public AbstractMovableObject(Position position) {
        super(position);
    }
    
    @Override
    public abstract int getImageID() ;

    @Override
    public float getProgress() {
        return 0;
    }
    
    public void setProgress(float p) {
        if (p < 0 || progress > 1) {
            // TODO: Print Log Message
            if (p < 0) p = p * -1;
            if (p > 1) p = p - (int) p;
        }
        progress = p;
    }
    
    public abstract String getAccessibleProperty();
    
    public boolean canStepOn(Field field) {
        for (FieldProperty property : field.getProperties()) {
            if (property.getName().equals(getAccessibleProperty())) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     * @param world
     * @param field
     */
    public void move(World world, Field field) {
        Pathfinder pathfinder = new Pathfinder(world, this);
        path = pathfinder.calculate(getPosition(), field.getPosition());
        for (Position position : path) {
            System.out.println(position.getX() + ", " + position. getY());
        }
        System.out.println(path);
    }
    
    

}
