package Models;

import Exceptions.InvalidNoOfPlayers;
import Exceptions.InvalidNoOfSymbols;
import Service.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;

public class Game {
    private int dimension;
    private Board currentBoard;
    private ArrayList<Player> players=new ArrayList<>();
    private ArrayList<Board> boards=new ArrayList<>();
    private ArrayList<Move> moves=new ArrayList<>();
    private GameStatus gameStatus;
    private int noOfSymbols;
    private WinningStrategy winningStrategy;

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Board> getBoards() {
        return boards;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getDimension() {
        return dimension;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }
    public void setCurrentBoard(Board currentBoard) {
        this.currentBoard = currentBoard;
    }

    public void setNoOfSymbols(int noOfSymbols) {
        this.noOfSymbols = noOfSymbols;
    }

    public int getNoOfSymbols() {
        return noOfSymbols;
    }

    public Game(int dimension, ArrayList<Player> players,Board currentBoard,WinningStrategy winningStrategy) {
        this.dimension = dimension;
        this.currentBoard = currentBoard;
        this.players = players;
        this.boards = new ArrayList<>();
        this.moves = new ArrayList<>();
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.noOfSymbols = players.size();
        this.winningStrategy=winningStrategy;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private int dimension;
        private Board currentBoard;
        private ArrayList<Player> players=new ArrayList<>();
        private WinningStrategy winningStrategy;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setCurrentBoard(Board currentBoard) {
            this.currentBoard = currentBoard;
            return this;
        }

        public Builder setPlayers(ArrayList<Player> players) {
            this.players = players;
            return this;
        }

        public int getDimension() {
            return dimension;
        }

        public Board getCurrentBoard() {
            return currentBoard;
        }

        public ArrayList<Player> getPlayers() {
            return players;
        }

        public WinningStrategy getWinningStrategy() {
            return winningStrategy;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public void validate(){
            validateNoOfPlayers();
            validateNoOfSymbols();
        }

        public void validateNoOfPlayers(){
            if(players.size()<(dimension-2) || players.size()>=dimension)
                throw new InvalidNoOfPlayers("No.of Players shoud be dimension-1");
        }

        public void validateNoOfSymbols(){
            HashSet<Character>h=new HashSet<>();
            for(Player p:players)
            {
                h.add(p.getSymbol());
            }
            if(h.size()!=players.size())
                throw new InvalidNoOfSymbols("Chances of similar symbols");
        }

        public Game build(){
            validate();
            return new Game(this.dimension,this.players,new Board(dimension),this.winningStrategy);
        }
    }
}
