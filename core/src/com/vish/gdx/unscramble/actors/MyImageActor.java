package com.vish.gdx.unscramble.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MyImageActor extends Image {

	public MyImageActor(Texture texture) {
		super(texture);
		setBounds(getX(), getY(), getWidth(), getHeight());
	}

}
