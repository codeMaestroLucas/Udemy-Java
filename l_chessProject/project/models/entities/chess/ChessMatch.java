package l_chessProject.project.models.entities.chess;


import java.lang.IllegalStateException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import l_chessProject.project.models.entities.boardGame.Board;
import l_chessProject.project.models.entities.boardGame.Piece;
import l_chessProject.project.models.entities.boardGame.Position;
import l_chessProject.project.models.entities.chessPieces.*;
import l_chessProject.project.models.enums.Color;

public class ChessMatch {
    
    private Board board;
    private int turn = 1;
    private Color currentPlayer = Color.WHITE;
    private boolean check;
    private boolean checkMate;
    private ChessPiece enPassantVulnerable;
    private ChessPiece promoted;

    private List<Piece> capturedPieces = new ArrayList<Piece>();
    private List<Piece> piecesOnBoard = new ArrayList<Piece>();


    public ChessMatch() {
        this.board = new Board(8, 8);
        initialSetUp();
    }

    public ChessPiece[][] getPieces() {
        int rows = this.board.getRows();
        int cols = this.board.getCols();

        ChessPiece[][] matrix = new ChessPiece [rows][cols];

        for (int i = 0; i < rows; i++) {
            for(int j = 0 ; j < cols; j++) {
                matrix[i][j] = (ChessPiece) board.piece(i, j);
            }
        }

        return matrix;

    }

    public int getTurn() {
        return turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean getCheck() {
        return this.check;
    }

    public boolean getCheckMate() {
        return this.checkMate;
    }

    public ChessPiece getEnPassantVulnerable() {
        return this.enPassantVulnerable;
    }

    public ChessPiece getPromoted() {
        return this.promoted;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece,
                         new ChessPosition(column, row).toPosition());
        piecesOnBoard.add(piece);
    }


    private void initialSetUp() {
        placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        placeNewPiece('b', 1, new Knight(board, Color.WHITE));
        placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('d', 1, new Queen(board, Color.WHITE));
        placeNewPiece('e', 1, new King(board, Color.WHITE, this));

        /*
         * The `this` in King's instanciation says that the Object of instance
         * will be used in the object KING constructor.
         */

        placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('g', 1, new Knight(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));
        placeNewPiece('a', 2, new Pawn(board, Color.WHITE, this));
        placeNewPiece('b', 2, new Pawn(board, Color.WHITE, this));
        placeNewPiece('c', 2, new Pawn(board, Color.WHITE, this));
        placeNewPiece('d', 2, new Pawn(board, Color.WHITE, this));
        placeNewPiece('e', 2, new Pawn(board, Color.WHITE, this));
        placeNewPiece('f', 2, new Pawn(board, Color.WHITE, this));
        placeNewPiece('g', 2, new Pawn(board, Color.WHITE, this));
        placeNewPiece('h', 2, new Pawn(board, Color.WHITE, this));

        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('b', 8, new Knight(board, Color.BLACK));
        placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('d', 8, new Queen(board, Color.BLACK));
        placeNewPiece('e', 8, new King(board, Color.BLACK, this));
        placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('g', 8, new Knight(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));
        placeNewPiece('a', 7, new Pawn(board, Color.BLACK, this));
        placeNewPiece('b', 7, new Pawn(board, Color.WHITE, this));
        placeNewPiece('c', 7, new Pawn(board, Color.BLACK, this));
        placeNewPiece('d', 7, new Pawn(board, Color.BLACK, this));
        placeNewPiece('e', 7, new Pawn(board, Color.BLACK, this));
        placeNewPiece('f', 7, new Pawn(board, Color.BLACK, this));
        placeNewPiece('g', 7, new Pawn(board, Color.BLACK, this));
        placeNewPiece('h', 7, new Pawn(board, Color.BLACK, this));

    }


    private void validateTargetPosition(Position initialPos, Position targetPos) {
        if (!board.piece(initialPos).possibleMove(targetPos)) {
            throw new ChessException("Inlvalid move. This piece cannot move to this position.");
        }
    }

    private void validateSourcePosition(Position pos) {
        if(!board.thereIsAPiece(pos)) {
            throw new ChessException("There's no Piece in this position.");
        }

        if (this.currentPlayer != ((ChessPiece) board.piece(pos)).getColor()) {
            throw new ChessException("The chosen piece is not yours.");
        }

        if (!board.piece(pos).isThereAnyPossibleMove()) {
            throw new ChessException("There's no possible moves for the chosen piece.");
        }
    }

