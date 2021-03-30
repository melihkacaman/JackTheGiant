package clouds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import helpers.GameInfo;

public class Cloud extends Sprite {
    private World world;
    private Body body;
    String claudName;

    public Cloud(World world, String claudName) {
        super(new Texture("Clouds/" + claudName + ".png"));

        this.world = world;
        this.claudName = claudName;
    }

    private void createBody(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;

        bodyDef.position.set((getX() + getWidth() / 2) / GameInfo.PPM, (getY() + getHeight() / 2) / GameInfo.PPM);

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox((getWidth() / 2) / GameInfo.PPM,(getHeight() / 2) / GameInfo.PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;

        Fixture fixture = body.createFixture(fixtureDef);

        shape.dispose();

    }

    public void setSpritePosition(float x, float y){
        setPosition(x,y);
        createBody();
    }

    public String getClaudName(){
        return this.claudName; 
    }
}
