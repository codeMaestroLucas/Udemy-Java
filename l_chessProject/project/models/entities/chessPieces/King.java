package l_chessProject.project.models.entities.chessPieces;

import l_chessProject.project.models.entities.boardGame.Board;
import l_chessProject.project.models.entities.boardGame.Position;
import l_chessProject.project.models.entities.chess.ChessMatch;
import l_chessProject.project.models.entities.chess.ChessPiece;
import l_chessProject.project.models.enums.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position pos) {
        ChessPiece p = (ChessPiece) getBoard().piece(pos);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position pos) {
        ChessPiece p = (ChessPiece) getBoard().piece(pos);
        return p != null && p instanceof Rook &&
               p.getColor() == getColor() && p.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getCols()];

        movesUp(matrix);
        movesDown(matrix);
        movesLeft(matrix);
        movesRight(matrix);
        movesLeftDiagUp(matrix);
        movesRightDiagUp(matrix);
        movesLeftDiagDown(matrix);
        movesRightDiagDown(matrix);
        castling(matrix);

        return matrix;
    }

    private boolean[][] movesUp(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow() - 1,
                position.getColumn());

        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }

    private boolean[][] movesDown(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow() + 1,
                position.getColumn());

        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }

    private boolean[][] movesLeft(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow(),
                position.getColumn() - 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }

    private boolean[][] movesRight(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow(),
                position.getColumn() + 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }

    private boolean[][] movesLeftDiagUp(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow() - 1,
                position.getColumn() - 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }

    private boolean[][] movesRightDiagUp(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow() - 1,
                position.getColumn() + 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }

    private boolean[][] movesLeftDiagDown(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow() + 1,
                position.getColumn() - 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }

    private boolean[][] movesRightDiagDown(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow() + 1,
                position.getColumn() + 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }

    private boolean[][] castling(boolean[][] matrix) {
        if (this.getMoveCount() == 0 && !this.chessMatch.getCheck()) {
            // Small rook move - King side
            Position r1 = new Position(this.position.getRow(),
                    this.position.getColumn() + 3);

            if (testRookCastling(r1)) {
                Position p1 = new Position(this.position.getRow(),
                        this.position.getColumn() + 1);
                Position p2 = new Position(this.position.getRow(),
                        this.position.getColumn() + 2);

                if (this.getBoard().piece(p1) == null &&
                        this.getBoard().piece(p2) == null) {
                    matrix[position.getRow()][position.getColumn() + 2] = true;
                }
            }
            // Big rook move - Queen side
            Position r2 = new Position(this.position.getRow(),
                    this.position.getColumn() - 4);

            if (testRookCastling(r2)) {
                Position p1 = new Position(this.position.getRow(),
                        this.position.getColumn() - 1);
                Position p2 = new Position(this.position.getRow(),
                        this.position.getColumn() - 2);
                Position p3 = new Position(this.position.getRow(),
                        this.position.getColumn() - 3);

                if (this.getBoard().piece(p1) == null &&
                        this.getBoard().piece(p2) == null &&
                        this.getBoard().piece(p3) == null) {
                    matrix[position.getRow()][position.getColumn() - 2] = true;
                }

            }
        }

        return matrix;

    }
}
