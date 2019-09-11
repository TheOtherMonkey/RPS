package othermonkeysoftware.RPS;

public final class Game
{
    private final RpsUi ui;
    private final PlayersBuilder playersBuilder;
    private Gesture[] validGestures;

    public Game(RpsUi ui, PlayersBuilder playersBuilder, Gesture[] validGestures)
    {
        this.ui = ui;
        this.playersBuilder = playersBuilder;
        this.validGestures = validGestures;
    }

    public void playRound()
    {
        GameMode mode = this.ui.askForGameMode();
        Players players = this.playersBuilder.selectPlayers(mode, this.ui);
        RpsResult result = players.roShamBo(this.validGestures);
        result.announceWinner(this.ui);
    }

    public boolean playAgain()
    {
        return this.ui.askToPlayAgain();
    }
}
