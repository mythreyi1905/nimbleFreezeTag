
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




//    public void printBoard(){
//        // for every cell, we place the elements in that cell followed by padding to ensure we have all the cells the same size as the
//        // maxElems value
//
//        // Iterate over each row of the board
//        for(List<List<String>> row : board){
//            // place a | at start of each row
//            System.out.print("|");
//            // Iterating through each column
//            for(List<String> cell : row){
//
//                // we need to print the elements in this cell with appropriate padding
//                // we know that max elements is maxElems
//                // so let's find teh number of elements in this cell,
//                // print those elements and then remaining places we pad it with a space
//                int numElems = cell.size();
//
//                // printing the elements in the cell
//                for(String elem : cell){
//                    System.out.print(elem + " ");
//                }
//
//                int remaining = maxElems - numElems;
//
//                if(remaining > 0){
//                    // fill remaining space with paddding
//                    System.out.print(" ");
//                }
//
//                // end each cell with a |
//                System.out.print(" |");
//            }
//
//
//            // at the end print a line
//            System.out.println();
//
//        }
//
//    }







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
