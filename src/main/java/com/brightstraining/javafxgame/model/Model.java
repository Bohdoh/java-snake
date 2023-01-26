package com.brightstraining.javafxgame.model;

import javafx.scene.media.AudioClip;

import java.util.Objects;

public class Model {

    public static final double WIDTH = 500;
    public static final double HEIGHT = 500;
    private final AudioClip buzzer;



    private ScoreBoard scoreBoard;

    private final Player player;
    private final Food food;

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }
    public Food getFood() {
        return food;
    }

    public Model() {
        this.player = new Player();
        this.food = new Food ();
        this.scoreBoard=new ScoreBoard ();
        buzzer = new AudioClip(Objects.requireNonNull(getClass().getResource("/audio/gameboy.mp3")).toExternalForm());
    }

    public Player getPlayer() {
        return player;
    }

    public void update(long milliseconds) {
        player.update(milliseconds);
        //if (player.isMoving()){

        //}
        if(Collision.collidesWithPlayer(player,food)) {
            buzzer.play();
            food.update();
            scoreBoard.update ();
        }
    }
}