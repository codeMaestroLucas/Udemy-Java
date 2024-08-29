package l_chessProject.project.models.entities.chessPieces;

import l_chessProject.project.models.entities.boardGame.Board;
import l_chessProject.project.models.entities.boardGame.Position;
import l_chessProject.project.models.entities.chess.ChessPiece;
import l_chessProject.project.models.enums.Color;

public class Rook  extends ChessPiece{
    
    public Rook(Board board, Color color) {
        super(board, color);
    }


    @Override
    public String toString() {
        return "R";
    }


    @Override
    public Boolean[][] possibleMoves() {
        Boolean[][] matrix = new Boolean[getBoard().getRows()]
                                        [getBoard().getCols()];

        movesUp(matrix);
        movesDown(matrix);
        movesLeft(matrix);
        movesRight(matrix);

        return matrix;
    }

    private Boolean[][] movesUp(Boolean[][] matrix) {
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

    private Boolean[][] movesDown(Boolean[][] matrix) {
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
    
    private Boolean[][] movesLeft(Boolean[][] matrix) {
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
    
    private Boolean[][] movesRight(Boolean[][] matrix) {
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

}
