package Controllers;

import Models.*;
import Service.WinnerStrategyName;
import Service.WinningStrategyFactory;

import java.util.ArrayList;

public class GameController {

    public Game createGame(int dimension, ArrayList<Player> players, WinnerStrategyName winningStrategyName){
        return new Game.Builder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategy(WinningStrategyFactory.getWinnerStrategyName(winningStrategyName,dimension))
                .build();
    }
    public void displayBoard(Game game){
        game.getCurrentBoard().displayBoard();
    }

    public Move executeMove(Game game, Player player){
       return player.makeMove(game.getCurrentBoard());
    }

    public Player checkWinner(Game game,Move move){
        return game.getWinningStrategy().Winner(game.getCurrentBoard(),move);
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public void replay(Game game) throws InterruptedException {
        ArrayList<Board> ab=game.getBoards();
        ArrayList<Move> am=game.getMoves();
        Board b=new Board(game.getDimension());
        System.out.println("Welcome to TicTacToe. This is the initial board");
        b.displayBoard();
        System.out.println();
        Thread.sleep(2000);
        for(int i=0;i<ab.size();i++)
        {
            System.out.println(am.get(i).getPlayer().getName()+" played "+am.get(i).getPlayer().getSymbol()+" at row "+am.get(i).getCell().getRow()+" and column "+am.get(i).getCell().getCol());
            ab.get(i).displayBoard();
            System.out.println();
            //System.out.println();
            Thread.sleep(2000);
        }
        if(game.getGameStatus().equals(GameStatus.WINNER))
            System.out.println("The Winner is "+am.getLast().getPlayer().getName());
        else
            System.out.println("The game is a tie");
    }

    public void undo(Game game){
        game.getMoves().getLast().getCell().setPlayer(null);
        game.getMoves().getLast().getCell().setCellState(CellState.EMPTY);
        game.getMoves().removeLast();
        game.getBoards().removeLast();
    }
}
