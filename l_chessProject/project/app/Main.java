package l_chessProject.project.app;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import l_chessProject.project.models.entities.boardGame.BoardGameExpection;
import l_chessProject.project.models.entities.chess.ChessMatch;
import l_chessProject.project.models.entities.chess.ChessPiece;
import l_chessProject.project.models.entities.chess.ChessPosition;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
    
        ChessMatch m = new ChessMatch();

        while (true) {
            
            try {
                UI.printBoardGame(m.getPieces());

                System.out.print("Source: ");
                ChessPosition initialPos = UI.readChessPosition(sc);
    
                System.out.println();
                System.out.print("Target: ");
                ChessPosition targetPos = UI.readChessPosition(sc);
    
                ChessPiece capturedPiece = m.performChessMove(initialPos, targetPos);
                    
            } catch (BoardGameExpection e) {
                UI.raiseException(sc, e);
            } catch (InputMismatchException e) {
                UI.raiseException(sc, e);
            }

        }
        
        // sc.close();
    }
}

