package l_chessProject.project.app;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import l_chessProject.project.models.entities.chess.ChessMatch;
import l_chessProject.project.models.entities.chess.ChessPiece;
import l_chessProject.project.models.entities.chess.ChessPosition;
import l_chessProject.project.models.enums.Color;

public class UI {

    private static String delimiter = "\033[1;35m+\033[m" + "=".repeat(28) + "\033[1;35m+\033[m";
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  // Clrears the terminal screen
        System.out.flush();                 // Garantees that the screen has been cleared
    }


    public static void printMatch(ChessMatch m, List<ChessPiece> capturedPieces) {

        printBoardGame(m.getPieces());
        printCapturedPieces(capturedPieces);
        System.out.println(STR."\n\{m.getTurn()}nd Turn");
        System.out.println();

        if (!m.getCheckMate()) {
            System.out.print("Waiting for player: ");
            if (m.getCurrentPlayer() == Color.WHITE) {
                System.out.println(STR."\033[1;7m\{m.getCurrentPlayer()}\033[m");
            } else {
                System.out.println(STR."\033[1;43m\{m.getCurrentPlayer()}\033[m");
            }
    
            if (m.getCheck()) {
                System.out.println("CHECK!");
            }

        } else {
            System.out.println("CHECKMATE!");
            System.out.println(STR."\033[1;32mWINNER: \{m.getCurrentPlayer()}\033[m");
        }
    }

    
    public static void printBoardGame(ChessPiece[][] piece) {
        clearScreen();

        System.out.println("\n");
        System.out.println(delimiter);
        System.out.printf("|%29s\n", "|");

        for (int i = 0; i < piece.length ; i++) {
            System.out.printf("|%6s  ", 8 - i);

            for (int j = 0; j < piece[i].length ; j++) {
                printPiece(piece[i][j], false);
            }

            System.out.print("    |\n");
        }

        System.out.println("|" + " ".repeat(8) + "a b c d e f g h     |");
        System.out.printf("|%29s\n", "|");


        System.out.println(delimiter);
        System.out.println("\n");
    }
    
    public static void printBoardGame(ChessPiece[][] piece,
                                      boolean[][] possibleMoves) {
        clearScreen();

        System.out.println("\n");
        System.out.println(delimiter);
        System.out.printf("|%29s\n", "|");

        for (int i = 0; i < piece.length ; i++) {
            System.out.printf("|%6s  ", 8 - i);

            for (int j = 0; j < piece[i].length ; j++) {
                printPiece(piece[i][j], possibleMoves[i][j]);
            }

            System.out.print("    |\n");
        }
        System.out.println("|" + " ".repeat(8) + "a b c d e f g h     |");
        System.out.printf("|%29s\n", "|");

        System.out.println(delimiter);
        System.out.println("\n");
    }


    private static void printPiece(ChessPiece piece, boolean backgroundColor) {
        if (backgroundColor) {
            System.out.print("\033[44m");
        }
        
        if (piece == null) {
            System.out.print("-\033[m");

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
    
            // Correct input if it's in the format "2a" instead of "a2"
            if (s.length() == 2 && Character.isDigit(s.charAt(0)) &&
                Character.isLetter(s.charAt(1))) {
                s = "" + s.charAt(1) + s.charAt(0);
            }
    
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
    
            if (column < 'a' || column > 'h' || row < 1 || row > 8) {
                throw new InputMismatchException("Error reading Chess Position."
                + "Valid values are a1 to h8.");
            }
    
            return new ChessPosition(column, row);
    
        } catch (Exception e) {
            throw new InputMismatchException("Error reading Chess Position."
            + "Valid values are a1 to h8.");
        }
    }
    

    public static void raiseException(Scanner sc, Exception e) {
        System.out.println("\033[31m" + e.getMessage() + "\033[m" );
        System.out.print("Press ENTER to continue... ");
        sc.nextLine();
    }


    private static void printCapturedPieces(List<ChessPiece> captured) {
        List<ChessPiece> white = captured.stream().filter(
                x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
        List<ChessPiece> black = captured.stream().filter(
                x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
        
        System.out.println(STR."""
                Captured pieces:
                \033[7m- WHITE: \{Arrays.toString(white.toArray())}\033[m
                \033[7;33m- BLACK: \{Arrays.toString(black.toArray())}\033[m
                """);
    }

}
