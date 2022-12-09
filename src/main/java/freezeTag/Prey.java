package freezeTag;

import java.util.ArrayList;
import java.util.Collections;

public class Prey extends Robot{
    public Prey(int x, int y,String representation) {
        super(x, y,representation);
    }


    public void makeMove(Prey prey, int boardRowSize, int boardColumnSize) {
        //loop through the arraylist and randomly generate a number between 1-4 so the prey can pick a possible direction to move to
        //print the generated number's

            ArrayList<Integer> possibleDirections = new ArrayList<>();
            //down -1, up -2 , left-3, right-4
            if(prey.getRow()<boardRowSize-1){
                possibleDirections.add(1);
            }
            if(prey.getRow()>0){
                possibleDirections.add(2);
            }
            if(prey.getColumn()>0){
                possibleDirections.add(3);
            }
            if(prey.getColumn()<boardColumnSize-1){
                possibleDirections.add(4);
            }
            Collections.shuffle( possibleDirections);
            int random = possibleDirections.get(0);
           switch (random){
               case 1:
                   prey.setRow(prey.getRow()+1);
                   break;
               case 2:
                   prey.setRow(prey.getRow()-1);
                   break;
               case 3:
                   prey.setColumn(prey.getColumn()-1);
                   break;
               case 4:
                   prey.setColumn(prey.getColumn()+1);
                   break;
           }

    }
}
