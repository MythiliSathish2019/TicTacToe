package Models;

import Exceptions.NoMoreCells;
import Service.BotPlayingStrategyFactory;

import java.util.ArrayList;

public class Bot extends Player {

    private BotDifficultyLevel botDifficultyLevel;
    public Bot(int id) {
        super(id, "BOT", '$', PlayerType.BOT);
        this.botDifficultyLevel=BotDifficultyLevel.EASY;
    }

    @Override
    public Move makeMove(Board board) {
        return BotPlayingStrategyFactory.getBotPlayingStrategy(BotDifficultyLevel.EASY).makeMove(board,this);
    }
}