    private void undoMove(Position initialPos, Position targetPos, Piece capturedPiece) {
        ChessPiece p = (ChessPiece) board.removePiece(targetPos);
        p.decreaseMoveCount();
        board.placePiece(p, initialPos);

        if (capturedPiece != null) {
            board.placePiece(capturedPiece, targetPos);
            capturedPieces.remove(capturedPiece);
            piecesOnBoard.add(capturedPiece);
        }

        
        if (p instanceof King) {
            // King side rook
            if (targetPos.getColumn() == initialPos.getColumn() + 2) {
                Position initialR = new Position(initialPos.getRow(),
                                                    initialPos.getColumn() + 3);
                Position finalR = new Position(initialPos.getRow(),
                                                initialPos.getColumn() + 1);
                ChessPiece rook = (ChessPiece) board.removePiece(finalR);
                board.placePiece(rook, initialR);
                rook.increaseMoveCount();
            }

            // Queen side rook
            if (targetPos.getColumn() == initialPos.getColumn() - 2) {
                Position initialR = new Position(initialPos.getRow(),
                                                    initialPos.getColumn() - 4);
                Position finalR = new Position(initialPos.getRow(),
                                                initialPos.getColumn() - 1);
                ChessPiece rook = (ChessPiece) board.removePiece(finalR);
                board.placePiece(rook, initialR);
                rook.increaseMoveCount();
            }
        }

        if (p instanceof Pawn) {
            if (initialPos.getColumn() != targetPos.getColumn() &&
                capturedPiece == this.enPassantVulnerable) {
                    ChessPiece pawn = (ChessPiece) board.removePiece(targetPos);
                    Position pawnPos;

                    if (p.getColor() == Color.WHITE) {
                        pawnPos = new Position(3, targetPos.getColumn());
                    } else {
                        pawnPos = new Position(4, targetPos.getColumn());
                    }

                    board.placePiece(pawn, pawnPos);
                }
        }


    }

    private Piece makeMove(Position initialPos, Position targetPos) {
       ChessPiece p = (ChessPiece) board.removePiece(initialPos);
       p.increaseMoveCount();
       Piece capturedPiece = board.removePiece(targetPos);
       board.placePiece(p, targetPos);

        if (capturedPiece != null) {
            this.piecesOnBoard.remove(capturedPiece);
            this.capturedPieces.add((ChessPiece) capturedPiece);
        }

        if (p instanceof King) {
            // King side rook
            if (targetPos.getColumn() == initialPos.getColumn() + 2) {
                Position initialR = new Position(initialPos.getRow(),
                                                    initialPos.getColumn() + 3);
                Position finalR = new Position(initialPos.getRow(),
                                                initialPos.getColumn() + 1);
                ChessPiece rook = (ChessPiece) board.removePiece(initialR);
                board.placePiece(rook, finalR);
                rook.increaseMoveCount();
            }

            // Queen side rook
            if (targetPos.getColumn() == initialPos.getColumn() - 2) {
                Position initialR = new Position(initialPos.getRow(),
                                                    initialPos.getColumn() - 4);
                Position finalR = new Position(initialPos.getRow(),
                                                initialPos.getColumn() - 1);
                ChessPiece rook = (ChessPiece) board.removePiece(initialR);
                board.placePiece(rook, finalR);
                rook.increaseMoveCount();
            }
        }


        if (p instanceof Pawn) {
            if (initialPos.getColumn() != targetPos.getColumn() &&
                capturedPiece == null) {
                    Position pawnPos;

                    if (p.getColor() == Color.WHITE) {
                        pawnPos = new Position(targetPos.getRow() + 1,
                                               targetPos.getColumn());
                    } else {
                        pawnPos = new Position(targetPos.getRow() - 1,
                                               targetPos.getColumn());
                    }

                    capturedPiece = board.removePiece(pawnPos);
                    capturedPieces.add(capturedPiece);
                    piecesOnBoard.remove(capturedPiece);

                }
        }

       return capturedPiece; // If doesnt have any piece it returns NULL
    }

    public boolean[][] showPossibleMoves(ChessPosition pos) {
        Position p = pos.toPosition();
        validateSourcePosition(p);
        return board.piece(p).possibleMoves();
    }

