package clouds;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import helpers.GameInfo;

import java.util.Random;

public class CloudsController {
    private World world;
    private Array<Cloud> clouds;
    private final  float DISTANCE_BETWEEN_CLOUDS = 250f;
    private float minX, maxX;
    private Random random = new Random();
    private float cameraY;
    private float lastPositionY;

    public CloudsController(World world) {
        this.world = world;
        clouds = new Array<>();
        minX = GameInfo.WIDTH / 2 - 110;
        maxX = GameInfo.WIDTH / 2 + 110;
        createClauds();
        positionClouds(true);
    }

    private void createClauds() {
        for (int i = 0; i < 2; i++) {
            clouds.add(new Cloud(this.world, "Dark Cloud"));
        }

        int index = 1;
        for (int i = 0; i < 6; i++) {
            clouds.add(new Cloud(this.world, "Cloud " + index));
            index = (index == 4) ? 1 : index++;
        }

        clouds.shuffle();
    }

    public void positionClouds(boolean firstTimeArranging){
        while (clouds.get(0).getClaudName().equals("Dark Cloud")){
            clouds.shuffle();
        }

        float positionY = 0;
        if (firstTimeArranging == true){
            positionY = GameInfo.HEIGHT / 2f;
        }else {
            positionY = lastPositionY;
        }

        int controlX = 0;

        for (Cloud c : clouds) {
            if (c.getY() == 0 && c.getX() == 0){
                float tempX = 0;
                if (controlX == 0){
                    tempX = randomBetweenNumbers(maxX - 40, maxX);
                    controlX = 1;
                }else{
                    tempX = randomBetweenNumbers(minX + 40, minX);
                    controlX = 0;
                }

                c.setSpritePosition(tempX, positionY);

                positionY -= DISTANCE_BETWEEN_CLOUDS;
                lastPositionY = positionY;
            }
        }
    }

    public void drawClouds(SpriteBatch batch){
        for (Cloud c : clouds){
            batch.draw(c, c.getX() - c.getWidth() / 2f, c.getY() - c.getHeight() / 2f);
        }
    }

    public void createAndArrangeNewClouds(){
        for (int i = 0; i < clouds.size; i++) {
            if ((clouds.get(i).getY() - (GameInfo.HEIGHT / 2 - 10)) > cameraY){   // WARNING
                // that means out of windows
                clouds.get(i).getTexture().dispose();
                clouds.removeIndex(i);
            }
        }

        if (clouds.size == 4){
            createClauds();
            positionClouds(false);
        }
    }

    public void setCameraY(float cameraY) {
        this.cameraY = cameraY;
    }

    private float randomBetweenNumbers(float min, float max){
        return random.nextFloat() * (max - min) + min;
    }
}
