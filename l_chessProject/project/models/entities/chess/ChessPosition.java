package l_chessProject.project.models.entities.chess;

import l_chessProject.project.models.entities.boardGame.Position;


public class ChessPosition {
    
    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            System.out.println(column + " " + row);
            throw new ChessException("Invalid values for Column and Row");
        }

        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }


    protected Position toPosition() {
        return new Position(8 - this.row, (this.column - 'a'));
        /*
         * COLUMN => CHAR;
         * `- 'a'` subtracts the UNICODE value for 'a';

         * Ex.:
            * 'a' - 'a' = 0
            * 'b' - 'a' = 1
            * 'c' - 'a' = 2
            * ...
            * 'h' - 'a' = 7
         */
    }

    protected static ChessPosition fromPosition(Position pos) {
        char col = (char) ('a' + pos.getColumn());
        return new ChessPosition(col, 8 - pos.getRow());
    }

    @Override
    public String toString() {
        return STR."\{column}\{row}";
    }

}
