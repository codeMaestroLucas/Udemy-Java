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



    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position pos) {
        return possibleMoves()[pos.getRow()][pos.getColumn()];

    }


    public boolean isThereAnyPossibleMove() {
        boolean[][] matrix = possibleMoves();

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
