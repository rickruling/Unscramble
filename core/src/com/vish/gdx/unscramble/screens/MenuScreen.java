package com.vish.gdx.unscramble.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.vish.gdx.unscramble.utils.Constants;
import com.vish.gdx.unscramble.utils.WordFinder;

public class MenuScreen extends Stage implements Screen, Constants, InputProcessor {

	Game thisGame;
	TextField textField;
	Skin skin;
	WordFinder wordFinder;
	TextButton button;
	Label label;

	public MenuScreen(Game g) {
		super(new StretchViewport(GAME_WIDTH, GAME_HEIGHT));
		thisGame = g;
		skin = new Skin(Gdx.files.internal(UI_SKIN));
		wordFinder = new WordFinder();
		label = new Label("", skin);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(this);
		Gdx.app.log("Menu", "show");
		textField = new TextField("", skin);
		textField.setName(TEXT_ACTOR);

		button = new TextButton("UNSCRAMBLE", skin);
		button.setName(BUTTON_ACTOR);

		textField.setY((float) (GAME_HEIGHT * 0.8));
		textField.setX((float) ((GAME_WIDTH - textField.getWidth()) * 0.5));

		button.setY((float) (GAME_HEIGHT * 0.7));
		button.setX((float) ((GAME_WIDTH - button.getWidth()) * 0.5));

		label.setY((float) (GAME_HEIGHT * 0.5));
		label.setX((float) ((GAME_WIDTH - label.getWidth()) * 0.5));

		button.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				Gdx.app.log("HIT", "STARTING SEARCH..." + textField.getText());
				String text = wordFinder.find(textField.getText().toLowerCase());
				Gdx.app.log("HIT", "FOUND : " + text);
				label.setText(text);
				label.setX((float) ((GAME_WIDTH - label.getWidth()) * 0.5));
				draw();
			}

		});
		addActor(textField);
		addActor(button);
		addActor(label);

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		act(Gdx.graphics.getDeltaTime());
		draw();
	}

	@Override
	public void resize(int width, int height) {

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
