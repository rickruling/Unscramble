package com.vish.gdx.unscramble.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.badlogic.gdx.Gdx;

public class WordFinder {

	Assets assets = Assets.getInstance();
	Set<String> allCombination;

	public String find(String text) {
		Gdx.app.log("WordFinder", "starting search");
		if (text.length() < 3) {
			return "String too short";
		} else {
			allCombination = new HashSet<String>();
			String match = "Error while searching";
			Gdx.app.log("WordFinder", "getting combination");
			getAllPossibleCombination(text);
			match = getVal(text.length());
			return match;
		}
	}

	private String getVal(int i) {
		Gdx.app.log("WordFinder", "matching");
		String foundword = "";
		switch (i) {
		case 3:
			foundword = search(assets.threeDigits);
			break;
		case 4:
			foundword = search(assets.fourDigits);
			break;
		case 5:
			foundword = search(assets.fiveDigits);
			break;
		case 6:
			foundword = search(assets.sixDigits);
			break;
		case 7:
			foundword = search(assets.sevenDigits);
			break;
		case 8:
			foundword = search(assets.eightDigits);
			break;
		case 9:
			foundword = search(assets.nineDigits);
			break;
		case 10:
			foundword = search(assets.tenDigits);
			break;
		case 11:
			foundword = search(assets.elevenDigits);
			break;
		case 12:
			foundword = search(assets.twelveDigits);
			break;
		case 13:
			foundword = search(assets.thirteenDigits);
			break;
		case 14:
			foundword = search(assets.fouteenDigits);
			break;
		case 15:
			foundword = search(assets.fifteenDigits);
			break;
		case 16:
			foundword = search(assets.sixteenDigits);
			break;
		case 17:
			foundword = search(assets.seventeenDigits);
			break;
		case 18:
			foundword = search(assets.eighteenDigits);
			break;
		case 19:
			foundword = search(assets.nineteenDigits);
			break;
		case 20:
			foundword = search(assets.twentyDigits);
			break;

		}
		return foundword;
	}

	private String search(Set<String> possibleWords) {
		Gdx.app.log("WordFinder", "searching");
		Gdx.app.log("WordFinder", "possibleWords  :" + possibleWords.size());
		Gdx.app.log("WordFinder", "combination  :" + allCombination);
		String correctWord = "No Word Found";
		boolean found = false;
		for (String combination : allCombination) {
			if (possibleWords.contains(combination)) {
				if (found) {
					correctWord += "\n" + combination;
					Gdx.app.log("WordFinder", "nth " + combination);
				} else {
					correctWord = combination;
					found = true;
					Gdx.app.log("WordFinder", "1st " + combination);
				}
			}
		}
		Gdx.app.log("WordFinder", "found : " + correctWord);
		return correctWord;
	}

	public ArrayList<String> getAllPossibleCombination(String text) {
		permute(text, 0, text.length() - 1);
		return null;
	}

	private void permute(String str, int l, int r) {
		if (l == r) {
			Gdx.app.log("Menu", "c  :" + str);
			allCombination.add(str);
		} else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

}
