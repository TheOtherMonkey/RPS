package othermonkeysoftware.RPS;

public class Players {

    private Player player1;
    private Player player2;

    public Players(Player player1, Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
    }

    public RpsResult roShamBo(Gesture[] validGestures) {
        Gesture player1Gesture = this.player1.selectGesture(validGestures);
        Gesture player2Gesture = this.player2.selectGesture(validGestures);

        Outcome outcome = player1Gesture.compare(player2Gesture);

        return new RpsResult(this.player1, this.player2, outcome);
    }
}
