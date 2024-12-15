package com.github.sevveras.Logic;

import com.github.sevveras.model.GameBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

class GameActionsTest {
    private GameBoard gameBoard;
    @BeforeEach
    public void setUp() {
        GameBoard board = new GameBoard(3, 3);
        board.randomizeState();
        gameBoard = board;
    }

    @Test
    void testDeadCellsWithNoLiveNeighborsStayDead() {

        ArrayList<ArrayList<Integer>> initialState = new ArrayList<>(List.of(
                new ArrayList<>(List.of(0, 0, 0)),
                new ArrayList<>(List.of(0, 0, 0)),
                new ArrayList<>(List.of(0, 0, 0))
        ));

        gameBoard.setBoard(initialState);

        ArrayList<ArrayList<Integer>> expectedNextState = new ArrayList<>(List.of(
                new ArrayList<>(List.of(0, 0, 0)),
                new ArrayList<>(List.of(0, 0, 0)),
                new ArrayList<>(List.of(0, 0, 0))
        ));

        ArrayList<ArrayList<Integer>> nextState = GameActions.generateNextBoardState(gameBoard);

        Assertions.assertEquals(expectedNextState, nextState);
    }

    @Test
    void testDeadCellsWith3NeighborsComeAlive() {
        ArrayList<ArrayList<Integer>> initialState = new ArrayList<>(List.of(
                new ArrayList<>(List.of(0, 0, 1)),
                new ArrayList<>(List.of(0, 1, 1)),
                new ArrayList<>(List.of(0, 0, 0))
        ));

        gameBoard.setBoard(initialState);

        ArrayList<ArrayList<Integer>> expectedNextState = new ArrayList<>(List.of(
                new ArrayList<>(List.of(0, 1, 1)),
                new ArrayList<>(List.of(0, 1, 1)),
                new ArrayList<>(List.of(0, 0, 0))
        ));

        ArrayList<ArrayList<Integer>> nextState = GameActions.generateNextBoardState(gameBoard);

        Assertions.assertEquals(expectedNextState, nextState);
    }
}