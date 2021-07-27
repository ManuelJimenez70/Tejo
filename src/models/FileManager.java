package models;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.json.JSONObject;

public class FileManager{

	private static final String MAX_SCORE_TAG = "maxScore";
	private static final URL JSON_DOG_PATH = FileManager.class.getResource("/resources/persistance/scores.txt");

	private int maxScore;

	public FileManager() {
		maxScore = 0;
		try {
			readMaxScore();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeJson() throws JSONException, IOException {
		JSONObject json = new JSONObject();
		JSONObject jsonScore = new JSONObject();
		jsonScore.put("score", maxScore);
		json.put(MAX_SCORE_TAG, jsonScore);
		FileWriter file = new FileWriter(JSON_DOG_PATH.getPath().substring(1));
		file.write(json.toString(4));
		file.flush();
	}

	public void readMaxScore() throws IOException {
		String text = String.join(" ", Files.readAllLines(Paths.get(JSON_DOG_PATH.getPath().substring(1))));
		JSONObject json = new JSONObject(text);
		JSONObject jsonScore = json.getJSONObject(MAX_SCORE_TAG);
		this.maxScore = Integer.parseInt(jsonScore.get("score").toString());
	}

	public int getMaxScore() {
		return this.maxScore;
	}
	
	public void checkMaxScore(int newScore) {
		if (newScore>maxScore) {
			maxScore = newScore;
			try {
				writeJson();
			} catch (JSONException | IOException e) {
				e.printStackTrace();
			}
		}

	}

}
