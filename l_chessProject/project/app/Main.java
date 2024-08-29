package l_chessProject.project.app;

import java.util.Scanner;
import java.util.Locale;

import l_chessProject.project.models.entities.boardGame.ChessMatch;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
    
        ChessMatch m = new ChessMatch();
        UI.printBoardGame(m.getPieces());
        
        sc.close();
    }
}

