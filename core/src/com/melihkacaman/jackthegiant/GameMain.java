package com.melihkacaman.jackthegiant;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import scenes.Gameplay;
import scenes.MainMenu;

public class GameMain extends Game {
	private SpriteBatch batch;
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new MainMenu(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	public SpriteBatch getBatch(){
		return this.batch;
	}
}
