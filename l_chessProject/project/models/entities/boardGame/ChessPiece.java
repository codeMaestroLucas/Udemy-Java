package l_chessProject.project.models.entities.boardGame;

import l_chessProject.project.models.enums.Color;

public class ChessPiece extends Piece {
    
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

}
