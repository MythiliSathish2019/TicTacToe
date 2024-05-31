import Controllers.GameController;
import Models.*;
import Service.WinnerStrategyName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        GameController gameController = new GameController();
        ArrayList<Player> players = new ArrayList<>();
        int id = 1;
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe");
        System.out.print("Enter the dimension required");
        int dimension = s.nextInt();
        System.out.println("Do you want Bot? Y/N");
        String str = s.next().toUpperCase().charAt(0)+"";
        if (str.equals("Y")) {
            Player bot = new Bot(id);
            players.add(bot);
            id++;
        }
        while(id<dimension){
            id++;
            System.out.println("Enter your name");
            String name=s.next();
            System.out.println("Choose a character to play as your symbol except '$'");
            char symbol=s.next().charAt(0);
            Player player=new Player(id,name,symbol,PlayerType.HUMAN);
            players.add(player);
        }
        Collections.shuffle(players);
        //System.out.println(players);
        Game game=gameController.createGame(dimension,players, WinnerStrategyName.GRAND);
        int playerIdx=-1;
        while(game.getGameStatus().equals(GameStatus.IN_PROGRESS))
            {
                System.out.println("Current Board");
                gameController.displayBoard(game);
                playerIdx++;
                playerIdx=playerIdx%players.size();
                Player nowPlaying=players.get(playerIdx);
                //System.out.println(nowPlaying.getSymbol());
                Move lastPlayed=gameController.executeMove(game,nowPlaying);
                game.getMoves().add(lastPlayed);
                Board temp=game.getCurrentBoard().duplicate();
                game.getBoards().add(temp);
                boolean b=true;
                if(!nowPlaying.getPlayerType().equals(PlayerType.BOT))
                {
                    System.out.println("Do you want to undo your move? Y/N");
                    String u = s.next().toUpperCase().charAt(0) + "";
                    while(u.equals("Y") && b)
                    {
                        gameController.undo(game);
                        gameController.displayBoard(game);
                        lastPlayed = gameController.executeMove(game, nowPlaying);
                        game.getMoves().add(lastPlayed);
                        temp=game.getCurrentBoard().duplicate();
                        game.getBoards().add(temp);
                        //gameController.displayBoard(game);
                        System.out.println("Do you want to undo your move again? Y/N");
                        String v = s.next().toUpperCase().charAt(0) + "";
                        if(v.equals("N"))
                            b=false;
                    }
                }

                Player winner=gameController.checkWinner(game,lastPlayed);
                if(winner !=null)
                    {
                        game.setGameStatus(GameStatus.WINNER);
                        System.out.println();
                        System.out.println("CONGRATULATIONS! The Winner is "+nowPlaying.getName()+"!");
                    }
                else if(game.getMoves().size()== (game.getDimension()* game.getDimension()))
                    {
                        game.setGameStatus(GameStatus.DRAW);
                        System.out.println();
                        System.out.println("The game is a tie. Better luck next time!");
                    }
            }
        System.out.println();
        System.out.println("Final Board");
        game.getCurrentBoard().displayBoard();
        System.out.println();
        System.out.println("Do you want to see the replay of the game? Y/N");
        String ans=s.next().toUpperCase().charAt(0)+"";
        if(ans.equals("Y"))
            gameController.replay(game);
        System.out.println("Thank you for playing.");
    }
}
