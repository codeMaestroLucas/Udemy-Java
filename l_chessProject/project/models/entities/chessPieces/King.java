package l_chessProject.project.models.entities.chessPieces;

import l_chessProject.project.models.entities.boardGame.Board;
import l_chessProject.project.models.entities.chess.ChessPiece;
import l_chessProject.project.models.enums.Color;

public class King extends ChessPiece {
    
    public King(Board board, Color color) {
        super(board, color);
    }


    @Override
    public String toString() {
        return "K";
    }



    @Override
    public Boolean[][] possibleMoves() {
        Boolean[][] matrix = new Boolean[getBoard().getRows()]
                                        [getBoard().getCols()];
        return matrix;
    }
    

}
