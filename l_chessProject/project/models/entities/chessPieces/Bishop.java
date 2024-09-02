package l_chessProject.project.models.entities.chessPieces;

import l_chessProject.project.models.entities.boardGame.Board;
import l_chessProject.project.models.entities.boardGame.Position;
import l_chessProject.project.models.entities.chess.ChessPiece;
import l_chessProject.project.models.enums.Color;


public class Bishop extends ChessPiece {
    
    public Bishop(Board board, Color color) {
        super(board, color);
    }


    @Override
    public String toString() {
        return "B";
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()]
                                        [getBoard().getCols()];
        
        movesDiagUpLeft(matrix);
        movesDiagDownRight(matrix);
        movesDiagDownLeft(matrix);
        movesDiagUpRight(matrix);

        return matrix;
    }

    private boolean[][] movesDiagUpLeft(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow() - 1,
                    position.getColumn() - 1);

        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) ) {
            matrix[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() -1);
        }

        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }

    private boolean[][] movesDiagDownRight(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow() + 1,
                    position.getColumn() + 1);

        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) ) {
            matrix[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() + 1);
        }

        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }
    
    private boolean[][] movesDiagDownLeft(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow() + 1,
                    position.getColumn() - 1);
        
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() - 1);
        }

        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }
    
    private boolean[][] movesDiagUpRight(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow() - 1,
                    position.getColumn() + 1);
        
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() + 1);
        }

        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }
    
}
