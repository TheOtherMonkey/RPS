package othermonkeysoftware.RPS;

public class Players
{
    private final Player player1;
    private final Player player2;

    public Players(Player player1, Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void roShamBo(Gesture[] validGestures)
    {
        player1.selectGesture(validGestures);
        player2.selectGesture(validGestures);
    }

    public void announceResult(RpsUi ui)
    {
        Gesture player1Gesture = this.player1.revealGesture(ui);
        Gesture player2Gesture = this.player2.revealGesture(ui);

        Outcome outcome = player1Gesture.compare(player2Gesture);

        announceWinner(player1Gesture, player2Gesture, outcome, ui);
    }

    private void announceWinner(Gesture player1Gesture, Gesture player2Gesture, Outcome outcome, RpsUi ui)
    {
        switch (outcome)
        {
            case PLAYER_1_WIN:

                describeWinningResult(player1Gesture, player2Gesture, ui);
                this.player1.announceAsWinner(ui);
                break;
            case PLAYER_2_WIN:
                describeWinningResult(player2Gesture, player1Gesture, ui);
                this.player2.announceAsWinner(ui);
                break;
            case DRAW:
                ui.announceDraw();
                break;
        }
    }

    private void describeWinningResult(Gesture winner, Gesture loser, RpsUi ui)
    {
        ui.describeWinningResult(winner.getName(), winner.getWinningAdjective(), loser.getName());
    }
}