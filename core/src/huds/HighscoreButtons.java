package huds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.melihkacaman.jackthegiant.GameMain;
import helpers.GameInfo;
import scenes.MainMenu;

public class HighscoreButtons {
    private GameMain gameMain;
    private Viewport viewport;
    private Stage stage;

    private ImageButton backBtn;
    private Label scoreLabel;
    private Label coinLabel;

    public HighscoreButtons(GameMain gameMain) {
        this.gameMain = gameMain;

        viewport = new FitViewport(GameInfo.WIDTH, GameInfo.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, gameMain.getBatch());

        Gdx.input.setInputProcessor(stage);

        createAndPositionUIElements();

        stage.addActor(backBtn);
        stage.addActor(scoreLabel);
        stage.addActor(coinLabel);
    }

    private void createAndPositionUIElements() {
        backBtn = new ImageButton(new SpriteDrawable(new Sprite(new Texture("Buttons/Options Menu/Back.png"))));

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Fonts/blow.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameters.size = 60;

        BitmapFont scoreFont = generator.generateFont(parameters);
        BitmapFont coinFont = generator.generateFont(parameters);

        scoreLabel = new Label("100", new Label.LabelStyle(scoreFont, Color.WHITE));
        coinLabel = new Label("100", new Label.LabelStyle(scoreFont, Color.WHITE));

        backBtn.setPosition(17,17, Align.bottomLeft);

        scoreLabel.setPosition(GameInfo.WIDTH / 2f - 40, GameInfo.HEIGHT / 2 - 120);
        coinLabel.setPosition(GameInfo.WIDTH / 2f - 40, GameInfo.HEIGHT / 2 - 220);

        backBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameMain.setScreen(new MainMenu(gameMain));
            }
        });
    }

    public Stage getStage(){
        return this.stage;
    }
}