    public ChessPiece replacePromotedPiece(String type) {
        if (this.promoted == null ) {
            throw new IllegalArgumentException("There's no piece to be promoted.");
        }

        if (!type.equals("B") && !type.equals("N") &&
            !type.equals("R") && !type.equals("Q")) {
                return this.promoted;
            }

        Position pos = this.promoted.getChessPosition().toPosition();
        Piece p = board.removePiece(pos);
        piecesOnBoard.remove(p);

        ChessPiece newPiece = makeNewPiece(type, promoted.getColor());
        board.placePiece(newPiece, pos);
        piecesOnBoard.add(newPiece);

        return newPiece;

    }

    private ChessPiece makeNewPiece(String type, Color color) {
        if (type.equals("B")) return new Bishop(board, color);
        if (type.equals("N")) return new Knight(board, color);
        if (type.equals("R")) return new Rook(board, color);
        return new Queen(board, color);
    }


    public ChessPiece performChessMove(ChessPosition initialPos, ChessPosition targetPos) {
        Position initial = initialPos.toPosition();
        Position target = targetPos.toPosition();
        validateSourcePosition(initial);
        validateTargetPosition(initial, target);
        ChessPiece capturedPiece = (ChessPiece) makeMove(initial, target);

        if (testCheck(currentPlayer)) {
            undoMove(initial, target, capturedPiece);
            throw new ChessException("U can't put yourself in a check position.");
        }

        ChessPiece movedPiece = (ChessPiece) board.piece(target);

        // Special Move Promoted
        this.promoted = null;
        if (movedPiece instanceof Pawn) {
            if ((movedPiece.getColor() == Color.WHITE && target.getRow() == 0) ||
                (movedPiece.getColor() == Color.BLACK && target.getRow() == 7)) {
                
                    this.promoted = (ChessPiece) board.piece(target);
                    promoted = replacePromotedPiece("Q");

            }

        }

        this.check = (testCheck(opponent(this.currentPlayer))) ? true : false;

        if (testCheckMate(currentPlayer)) {
            this.checkMate = true;

        } else {
            nextTurn();
        }

        // Special move EnPassant
        if (movedPiece instanceof Pawn &&
            (target.getRow() == initial.getRow() - 2 ||
            target.getRow() == initial.getRow() + 2)) {
                this.enPassantVulnerable = movedPiece;
             } else {
                this.enPassantVulnerable = null;
             }


        return (ChessPiece) capturedPiece;
    }

    private void nextTurn() {
        this.turn ++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }


    private Color opponent(Color color) {
        return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private ChessPiece king(Color color) {
        List<Piece> listOfPieces = piecesOnBoard.stream()
            .filter(x -> ((ChessPiece) x).getColor() == color)
            .collect(Collectors.toList());
        
        for (Piece p : listOfPieces) {
            if (p instanceof King) {
                return (ChessPiece) p;
            }
        }

        throw new IllegalStateException("There's no piece on the board of " +
            STR."the king \{color}.");

    }

    private boolean testCheck(Color color) {
        Position kingsPosition = this.king(color).getChessPosition().toPosition();
        List<Piece> opponentPieces = piecesOnBoard.stream()
            .filter(x -> ((ChessPiece) x).getColor() == this.opponent(color))
            .collect(Collectors.toList());

        for (Piece p : opponentPieces) {
            boolean[][] matrix = p.possibleMoves();

            if (matrix[kingsPosition.getRow()][kingsPosition.getColumn()]) {
                return true;
            }

        }

        return false;
    }

    private boolean testCheckMate(Color color) {
        if (!testCheck(color)) {return false;}

        List<Piece> listOfPieces = piecesOnBoard.stream()
            .filter(x -> ((ChessPiece) x).getColor() == color)
            .collect(Collectors.toList());

        for (Piece p : listOfPieces) {
            boolean[][] possibleMoves = p.possibleMoves();
            
            for (int i = 0; i < possibleMoves.length; i++) {
                for (int j = 0 ; j < possibleMoves[0].length ; j++) {
                    if (possibleMoves[i][j]) {
                        Position initialPos = ((ChessPiece) p).getChessPosition().toPosition();
                        Position targetPos = new Position(i, j);
                        Piece capturedPiece = makeMove(initialPos, targetPos);
                        boolean testCheck = testCheck(color);
                        undoMove(initialPos, targetPos, capturedPiece);

                        if (!testCheck) {
                            return false;
                        }

                    }
                }
            }
        }

        return true;

    }

}
