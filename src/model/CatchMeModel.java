package model;

import java.util.LinkedList;
import java.util.Random;

public class CatchMeModel {
    private int points;
    private double avgTime;
    private double time;
    private int timeCount;

    private double startTime = System.currentTimeMillis();
    private LinkedList<Button> buttons;

    public CatchMeModel() {
        buttons = new LinkedList();
        points = 0;
        avgTime = 0;
        time = 0;
    }

    public void addButtons(int amount) {
        for (int i = 0; i < amount; i++) {
            buttons.add(new Button(i));
        }
    }

    public int pickRandomButton() {
        Random rndm = new Random();
        return rndm.nextInt(buttons.size());
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public double getTime() {
        time = (System.currentTimeMillis() - startTime)/1000;
        return time;
    }

    public void setStartTime() {
        startTime = System.currentTimeMillis();
    }

    public double getAvgTime() {
        return avgTime / timeCount;
    }

    public void setAvgTime() {
        timeCount++;
        avgTime += getTime();
    }

    public void setTime(int time) {
        this.time = time;
    }
}
