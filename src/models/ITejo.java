package models;

public interface ITejo {
    int getGamerPosition();
    int getActualScore();
	int getXTejoPosition();
	int[] getArrowPoints();
	int getYTejoPosition();
	int[] getPowerLine();
	int getMechaX();
	int getScore();
	int getTries();
	int getMaxScore();
	int getMoney();
	int getScoreToPass();
	int getScenarioNumber();
	int getGamerHat();
	void setMoneyByStore(int i);
}
