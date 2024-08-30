package l_chessProject.project.app;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


import l_chessProject.project.models.entities.boardGame.BoardGameExpection;
import l_chessProject.project.models.entities.chess.ChessMatch;
import l_chessProject.project.models.entities.chess.ChessPiece;
import l_chessProject.project.models.entities.chess.ChessPosition;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
    
        ChessMatch m = new ChessMatch();
        List<ChessPiece> capturedPieces = new ArrayList<ChessPiece>();

        while (!m.getCheckMate()) {
            
            try {
                UI.printMatch(m, capturedPieces);

                System.out.print("Source: ");
                ChessPosition initialPos = UI.readChessPosition(sc);
                boolean[][] possibleMoves = m.showPossibleMoves(initialPos);
                UI.printBoardGame(m.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition targetPos = UI.readChessPosition(sc);
    
                ChessPiece capturedPiece = m.performChessMove(initialPos, targetPos);

                if (capturedPiece != null) {
                    capturedPieces.add(capturedPiece);
                }

                if (m.getPromoted() != null) {
                    System.out.print("Enter the piece for promotion " +
                                       "[B]/[N]/[R]/[Q]\n-> ");
                    
                    String type = sc.next().trim().toUpperCase();
                    while (!type.equals("B") && !type.equals("N") &&
                    !type.equals("R") && !type.equals("Q")) {
                        System.out.print("\033[31mInvalid type.\033[m");
                        System.out.print("Enter the piece for promotion " +
                            "[B]/[N]/[R]/[Q]\n-> ");
                        type = sc.nextLine().trim().toUpperCase();
                    }
                    
                    m.replacePromotedPiece(type);
                }

                    
            } catch (BoardGameExpection e) {
                UI.raiseException(sc, e);
            } catch (InputMismatchException e) {
                UI.raiseException(sc, e);
            }

        }
        
        // sc.close();
    }
}

