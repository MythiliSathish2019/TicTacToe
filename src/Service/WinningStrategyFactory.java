package Service;

public class WinningStrategyFactory {
    public static WinningStrategy getWinnerStrategyName(WinnerStrategyName winnerStrategyName,int dimension){
        return switch(winnerStrategyName){
            case GRAND -> new GrandWinningStrategy(dimension);
            case MEDIOCRE -> new MediocreWinningStrategy();
            case WORST -> new WorstWinningStrategy();
        };
    }
}
