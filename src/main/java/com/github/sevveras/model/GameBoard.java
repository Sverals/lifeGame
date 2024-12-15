package com.github.sevveras.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * a class that represents the games board
 * @author Matthew Shirley
 * @version 1.0
 */
public class GameBoard {
    public static final int DEAD_CELL_VALUE = 0;
    public static final int LIVE_CELL_VALUE = 1;
    private final int width;
    private final int height;
    private ArrayList<ArrayList<Integer>> board;

    public GameBoard(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new ArrayList<>();
        this.board = this.generateDeadBoard(this.width, this.height);
    }

    /**
     * Generates a board where all cells are in a dead state
     * @param width the width of the board
     * @param height the height of the board
     * @return an arraylist that represents the board in a dead state
     */
    public ArrayList<ArrayList<Integer>> generateDeadBoard(int width, int height) {
        ArrayList<ArrayList<Integer>> deadBoard = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                row.add(0);
            }
            deadBoard.add(row);
        }
        return deadBoard;
    }

    public ArrayList<ArrayList<Integer>> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<Integer>> board) {
        this.board = board;
    }

    /**
     * randomizes the state of this board between live and dead cells
     */
    public void randomizeState() {
        this.board = this.generateDeadBoard(this.width, this.height);
        Random randomizer = new Random();
        for (ArrayList<Integer> currentList : this.board) {
            for (int i = 0; i < currentList.size(); i++) {
                int randomValue = randomizer.nextInt(2);
                if (randomValue == 0) {
                    currentList.set(i, DEAD_CELL_VALUE);
                } else {
                    currentList.set(i, LIVE_CELL_VALUE);
                }
            }
        }
    }
}
