package huds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.melihkacaman.jackthegiant.GameMain;
import helpers.GameInfo;
import scenes.Gameplay;
import scenes.Highscore;
import scenes.Options;


public class MainMenuButtons {
    private GameMain gameMain;
    private Stage stage;
    private Viewport gameViewport;

    private ImageButton playBtn;
    private ImageButton highscoreBtn;
    private ImageButton optionsBtn;
    private ImageButton quitBtn;
    private ImageButton musicBtn;

    public MainMenuButtons(GameMain gameMain) {
        this.gameMain = gameMain;

        gameViewport = new FitViewport(GameInfo.WIDTH, GameInfo.HEIGHT, new OrthographicCamera());
        stage = new Stage(gameViewport, gameMain.getBatch());

        Gdx.input.setInputProcessor(stage);

        createAndPositionButtons();
        addAllListeners();

        stage.addActor(playBtn);
        stage.addActor(highscoreBtn);
        stage.addActor(optionsBtn);
        stage.addActor(quitBtn);
        stage.addActor(musicBtn);
    }

    private void addAllListeners() {
        playBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameMain.setScreen(new Gameplay(gameMain));
            }
        });

        highscoreBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameMain.setScreen(new Highscore(gameMain));
            }
        });

        optionsBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameMain.setScreen(new Options(gameMain));
            }
        });

        quitBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

            }
        });

        musicBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

            }
        });
    }

    private void createAndPositionButtons(){
        playBtn = addButton("Start Game.png");
        highscoreBtn = addButton("Highscore.png");
        optionsBtn = addButton("Options.png");
        quitBtn = addButton("Quit.png");
        musicBtn = addButton("Music On.png");

        playBtn.setPosition(GameInfo.WIDTH / 2 - 80, GameInfo.HEIGHT / 2 + 50, Align.center);
        highscoreBtn.setPosition(GameInfo.WIDTH / 2 - 60, GameInfo.HEIGHT / 2 + -20, Align.center);
        optionsBtn.setPosition(GameInfo.WIDTH / 2 - 40, GameInfo.HEIGHT / 2 - 90, Align.center);
        quitBtn.setPosition(GameInfo.WIDTH / 2 - 20, GameInfo.HEIGHT / 2 - 160, Align.center);
        musicBtn.setPosition(GameInfo.WIDTH - 13, 13, Align.bottomRight);
    }

    private ImageButton addButton(String assetsName){
        return new ImageButton(new SpriteDrawable(new Sprite(new Texture("Buttons/Main Menu/" + assetsName))));
    }


    public Stage getStage() {
        return stage;
    }
}
