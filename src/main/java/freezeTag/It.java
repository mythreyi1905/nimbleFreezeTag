package freezeTag;

import java.util.ArrayList;
import java.util.Collections;

public class It extends Robot {
    public It(int x, int y, String representation) {
        super(x, y,representation);
    }

    private double calculateDistance(Robot r1, Robot r2){
        int x1 = r1.getRow();
        int y1 = r1.getColumn();
        int x2 = r2.getRow();
        int y2 = r2.getColumn();
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
    public void makeMove( ArrayList<Prey> activePreys, int boardRowSize, int boardColumnSize) {
        //check distances between itself and prey and pick the nearest prey and move towards it.
        double minDistance = Double.MAX_VALUE;
        Robot targetPrey = null;
        for (Prey p : activePreys) {
            if (calculateDistance(this, p) < minDistance) {
                minDistance = calculateDistance(this, p);
                targetPrey = p;
            }
        }


        //if it is one cell away from prey, then predictively move towards where the prey might take the next move
        if (isPreyOneAway(targetPrey))
        {
            makeMoveOneAway(targetPrey, boardRowSize, boardColumnSize);
        }
        //else make a move and gravitate towards the prey
        else{
            //if targetPrey is on the same row
            if (this.getRow() == targetPrey.getRow()) {
                if (targetPrey.getColumn() > this.getColumn()) {
                    this.setColumn(this.getColumn() + 1);
                } else {
                    this.setColumn(this.getColumn() - 1);
                }
            }

            //if targetPrey is on the same column
            else if (this.getColumn() == targetPrey.getColumn()) {
                if (targetPrey.getRow() > this.getRow()) {
                    this.setRow(this.getRow() + 1);
                } else {
                    this.setRow(this.getRow() - 1);
                }
            }

            //if targetPrey is neither on same column nor same row
            else {
                //set the column
                if (targetPrey.getColumn() > this.getColumn() && targetPrey.getRow() < this.getRow()) {
                    this.setColumn(this.getColumn() + 1);
                    this.setRow(this.getRow() - 1);
                } else if (targetPrey.getColumn() > this.getColumn() && targetPrey.getRow() > this.getRow()) {
                    this.setColumn(this.getColumn() + 1);
                    this.setRow(this.getRow() + 1);
                } else if (targetPrey.getColumn() < this.getColumn() && targetPrey.getRow() > this.getRow()) {
                    this.setColumn(this.getColumn() - 1);
                    this.setRow(this.getRow() + 1);
                } else if (targetPrey.getColumn() < this.getColumn() && targetPrey.getRow() < this.getRow()) {
                    this.setColumn(this.getColumn() - 1);
                    this.setRow(this.getRow() - 1);
                }

            }
        }

    }


    public boolean isPreyOneAway(Robot targetPrey){
        if(this.getRow()==targetPrey.getRow() && Math.abs(this.getColumn()-targetPrey.getColumn())==1){
            //same row, adjacent columns
            return true;
        }
        else if(this.getColumn()==targetPrey.getColumn() && Math.abs(this.getRow()-targetPrey.getRow())==1){
            //same column, adjacent rows
            return true;
        }
        else if(Math.abs(this.getRow()-targetPrey.getRow())==1 && Math.abs(this.getColumn()-targetPrey.getColumn())==1){
            return true;
        }
        else{
            return false;
        }
    }


    public void makeMoveOneAway(Robot prey, int boardRowSize, int boardColumnSize) {
        //loop through the arraylist and randomly generate a number between 1-8 to denote possible movement directions for targetPrey
        //print the generated number's

        ArrayList<Integer> possibleDirections = new ArrayList<>();
        //down -1, up -2 , left-3, right-4 , topRight-5, topLeft -6, bottomRight - 7, bottomLeft -8
        if(this.getRow()<boardRowSize-1 && !(prey.getRow()==this.getRow()+1 && prey.getColumn()==this.getColumn())){
            possibleDirections.add(1);
        }
        if(this.getRow()>0 && !(prey.getRow()==this.getRow()-1 && prey.getColumn()==this.getColumn())){
            possibleDirections.add(2);
        }
        if(this.getColumn()>0 && !(prey.getRow()==this.getRow() && prey.getColumn()==this.getColumn()-1)){
            possibleDirections.add(3);
        }
        if(this.getColumn()<boardColumnSize-1 && !(prey.getRow()==this.getRow() && prey.getColumn()==this.getColumn()-1)){
            possibleDirections.add(4);
        }
        //topRight
        if(this.getRow()>0 && this.getColumn()<boardColumnSize-1 && !(prey.getRow()==this.getRow()-1 && prey.getColumn()==this.getColumn()+1)){
            possibleDirections.add(5);
        }
        //topLeft
        if(this.getRow()>0 && this.getColumn()>0 && !(prey.getRow()==this.getRow()-1 && prey.getColumn()==this.getColumn()-1)){
            possibleDirections.add(6);
        }
        //bottomRight
        if(this.getRow()<boardRowSize-1 && this.getColumn()<boardColumnSize-1 && !(prey.getRow()==this.getRow()+1 && prey.getColumn()==this.getColumn()+1)){
            possibleDirections.add(7);
        }
        //bottomLeft
        if(this.getRow()<boardRowSize-1 && this.getColumn()>0 && !(prey.getRow()==this.getRow()+1 && prey.getColumn()==this.getColumn()-1)){
            possibleDirections.add(8);
        }



        Collections.shuffle( possibleDirections);
        int random = possibleDirections.get(0);
        switch (random){
            case 1:
                this.setRow(this.getRow()+1);
                break;
            case 2:
                this.setRow(this.getRow()-1);
                break;
            case 3:
                this.setColumn(this.getColumn()-1);
                break;
            case 4:
                this.setColumn(this.getColumn()+1);
                break;
            case 5:
                this.setColumn(this.getColumn()+1);
                this.setRow(this.getRow()-1);
                break;
            case 6:
                this.setColumn(this.getColumn()-1);
                this.setRow(this.getRow()-1);
                break;
            case 7:
                this.setColumn(this.getColumn()+1);
                this.setRow(this.getRow()+1);
                break;
            case 8:
                this.setColumn(this.getColumn()-1);
                this.setRow(this.getRow()+1);
                break;
        }

    }


}
