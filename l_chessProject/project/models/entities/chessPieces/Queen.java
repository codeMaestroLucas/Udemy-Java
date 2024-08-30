package l_chessProject.project.models.entities.chessPieces;

import l_chessProject.project.models.entities.boardGame.Board;
import l_chessProject.project.models.entities.boardGame.Position;
import l_chessProject.project.models.entities.chess.ChessPiece;
import l_chessProject.project.models.enums.Color;


public class Queen extends ChessPiece{
        
    public Queen(Board board, Color color) {
        super(board, color);
    }


    @Override
    public String toString() {
        return "Q";
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()]
                                        [getBoard().getCols()];
        
        rookMoves(matrix);
        bishopMoves(matrix);

        return matrix;
    }

    private boolean[][] rookMoves(boolean[][] matrix) {
        movesUp(matrix);
        movesDown(matrix);
        movesLeft(matrix);
        movesRight(matrix);

        return matrix;
    }

    
    private boolean[][] movesUp(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow() - 1,
                    position.getColumn());

        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) ) {
            matrix[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn());
        }

        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }

    private boolean[][] movesDown(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow() + 1,
                    position.getColumn());

        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) ) {
            matrix[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn());
        }

        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }
    
    private boolean[][] movesLeft(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow(),
                    position.getColumn() - 1);
        
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow(), p.getColumn() - 1);
        }

        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }
    
    private boolean[][] movesRight(boolean[][] matrix) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow(),
                    position.getColumn() + 1);
        
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow(), p.getColumn() + 1);
        }

        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }


    private boolean[][] bishopMoves(boolean[][] matrix) {
        movesUpLeft(matrix);
        movesDownRight(matrix);
        movesDownLeft(matrix);
        movesUpRight(matrix);

        return matrix;
    }
    

    private boolean[][] movesUpLeft(boolean[][] matrix) {
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

    private boolean[][] movesDownRight(boolean[][] matrix) {
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
    
    private boolean[][] movesDownLeft(boolean[][] matrix) {
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
    
    private boolean[][] movesUpRight(boolean[][] matrix) {
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
