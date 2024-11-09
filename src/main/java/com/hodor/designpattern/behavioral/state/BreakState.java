package com.hodor.designpattern.behavioral.state;

public class BreakState extends State {

    public BreakState(Game game) {
        super(game);
        System.out.println("-- Game in Break State --");
    }

    @Override
    public void onWelcomeScreen() {
        System.out.println("Not allowed !");
    }

    @Override
    public void onPlaying() {
        game.changeState(new PlayingState(game));
    }

    @Override
    public void onBreak() {
        System.out.println("Currently in break state");
    }

    @Override
    public void onEndGame() {
        System.out.println("Not allowed !");
    }
}
