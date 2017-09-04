package com.vish.gdx.unscramble.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.vish.gdx.unscramble.actors.MyImageActor;
import com.vish.gdx.unscramble.utils.Constants;

public class SplashScreen extends Stage implements Screen,Constants {

	Game thisGame;

	public SplashScreen(Game g) {
		super(new StretchViewport(GAME_WIDTH, GAME_HEIGHT));
		thisGame = g;
	}

	@Override
	public void show() {
		Gdx.app.log("Splash", "show");
		MyImageActor splashLogo = new MyImageActor(new Texture(Gdx.files.internal(LOGO_IMAGE)));
		splashLogo.setX((GAME_WIDTH - splashLogo.getWidth()) / 2);
		splashLogo.setY((GAME_HEIGHT - splashLogo.getHeight()) / 2);
		addActor(splashLogo);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1,1,1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		act(Gdx.graphics.getDeltaTime());
		draw();
		if (Gdx.input.justTouched())
			thisGame.setScreen(new MenuScreen(thisGame));

	}

	@Override
	public void resize(int width, int height) {
		getViewport().update(width, height, true);
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

	}

}
