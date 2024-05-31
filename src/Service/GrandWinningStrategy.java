package Service;

import Models.*;

import java.util.ArrayList;
import java.util.HashMap;

public class GrandWinningStrategy implements WinningStrategy{

    private int dimension;
    private ArrayList<HashMap<Character,Integer>> rowList;
    private ArrayList<HashMap<Character,Integer>> colList;
    private HashMap<Character,Integer>leftDiagonal;
    private HashMap<Character,Integer>rightDiagonal;
    private HashMap<Character,Integer>corners;

    public GrandWinningStrategy(int dimension) {
        this.dimension = dimension;
        this.rowList = new ArrayList<>();
        this.colList = new ArrayList<>();
        this.leftDiagonal = new HashMap<>();
        this.rightDiagonal = new HashMap<>();
        this.corners = new HashMap<>();
        for(int i=0;i<dimension;i++)
        {
            rowList.add(new HashMap<>());
            colList.add(new HashMap<>());
        }
    }
    @Override
    public Player Winner(Board board, Move move) {
        Cell cell=move.getCell();
        Player player=move.getPlayer();
        int row= cell.getRow();
        int col= cell.getCol();
        char symbol= player.getSymbol();

         if (checkWinnerRow(row,symbol)
                || checkWinnerCol(col,symbol)
                    || ((row==col) && checkWinnerLeftDiagonal(symbol))
                        || ((row+col==dimension-1) && checkWinnerRightDiagonal(symbol))
                            || (cornerConditions(row,col) && checkWinnerCorners(symbol)))
             return player;
         else
             return null;
    }

    public boolean checkWinnerRow(int row,char symbol){
        HashMap<Character,Integer> hm=rowList.get(row);
        if(hm.containsKey(symbol))
        {
            hm.put(symbol,hm.get(symbol)+1);
            return hm.get((symbol))==dimension;
        }
        else
            hm.put(symbol,1);
        return false;
    }

    public boolean checkWinnerCol(int col,char symbol){
        HashMap<Character,Integer> hm=colList.get(col);
        if(hm.containsKey(symbol))
        {
            hm.put(symbol,hm.get(symbol)+1);
            return hm.get((symbol))==dimension;
        }
        else
            hm.put(symbol,1);
        return false;
    }

    public boolean checkWinnerLeftDiagonal(char symbol){
        if(leftDiagonal.containsKey(symbol))
        {
            leftDiagonal.put(symbol,leftDiagonal.get(symbol)+1);
            return leftDiagonal.get((symbol))==dimension;
        }
        else
            leftDiagonal.put(symbol,1);
        return false;
    }
    public boolean checkWinnerRightDiagonal(char symbol){
        if(rightDiagonal.containsKey(symbol))
        {
            rightDiagonal.put(symbol,rightDiagonal.get(symbol)+1);
            return rightDiagonal.get((symbol))==dimension;
        }
        else
            rightDiagonal.put(symbol,1);
        return false;
    }

    public boolean checkWinnerCorners(char symbol){
        if(corners.containsKey(symbol))
        {
            corners.put(symbol,corners.get(symbol)+1);
            return corners.get((symbol))==4;
        }
        else
            corners.put(symbol,1);
        return false;
    }

    public boolean cornerConditions(int row,int col){
        boolean b = (row == 0 && col == 0) || (row == 0 && col == dimension - 1) || (row == dimension-1 && col == 0) || (row == dimension-1 && col == dimension - 1);
        return b;
    }
}
