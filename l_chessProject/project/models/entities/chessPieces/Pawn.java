package l_chessProject.project.models.entities.chessPieces;

import l_chessProject.project.models.entities.boardGame.Board;
import l_chessProject.project.models.entities.boardGame.Position;
import l_chessProject.project.models.entities.chess.ChessMatch;
import l_chessProject.project.models.entities.chess.ChessPiece;
import l_chessProject.project.models.enums.Color;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "P";
    }
    
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()]
                                        [getBoard().getCols()];
        Position p = new Position(0, 0);

        if (this.getColor() == Color.WHITE) {
            whitePawnMoves(matrix, p);
        } else {
            blackPawnMoves(matrix, p);
        }

        return matrix;

    }

    private boolean[][] whitePawnMoves(boolean[][] matrix, Position p) {
        p.setValues(this.position.getRow() - 1, position.getColumn());
        if (this.getBoard().positionExists(p) &&
            !this.getBoard().thereIsAPiece(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        Position p2 = new Position(this.position.getRow() - 1, position.getColumn());
        p.setValues(this.position.getRow() - 2, position.getColumn());
        if (this.getBoard().positionExists(p) &&
            !this.getBoard().thereIsAPiece(p) &&
            this.getBoard().positionExists(p2) &&
            !this.getBoard().thereIsAPiece(p2) &&
            this.getMoveCount() == 0)
        {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // Diagonal left
        p.setValues(this.position.getRow() - 1, position.getColumn() - 1);
        if (this.getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // Diagonal right
        p.setValues(this.position.getRow() - 1, position.getColumn() + 1);
        if (this.getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }


        // Special move EnPassant
        if (position.getRow() == 3) { // ROW 5 in the board
            Position left = new Position(position.getRow(), position.getColumn() - 1);

            if (getBoard().positionExists(left) &&
                isThereOpponentPiece(left) &&
                getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) { // Check`s if that piece is EnPassant vulnerable
                    matrix[left.getRow() - 1][left.getColumn()] = true;
                }

            Position right = new Position(position.getRow(), position.getColumn() + 1);

            if (getBoard().positionExists(right) &&
                isThereOpponentPiece(right) &&
                getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    matrix[right.getRow() - 1][right.getColumn()] = true;
                }
        }

        return matrix;
    }

    private boolean[][] blackPawnMoves(boolean[][] matrix, Position p) {
        p.setValues(this.position.getRow() + 1, position.getColumn());
        if (this.getBoard().positionExists(p) && !this.getBoard().thereIsAPiece(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        Position p2 = new Position(this.position.getRow() + 1, position.getColumn());
        p.setValues(this.position.getRow() + 2, position.getColumn());
        if (this.getBoard().positionExists(p) && !this.getBoard().thereIsAPiece(p) &&
            this.getBoard().positionExists(p2) && !this.getBoard().thereIsAPiece(p2)
            && this.getMoveCount() == 0) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // Diagonal left
        p.setValues(this.position.getRow() + 1, position.getColumn() - 1);
        if (this.getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // Diagonal right
        p.setValues(this.position.getRow() + 1, position.getColumn() + 1);
        if (this.getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }


        // Special move EnPassant
        if (position.getRow() == 4) { // ROW 4 in the board
            Position left = new Position(position.getRow(), position.getColumn() - 1);

            if (getBoard().positionExists(left) &&
                isThereOpponentPiece(left) &&
                getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    matrix[left.getRow() + 1][left.getColumn()] = true;
                }

            Position right = new Position(position.getRow(), position.getColumn() + 1);

            if (getBoard().positionExists(right) &&
                isThereOpponentPiece(right) &&
                getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    matrix[right.getRow() + 1][right.getColumn()] = true;
                }
        }
        
        return matrix;
    }

}
