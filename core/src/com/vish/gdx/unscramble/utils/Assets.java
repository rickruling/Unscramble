package com.vish.gdx.unscramble.utils;

import java.util.HashSet;
import java.util.Set;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable, AssetErrorListener, Constants {

	public static final Assets instance = new Assets();

	public Set<String> threeDigits;
	public Set<String> fourDigits;
	public Set<String> fiveDigits;
	public Set<String> sixDigits;
	public Set<String> sevenDigits;
	public Set<String> eightDigits;
	public Set<String> nineDigits;
	public Set<String> tenDigits;
	public Set<String> elevenDigits;
	public Set<String> twelveDigits;
	public Set<String> thirteenDigits;
	public Set<String> fouteenDigits;
	public Set<String> fifteenDigits;
	public Set<String> sixteenDigits;
	public Set<String> seventeenDigits;
	public Set<String> eighteenDigits;
	public Set<String> nineteenDigits;
	public Set<String> twentyDigits;

	public static Assets getInstance() {
		return instance;
	}

	public void init(AssetManager assetManager) {

		threeDigits = load(THREE_DIGIT);
		fourDigits = load(FOUR_DIGIT);
		fiveDigits = load(FIVE_DIGIT);
		sixDigits = load(SIX_DIGIT);
		sevenDigits = load(SEVEN_DIGIT);
		eightDigits = load(EIGHT_DIGIT);
		nineDigits = load(NINE_DIGIT);
		tenDigits = load(TEN_DIGIT);
		elevenDigits = load(ELEVEN_DIGIT);
		twelveDigits = load(TWELVE_DIGIT);
		thirteenDigits = load(THIRTEEN_DIGIT);
		fouteenDigits = load(FORTEEN_DIGIT);
		fifteenDigits = load(FIFTEEN_DIGIT);
		sixteenDigits = load(SIXTEEN_DIGIT);
		seventeenDigits = load(SEVENTEEN_DIGIT);
		eighteenDigits = load(EIGHTEEN_DIGIT);
		nineteenDigits = load(NINETEEN_DIGIT);
		twentyDigits = load(TWENTY_DIGIT);
		Gdx.app.log("Assets", "LOAD cOMPLETE");
		Gdx.app.log("Assets", "init");
		Gdx.app.log("Assets", "Three Digit : " + threeDigits.size());

	}

	public Set<String> load(String fileName) {
		Set<String> arr = new HashSet<String>();
		FileHandle handle = Gdx.files.internal(fileName);
		String text = handle.readString();
		String wordsArray[] = text.split(",");
		for (String word : wordsArray) {
			arr.add(word);
		}
		return arr;
	}

	@Override
	public void error(@SuppressWarnings("rawtypes") AssetDescriptor asset, Throwable throwable) {

	}

	@Override
	public void dispose() {

	}

}
