package com.tictactoe;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.print("Player " + player + " enter row and column (0, 1, 2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            System.out.println();

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid input! Row and column must be between 0 and 2.");
                continue;
            }

            if (board[row][col] == ' ') {
                board[row][col] = player; // place the element
                if (haveWon(board, player)) {
                    printBoard(board);
                    System.out.println("Player " + player + " has won!");
                    gameOver = true;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("The game is a draw!");
                    gameOver = true;
                } else {
                    player = (player == 'X') ? 'O' : 'X'; // switch player
                }
            } else {
                System.out.println("Invalid move. Cell already occupied! Try again.");
            }
        }
        scanner.close();
    }

    public static boolean haveWon(char[][] board, char player) {
        // Check rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print("| " + board[row][col] + " ");
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }
}
