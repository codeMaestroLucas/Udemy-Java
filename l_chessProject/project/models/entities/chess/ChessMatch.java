package l_chessProject.project.models.entities.chess;


import l_chessProject.project.models.entities.boardGame.Board;
import l_chessProject.project.models.entities.boardGame.Position;
import l_chessProject.project.models.entities.boardGame.Piece;
import l_chessProject.project.models.entities.chessPieces.*;
import l_chessProject.project.models.enums.Color;

public class ChessMatch {
    
    private Board board;

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

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece,
                         new ChessPosition(column, row).toPosition());
    }


    private void initialSetUp() {
        placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 4, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new King(board, Color.BLACK));

    }


    private void validateTargetPosition(Position initialPos, Position targetPos) {
        if (!board.piece(initialPos).possibleMove(targetPos)) {
            throw new ChessException("Invalid move. This piece cannot move to this position.");
        }
    }

    private void validateSourcePosition(Position pos) {
        if(!board.thereIsAPiece(pos)) {
            throw new ChessException("There's no Piece in this position.");
        }

        if (!board.piece(pos).isThereAnyPossibleMove()) {
            throw new ChessException("There's no possible moves for the chosen piece.");
        }
    }

    private Piece makeMove(Position initialPos, Position targetPos) {
       Piece p = board.removePiece(initialPos);
       Piece capturedPiece = board.removePiece(targetPos);

       board.placePiece(p, targetPos);
       return capturedPiece; // If doesnt have any piece it returns NULL
    }


    public ChessPiece performChessMove(ChessPosition initialPos, ChessPosition targetPos) {
        Position initial = initialPos.toPosition();
        Position target = targetPos.toPosition();
        validateSourcePosition(initial);
        validateTargetPosition(initial, target);
        Piece capturedPiece = makeMove(initial, target);
        return (ChessPiece) capturedPiece;
    }


}
