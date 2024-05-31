package Models;

import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private char symbol;
    private PlayerType playerType;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Player(int id, String name, char symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Move makeMove(Board board){
        Scanner scn=new Scanner(System.in);
        System.out.println(this.getName()+" enter the row for the cell");
        int row=scn.nextInt();
        System.out.println(this.getName()+" enter the col for the cell");
        int col=scn.nextInt();
        Cell cell=board.getMatrix().get(row).get(col);
        while(cell.getCellState()==CellState.FILLED)
            {
                System.out.println("Cell already Occupied. Try Again!");
                System.out.println(this.getName()+" enter the row for the cell");
                row=scn.nextInt();
                System.out.println(this.getName()+" enter the col for the cell");
                col=scn.nextInt();
                cell=board.getMatrix().get(row).get(col);
            }
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);
        return new Move(this,cell);
    }
}
