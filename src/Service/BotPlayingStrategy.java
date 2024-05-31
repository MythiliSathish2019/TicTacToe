package Service;

import Models.Board;
import Models.Move;
import Models.Player;

public interface BotPlayingStrategy {
    public Move makeMove(Board board, Player player);
}
