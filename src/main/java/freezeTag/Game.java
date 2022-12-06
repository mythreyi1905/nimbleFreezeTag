package freezeTag;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game {
    //maintain arrayList of active robots
    //check if game ends
    // check if a prey is frozen
    //move the it robot
    // move the preys - for loop
    //keep track of move/time
    //keep track of prey
    //keep track of it
    //timeout

    public void initializeObjects(Map<String, Object> obj){
        int gridColumns = (int) obj.get("grid_x_size");
        int gridRows= (int) obj.get("grid_y_size");
        Board board = new Board(gridRows, gridColumns);
        int it_column  =   ((Map<String, Integer>)obj.get("it_starting_location")).get("x");
        int it_row =  ((Map<String, Integer>)obj.get("it_starting_location")).get("y");

        It it = new It(it_row, it_column,"it");
        board.addToBoard("it",it_row,it_column);
        List<Object> list1 = ( (List<Object>) obj.get("prey_starting_locations"));


        //initialize prey objects
        ArrayList<Prey> activePreys = new ArrayList<>();
        ArrayList<Prey> frozenPreys = new ArrayList<>();
        for(int i=0;i<list1.size();i++){
            int prey_column = ( (Map<String,Integer>)( (List<Object>) obj.get("prey_starting_locations")).get(i)).get("x");
            int prey_row = ( (Map<String,Integer>)( (List<Object>) obj.get("prey_starting_locations")).get(i)).get("y");
            String rep = "p"+(i+1);
            Prey p = new Prey(prey_row,prey_column,rep);
            board.addToBoard(rep,prey_row,prey_column);
            activePreys.add(p);
        }

        System.out.println(activePreys);
        System.out.println(board);
        System.out.println(it);
int count = 0 ;
        while(!endGame(activePreys)){
            count+=1;
            int itfromRow = it.getRow();
            int itfromColumn = it.getColumn();
            it.makeMove(activePreys,gridRows,gridColumns);
            board.moveRobotTo(it.getRepresentation(),itfromRow,itfromColumn,it.getRow(),it.getColumn());
            It prevMove = new It(it.getRow(), it.getColumn(),"x");
            it.makeMove(activePreys,gridRows,gridColumns);
            board.moveRobotTo(it.getRepresentation(),itfromRow,itfromColumn,it.getRow(),it.getColumn());
            for(Prey prey: activePreys){
                int preyfromRow = prey.getRow();
                int preyfromColumn = prey.getColumn();
                prey.makeMove(prey,gridRows,gridColumns);
                board.moveRobotTo(prey.getRepresentation(),preyfromRow,preyfromColumn,prey.getRow(),prey.getColumn());
            }
            freezePrey(board, it,activePreys,frozenPreys);
            unfreezePrey(board, activePreys,frozenPreys);
            board.printBoard();
            System.out.println("==============================================================================================================================");

        }
        System.out.println("============================================GAME OVER======================================");
        System.out.println(count);


    }

    public void freezePrey(Board board,It it, ArrayList<Prey> activePreys, ArrayList<Prey> frozenPreys){
        ArrayList<Prey> activePreysClone = (ArrayList)activePreys.clone();
        for(Prey prey : activePreysClone){
            if(prey.getRow()==it.getRow() && prey.getColumn()==it.getColumn()){
            activePreys.remove(prey);
            frozenPreys.add(prey);
            board.removeFromBoard(prey.getRepresentation(),prey.getRow(),prey.getColumn());
            }
        }
    }

//    public void checkPreviousFreeze()

    public void unfreezePrey(Board board, ArrayList<Prey> activePreys, ArrayList<Prey> frozenPreys){
        ArrayList<Prey> activePreysClone = (ArrayList)activePreys.clone();
        ArrayList<Prey> frozenPreysClone = (ArrayList)frozenPreys.clone();
        for(Prey prey1 : activePreysClone){
            for(Prey prey2:frozenPreysClone){
                if(prey1.getRow()==prey2.getRow() && prey1.getColumn()==prey2.getColumn()){
                    frozenPreys.remove(prey2);
                    activePreys.add(prey2);
                    board.addToBoard(prey2.getRepresentation(),prey2.getRow(),prey2.getColumn());
                }
            }
        }
    }

    public boolean endGame(ArrayList<Prey> activePreys){
        if(activePreys.size()==0){
            return true;
        }
        else{
            return false;
        }
    }




}