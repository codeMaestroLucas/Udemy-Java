package l_chessProject.project.models.entities.chess;

import l_chessProject.project.models.entities.boardGame.Board;
import l_chessProject.project.models.entities.boardGame.Piece;
import l_chessProject.project.models.entities.boardGame.Position;
import l_chessProject.project.models.enums.Color;

public abstract class ChessPiece extends Piece {
    
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }


    protected Boolean isThereOpponentPiece(Position pos) {
        ChessPiece p = (ChessPiece) getBoard().piece(pos);
        return  p != null && p.getColor() != this.color;
    }

}
