package l_chessProject.project.models.entities.chessPieces;

import l_chessProject.project.models.entities.boardGame.Board;
import l_chessProject.project.models.entities.boardGame.Position;
import l_chessProject.project.models.entities.chess.ChessPiece;
import l_chessProject.project.models.enums.Color;

public class Knight extends ChessPiece {

    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "N";
    }

    private boolean canMove(Position pos) {
        ChessPiece p = (ChessPiece) getBoard().piece(pos);
        return p == null || p.getColor() != getColor();
    }



    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()]
                                        [getBoard().getCols()];
        
        movesUpLeft(matrix);
        movesUpRight(matrix);
        movesDownLeft(matrix);
        movesDownRight(matrix);

        return matrix;
    }

    private boolean[][] movesUpLeft(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow() - 1,
                    position.getColumn() - 2);

        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() - 2,
                    position.getColumn() - 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }

    private boolean[][] movesUpRight(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow() - 1,
                    position.getColumn() + 2);

        if (getBoard().positionExists(p) && canMove(p )) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() - 2,
                    position.getColumn() + 1);

        if (getBoard().positionExists(p) && canMove(p )) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }
    
    private boolean[][] movesDownLeft(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow() + 1,
                    position.getColumn() - 2);
        
        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() + 2,
                    position.getColumn() - 1);
        
        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }
    
    private boolean[][] movesDownRight(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow() + 1,
                    position.getColumn() + 2);
        
        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() + 2,
                    position.getColumn() + 1);
        
        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }
    
}
