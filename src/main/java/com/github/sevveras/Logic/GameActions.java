package com.github.sevveras.Logic;

import com.github.sevveras.model.GameBoard;

import java.util.ArrayList;

public class GameActions {
    public static ArrayList<ArrayList<Integer>> generateNextBoardState(GameBoard board) {
        var currentState = board.getBoard();

        GameBoard freshBoard = new GameBoard(board.getWidth(), board.getHeight());
        freshBoard.generateDeadBoard(); //creates a fresh board to update
        var nextBoardState = freshBoard.getBoard();
        for (int height = 0; height < currentState.size(); height++) {
            for (int width = 0; width < currentState.get(height).size(); width++) {
                int totalNeighbors = calculateTotalAliveNeighbors(currentState, width, height);
                setNewStateBasedOnNeighbors(nextBoardState, currentState ,width, height, totalNeighbors);
            }
        }
        return nextBoardState;
    }

    private static void setNewStateBasedOnNeighbors(ArrayList<ArrayList<Integer>> nextBoardState, ArrayList<ArrayList<Integer>> previousBoard, int width, int height, int totalNeighbors) {
        if (totalNeighbors == 0 || totalNeighbors == 1) {
            nextBoardState.get(height).set(width, 0); //kill if underpopulated
        }
        if (totalNeighbors > 3) { //overpopulation
            nextBoardState.get(height).set(width, 0);
        }
        if (totalNeighbors == 3) {
            nextBoardState.get(height).set(width, 1);
        }
        if (totalNeighbors == 2) {
            int currentValue = getStateAtCoordinate(previousBoard, width, height);
            if (currentValue == 1) {
                nextBoardState.get(height).set(width, 1);
            }

        }
    }

    private static int calculateTotalAliveNeighbors(ArrayList<ArrayList<Integer>> board, int x, int y) {
        int totalAliveNeighbors = 0;
        totalAliveNeighbors += calculateLine(board, x, y, "up");
        totalAliveNeighbors += calculateLine(board, x, y, "down");
        totalAliveNeighbors += calculateLine(board, x, y, "left");
        totalAliveNeighbors += calculateLine(board, x, y, "right");
        return totalAliveNeighbors;
    }

    private static int calculateLine(ArrayList<ArrayList<Integer>> board, int x, int y, String direction) {
        int totalAliveNeighbors = 0;
        switch (direction) {
            case "up" -> {
                totalAliveNeighbors += calculateRow(board, x - 1, y - 1);
                return totalAliveNeighbors;
            }
            case "down" -> {
                totalAliveNeighbors += calculateRow(board, x - 1, y + 1);
                return totalAliveNeighbors;
            }
            case "left" -> {
                if (isValidLocation(board, x - 1, y)) {
                    totalAliveNeighbors += getStateAtCoordinate(board, x - 1, y);
                }

                return totalAliveNeighbors;
            }
            case "right" -> {
                if (isValidLocation(board, x + 1, y)) {
                    totalAliveNeighbors += getStateAtCoordinate(board, x + 1, y);
                }

                return totalAliveNeighbors;
            }
        }


        return totalAliveNeighbors;
    }

    private static int calculateRow(ArrayList<ArrayList<Integer>> board, int x, int y) {
        int totalAliveNeighbors = 0;
        for (int i = 0; i < 3; i++) {
            if (isValidLocation(board, x + i, y)) {
                totalAliveNeighbors += getStateAtCoordinate(board, x + i, y);
            }
        }
        return totalAliveNeighbors;
    }

    private static boolean isValidLocation(ArrayList<ArrayList<Integer>> board, int x, int y) {
        if (y < 0) {
            return false;
        }
        if (x < 0) {
            return false;
        }
        if (y >= board.size()) {
            return false;
        }
        if (x >= board.get(y).size()) {
            return false;
        }

        return true;
    }


    private static int getStateAtCoordinate(ArrayList<ArrayList<Integer>> board, int x, int y) {
        return board.get(y).get(x);
    }
}
