package l_chessProject.project.models.entities.boardGame;


public class Piece {
    
    private Board board;
    protected Position position;


    public Piece(Board board) {
        this.board = board;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    protected Board getBoard() {
        return board;
    }



    public Piece[][] possibleMoves() {}

    public Boolean possibleMove(Position posToCheck) {}


    public Boolean isThereAnyPossibleMove() {}
}
