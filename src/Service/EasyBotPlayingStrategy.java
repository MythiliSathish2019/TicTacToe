package Service;

import Exceptions.NoMoreCells;
import Models.*;

import java.util.ArrayList;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move makeMove(Board board, Player player) {
        for(int i=0;i<board.getDimension();i++)
        {
            for(int j=0;j<board.getDimension();j++)
            {
                if(board.getMatrix().get(i).get(j).getCellState()== CellState.EMPTY)
                {
                    board.getMatrix().get(i).get(j).setPlayer(player);
                    board.getMatrix().get(i).get(j).setCellState(CellState.FILLED);
                    return new Move(player,board.getMatrix().get(i).get(j));
                }
            }
        }
        throw new NoMoreCells("No more cells left to play");
    }

}
