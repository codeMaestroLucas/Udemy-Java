package l_chessProject.project.models.entities.boardGame;

public class Position {
    
    private Integer row;
    private Integer column;


    public Position(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }
    
    public Integer getRow() {
        return row;
    }

    public Integer getColumn() {
        return column;
    }


    public void setValues(Integer newRow, Integer newColumn) {
        this.row = newRow;
        this.column = newColumn;
    }

    @Override
    public String toString() {
        return this.getRow() + ", " + this.getColumn();
    }


}
