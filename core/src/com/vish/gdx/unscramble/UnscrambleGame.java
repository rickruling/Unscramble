package com.vish.gdx.unscramble;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.vish.gdx.unscramble.screens.SplashScreen;
import com.vish.gdx.unscramble.utils.Assets;

public class UnscrambleGame extends Game {

	Stage stage;

	@Override
	public void create() {
		Gdx.app.log("Game", "App created");
		Assets.instance.init(new AssetManager());
		setScreen(new SplashScreen(this));
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor((float)149/255, (float)209/255, (float)237/255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}

	@Override
	public void dispose() {

	}
}
