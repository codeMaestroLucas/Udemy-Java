package l_chessProject.project.app;

import l_chessProject.project.models.entities.boardGame.ChessPiece;

public class UI {
    
    public static void printBoardGame(ChessPiece[][] piece) {

        for (int i = 0; i < piece.length ; i++) {

            System.out.print(STR."\033[1m\{8 - i} \033[m");

            for (int j = 0; j < piece[i].length ; j++) {
                printPiece(piece[i][j]);
            }

            System.out.println();
        }

        System.out.println("  \033[1ma b c d e f g h\033[m");
    }

    private static void printPiece(ChessPiece piece) {
        if (piece == null) {

            System.out.print("\033[1m-\033[m");

        } else {
            System.out.print(piece);
        }

        System.out.print(" ");


    }


}
