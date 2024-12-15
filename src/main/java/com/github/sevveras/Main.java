package com.github.sevveras;

import com.github.sevveras.model.GameBoard;
import com.github.sevveras.view.Render;

public class Main {
    public static void main(String[] args) {
        var board = new GameBoard(8, 2);
        board.randomizeState();
        Render.renderBoard(board);
    }
}