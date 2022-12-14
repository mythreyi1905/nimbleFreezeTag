
package freezeTag;

        import java.util.ArrayList;
        import java.util.List;

public class Board {

    private int rows;
    private int columns;
    private List<List<List<String>>> board;

    /**
     * Public constructor for the board
     * @param rows
     * @param columns
     */
    public Board(int rows, int columns){
        this.rows = rows;
        this.columns = columns;

        // initialize the board with all spaces _

        this.board = new ArrayList<>(rows);

        for(int i = 0; i < rows; i++){
            this.board.add(new ArrayList<>());
            for(int j = 0; j <columns; j++){
                this.board.get(i).add(new ArrayList<>());

            }
        }
    }

    /**
     * This function when called prints the current state of the board
     */
    public void printBoard(){
        for(List<List<String>> row : board){
            System.out.println(row);
        }
    }

    /**
     * This method takes in the id and appends it to the list of existing objects
     * in the location, {i,j}
     * @param id
     * @param row
     * @param column
     */
    public void addToBoard(String id, int row, int column){
        this.board.get(row).get(column).add(id);
    }

    /**
     * This method takes in the id and appends it to the list of existing objects
     * in the location, {i,j}
     * @param id
     * @param row
     * @param column
     */
    public void removeFromBoard(String id, int row, int column){
        this.board.get(row).get(column).remove(id);
    }

    /**
     * This method is used to move a robot across the board
     * @param id
     * @param fromRow
     * @param fromColumn
     * @param toRow
     * @param toColumn
     */
    public void moveRobotTo(String id, int fromRow, int fromColumn, int toRow, int toColumn){

        // remove the id from old cell and move it to new cell

        // check if the id exists in that cell
        boolean isPresent = this.board.get(fromRow).get(fromColumn).contains(id);

        if(isPresent){
            this.board.get(fromRow).get(fromColumn).remove(id);
        }

        this.board.get(toRow).get(toColumn).add(id);

    }

}
