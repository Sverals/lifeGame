package com.github.sevveras.Logic;

import com.github.sevveras.model.GameBoard;
import com.github.sevveras.view.Render;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GameLoop {
    private int width;
    private int height;

    public GameLoop(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void runGame(int runSpeed) throws InterruptedException, IOException {
        int count = 0;
        GameBoard board = new GameBoard(width, height);
        board.randomizeState();
        while (count < 90000) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            Render.renderBoard(board);
            board.setBoard(GameActions.generateNextBoardState(board));
            TimeUnit.MILLISECONDS.sleep(runSpeed);
            count++;
        }


    }


}
