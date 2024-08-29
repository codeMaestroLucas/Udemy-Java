package l_chessProject.project.models.entities.boardGame;

public class ChessMatch {
    
    private Board board;

    public ChessMatch() {
        this.board = new Board(8, 8);
    }

    public ChessPiece[][] getPieces() {
        int rows = this.board.getRows();
        int cols = this.board.getCols();

        ChessPiece[][] matrix = new ChessPiece [rows][cols];

        for (int i = 0; i < rows; i++) {
            for(int j = 0 ; j < cols; j++) {
                matrix[i][j] = (ChessPiece) board.piece(i, j);
            }
        }

        return matrix;

    }

}
