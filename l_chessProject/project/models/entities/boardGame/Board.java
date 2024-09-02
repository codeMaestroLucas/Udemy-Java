package l_chessProject.project.models.entities.boardGame;

public class Board {
    
    private Integer rows;
    private Integer cols;
    private Piece[][] pieces;


    public Board(Integer rows, Integer cols) {

        if (rows < 1 || cols < 1) {
            throw new BoardGameExpection(
                "Invalid BoardGame values for Column and Row.\n" +
                "There must be at least 1 row and column.");
        }

        this.rows = rows;
        this.cols = cols;
        this.pieces = new Piece[rows][cols];
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getCols() {
        return cols;
    }


    public Piece piece(Integer row, Integer col) {
        if (!positionExists(row, col)) {
            throw new BoardGameExpection(
               STR."Position (\{row}, \{col}) does not exist on the board.");
        }

        return pieces[row][col];
    }

    public Piece piece(Position pos) {
        return pieces[pos.getRow()][pos.getColumn()];
    }


    public void placePiece(Piece piece, Position pos) {
        if (thereIsAPiece(pos)) {
            throw new BoardGameExpection(
                STR."Position (\{pos}) already contains a piece.");
        }

        pieces[pos.getRow()][pos.getColumn()] = piece;
        piece.position = pos;
    }

    private Boolean positionExists(Integer row, Integer column) {
        return row >= 0 && row < rows && column >= 0 && column < cols;
    }

    public Boolean positionExists(Position pos) {
        return positionExists(pos.getRow(), pos.getColumn());
    }

    public Boolean thereIsAPiece(Position pos) {
        if (!positionExists(pos.getRow(), pos.getColumn())) {
            throw new BoardGameExpection(
               STR."Position (\{pos.getRow()}, \{pos.getColumn()})" +
                                "does't exist on the board.");
        }

        return piece(pos) != null;
    }


    public Piece removePiece(Position pos) {
        if (!positionExists(pos.getRow(), pos.getColumn())) {
            throw new BoardGameExpection(
                STR."Position (\{pos.getRow()}, \{pos.getColumn()})" +
                                    "does't exist on the board.");
        }

        if (piece(pos) == null) {return null;}

        Piece aux = piece(pos);
        pieces[pos.getRow()][pos.getColumn()] = null;
        aux.position = null;
        return aux;
    }

}
