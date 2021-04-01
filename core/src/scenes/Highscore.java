package scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.melihkacaman.jackthegiant.GameMain;
import helpers.GameInfo;
import huds.HighscoreButtons;

public class Highscore implements Screen {
    private GameMain gameMain;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Texture bg;
    private HighscoreButtons highscoreButtons;

    public Highscore(GameMain gameMain) {
        this.gameMain = gameMain;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameInfo.WIDTH, GameInfo.HEIGHT);
        camera.position.set(GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f, 0);

        viewport = new StretchViewport(GameInfo.WIDTH, GameInfo.HEIGHT, camera);
        bg = new Texture("Backgrounds/Highscore BG.png");
        highscoreButtons = new HighscoreButtons(gameMain);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameMain.getBatch().begin();
        gameMain.getBatch().draw(bg, 0, 0);
        gameMain.getBatch().end();

        gameMain.getBatch().setProjectionMatrix(highscoreButtons.getStage().getCamera().combined);
        highscoreButtons.getStage().draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        bg.dispose();
        highscoreButtons.getStage().dispose();
    }
}
