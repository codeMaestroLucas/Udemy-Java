package l_chessProject.project.models.entities.boardGame;


public abstract class Piece {
    
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



    public abstract Boolean[][] possibleMoves();

    public Boolean possibleMove(Position posToCheck) {
        return possibleMoves()[posToCheck.getRow()][posToCheck.getColumn()];

    }


    public Boolean isThereAnyPossibleMove() {
        Boolean[][] matrix = possibleMoves();

        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[i].length ; j++) {
                if (matrix[i][j]) {
                    return true;
                }
            }
        }

        return false;


    }
}
