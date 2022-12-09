package freezeTag;

public abstract class Robot {
    private int row;
    private int column;
    private String representation;

    public Robot(int row, int column, String representation) {
        this.row = row;
        this.column = column;
        this.representation=representation;

    }

    @Override
    public String toString() {
        return "Robot{" +
                "x=" + row +
                ", y=" + column +
                '}';
    }

    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }


}

