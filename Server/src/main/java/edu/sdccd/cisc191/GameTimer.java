package edu.sdccd.cisc191;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.text.DecimalFormat;

public class GameTimer extends GUI{


    private int second, minute;
    private final DecimalFormat decimalFormat = new DecimalFormat("00");

    public void runTimer() {

        timer = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                second++;

                if (second == 60) {
                    second = 0;
                    minute++;
                }
                timerLabel.setText(decimalFormat.format(minute) + ":" + decimalFormat.format(second));
            }
        }));
        timer.setCycleCount(Animation.INDEFINITE);
        timer.play();
    } //end createTimer()

    public void endTimer() {
        timer.stop();
    } //end endTimer()

    public int getSecond() {
        return second;
    } //end getSecond()

    public int getMinute() {
        return minute;
    }
}
