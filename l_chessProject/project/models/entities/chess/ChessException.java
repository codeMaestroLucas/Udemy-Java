package l_chessProject.project.models.entities.chess;

import l_chessProject.project.models.entities.boardGame.BoardGameExpection;

public class ChessException extends BoardGameExpection {

    public ChessException(String msg) {
        super(msg);
    }
    
}
