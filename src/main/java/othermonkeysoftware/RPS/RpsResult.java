package othermonkeysoftware.RPS;

public class RpsResult {

    private Player player1;
    private Player player2;
    private Outcome outcome;

    public RpsResult(Player player1, Player player2, Outcome outcome)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.outcome = outcome;
    }

    public void announceWinner(RpsUi ui) {
        this.player1.revealGesture(ui);
        this.player2.revealGesture(ui);

        switch (this.outcome) {
            case PLAYER_1_WIN:
                this.player1.announceAsWinner(ui);
                this.player2.announceAsLoser(ui);
                break;
            case PLAYER_2_WIN:
                this.player2.announceAsWinner(ui);
                this.player1.announceAsLoser(ui);
                break;
            case DRAW:
                ui.announceDraw();
                break;
        }
    }
}
