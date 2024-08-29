package l_chessProject.project.models.entities.boardGame;

public class Board {
    
    private Integer rows;
    private Integer cols;
    private Piece[][] pieces;


    public Board(Integer rows, Integer cols) {
        this.rows = rows;
        this.cols = cols;
        this.pieces = new Piece[rows][cols];
    }

    public Integer getRows() {
        return rows;
    }
    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getCols() {
        return cols;
    }
    public void setCols(Integer cols) {
        this.cols = cols;
    }


    public Piece piece(Integer row, Integer col) {
        return pieces[row][col];
    }

    public Piece piece(Position pos) {
        return pieces[pos.getRow()][pos.getColumn()];
    }


    public void placePiece(Piece piece, Position pos) {

        pieces[pos.getRow()][pos.getColumn()] = piece;
        piece.position = pos;

    }



}
