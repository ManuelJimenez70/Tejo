package models;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.json.JSONObject;

public class FileManager{

	private static final String GAME_TAG = "game";
	private static final URL JSON_PATH = FileManager.class.getResource("/resources/persistance/scores.txt");

	private int maxScore;
	private int money;
	public FileManager() {
		maxScore = 0;
		money = 0;
		try {
			readJson();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeJson() throws JSONException, IOException {
		JSONObject json = new JSONObject();
		JSONObject jsonGame = new JSONObject();
		jsonGame.put("score", maxScore);
		jsonGame.put("money", money);
		json.put(GAME_TAG, jsonGame);
		FileWriter file = new FileWriter(JSON_PATH.getPath().substring(1));
		file.write(json.toString(4));
		file.flush();
	}

	public void readJson() throws IOException {
		String text = String.join("", Files.readAllLines(Paths.get(JSON_PATH.getPath().substring(1))));
		JSONObject json = new JSONObject(text);
		JSONObject jsonScore = json.getJSONObject(GAME_TAG);
		this.maxScore = Integer.parseInt(jsonScore.get("score").toString());
		this.money = Integer.parseInt(jsonScore.get("money").toString());
	}

	public int getMaxScore() {
		return this.maxScore;
	}
	
	public boolean checkMaxScore(int newScore) {
		if (newScore>maxScore) {
			maxScore = newScore;
			try {
				writeJson();
			} catch (JSONException | IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;

	}

	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		this.money = money;
		try {
			writeJson();
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
