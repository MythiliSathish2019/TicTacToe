package Service;

import Models.Board;
import Models.Move;
import Models.Player;

public interface WinningStrategy {
    public Player Winner(Board board, Move move);
}
