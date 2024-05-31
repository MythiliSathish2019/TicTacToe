package Models;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Board {
    private int dimension;
    private ArrayList<ArrayList<Cell>> matrix;

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
    public int getDimension() {
        return dimension;
    }

    public ArrayList<ArrayList<Cell>> getMatrix() {
        return matrix;
    }


    public Board(int dimension) {
        this.dimension = dimension;
        this.matrix=new ArrayList<>();
        for(int i=0;i<dimension;i++)
        {
            matrix.add(new ArrayList<>());
            for(int j=0;j<dimension;j++)
            {
                matrix.get(i).add(new Cell(i,j));
            }
        }
    }

    public void displayBoard(){
        //System.out.println("BOARD");
        for(int i=0;i<dimension;i++)
        {
            for(int j=0;j<dimension;j++){
                if(matrix.get(i).get(j).getCellState()==CellState.EMPTY)
                    System.out.print("| |");
                else
                    System.out.print("|"+matrix.get(i).get(j).getPlayer().getSymbol()+"|");
            }
            System.out.println();
        }
    }

    public Board duplicate(){
        Board b=new Board(this.getDimension());
        for(int i=0;i<dimension;i++)
        {
            for(int j=0;j<dimension;j++)
            {
                Cell cell=new Cell();
                cell.setRow(i);
                cell.setCol(j);
                cell.setCellState(this.matrix.get(i).get(j).getCellState());
                cell.setPlayer(this.matrix.get(i).get(j).getPlayer());
                b.matrix.get(i).set(j,cell);
            }
        }
        return b;
    }
}
