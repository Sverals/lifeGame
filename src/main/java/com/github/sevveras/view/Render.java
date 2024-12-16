package com.github.sevveras.view;

import com.github.sevveras.model.GameBoard;

import java.util.ArrayList;

public class Render {
    public static final char LIVE_CELL_SYMBOL = '#';
    public static final char DEAD_CELL_SYMBOL = ' ';
    public static final char BOARD_BORDER_SYMBOL = '|';


    public static void renderBoard(GameBoard board) {
        var boardState = board.getBoard();
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Integer> row : boardState) {
            sb.append(printRow(row));
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static String printRow(ArrayList<Integer> row) {
        StringBuilder sb = new StringBuilder();
        sb.append(BOARD_BORDER_SYMBOL);
        for (Integer currentValue : row) {
            sb.append(printCellSymbolWithState(currentValue));
        }
        sb.append(BOARD_BORDER_SYMBOL);
        return sb.toString();
    }

    private static char printCellSymbolWithState(Integer cellValue) {
        if (cellValue == GameBoard.DEAD_CELL_VALUE) {
            return DEAD_CELL_SYMBOL;
        }
        if (cellValue == GameBoard.LIVE_CELL_VALUE) {
            return LIVE_CELL_SYMBOL;
        }
        return  '-';
    }
}
