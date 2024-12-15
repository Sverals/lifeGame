package com.github.sevveras.view;

import com.github.sevveras.model.GameBoard;

import java.util.ArrayList;

public class Render {
    public static final char LIVE_CELL_SYMBOL = '#';
    public static final char DEAD_CELL_SYMBOL = ' ';
    public static final char BOARD_BORDER_SYMBOL = '|';


    public static void renderBoard(GameBoard board) {
        var boardState = board.getBoard();
        for (ArrayList<Integer> row : boardState) {
            printRow(row);
        }
    }

    private static void printRow(ArrayList<Integer> row) {
        System.out.print(BOARD_BORDER_SYMBOL);
        for (Integer currentValue : row) {
            printCellSymbolWithState(currentValue);
        }
        System.out.println(BOARD_BORDER_SYMBOL);
    }

    private static void printCellSymbolWithState(Integer cellValue) {
        if (cellValue == GameBoard.DEAD_CELL_VALUE) {
            System.out.print(DEAD_CELL_SYMBOL);
        }
        if (cellValue == GameBoard.LIVE_CELL_VALUE) {
            System.out.print(LIVE_CELL_SYMBOL);
        }
    }
}
