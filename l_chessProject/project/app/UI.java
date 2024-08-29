package l_chessProject.project.app;

import static java.lang.StringTemplate.*;

import java.util.InputMismatchException;

import l_chessProject.project.models.entities.chess.ChessPiece;
import l_chessProject.project.models.entities.chess.ChessPosition;
import l_chessProject.project.models.enums.Color;
import java.util.Scanner;

public class UI {
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  // Clrears the terminal screen
        System.out.flush();                 // Garantees that the screen has been cleared
    }

    
    public static void printBoardGame(ChessPiece[][] piece) {
        clearScreen();

        System.out.println("\n\n+" + "=".repeat(28) + "+");
        System.out.printf("|%29s\n", "|");

        for (int i = 0; i < piece.length ; i++) {
            System.out.printf("|%5s  ", 8 - i);

            for (int j = 0; j < piece[i].length ; j++) {
                printPiece(piece[i][j]);
            }

            System.out.print("     |\n");
        }

        System.out.println("|" + " ".repeat(7) + "a b c d e f g h      |");
        System.out.printf("|%29s\n", "|");


        System.out.println("+" + "=".repeat(28) + "+\n\n");
    }


    private static void printPiece(ChessPiece piece) {
        if (piece == null) {
            System.out.print("-");

        } else {

            if (piece.getColor() == Color.BLACK) {
                System.out.print(STR."\033[1;33m\{piece}\033[m");

            } else {
                System.out.print(STR."\033[1m\{piece}\033[m");
            }

        }

        System.out.print(" ");


    }


    public static ChessPosition readChessPosition(Scanner sc) {

        try {
            String s = sc.nextLine().trim().toLowerCase();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));

            return new ChessPosition (column, row);

        } catch (Exception e) {
            throw new InputMismatchException(
                "Error reading Chess Position. Valid values are a1 to h8."
                );
        }


    }


    public static void raiseException(Scanner sc, Exception e) {
        System.out.println("\033[31m" + e.getMessage() + "\033[m" );
        System.out.print("Press ENTER to continue... ");
        sc.nextLine();
    }

}
