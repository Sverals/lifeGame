package com.github.sevveras;

import com.github.sevveras.Logic.GameLoop;
import com.github.sevveras.model.GameBoard;
import com.github.sevveras.view.Render;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter width:");
        int width = scan.nextInt();
        System.out.println("Enter height:");
        int height = scan.nextInt();
        GameLoop gameLoop = new GameLoop(width, height);
        gameLoop.runGame();
    }
}