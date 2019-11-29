package othermonkeysoftware.RPS;

public final class Game
{
    private final RpsUi ui;
    private final PlayersBuilder playersBuilder;
    private final Gesture[] validGestures;

    public Game(final RpsUi ui, final PlayersBuilder playersBuilder, final Gesture[] validGestures)
    {
        this.ui = ui;
        this.playersBuilder = playersBuilder;
        this.validGestures = validGestures;
    }

    public void playRound()
    {
        final GameMode mode = this.ui.askForGameMode();
        final Players players = this.playersBuilder.selectPlayers(mode, this.ui);

        players.roShamBo(this.validGestures);
        players.announceResult(this.ui);
    }

    public boolean playAgain()
    {
        return this.ui.askToPlayAgain();
    }
}
