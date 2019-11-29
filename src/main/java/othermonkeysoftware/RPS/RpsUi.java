package othermonkeysoftware.RPS;

public interface RpsUi
{
    boolean askToPlayAgain();

    String askForPlayerName();

    GameMode askForGameMode();

    Gesture askForPlayerGesture(Gesture[] gestures);

    void describePlayerGesture(String playerName, String gestureName);

    void announceWinner(String playerName);

    void announceDraw();

    void describeGesture(String name, String inputValue);

    void describeWinningResult(String winningGesture, String winningAdjective, String losingGesture);
}
