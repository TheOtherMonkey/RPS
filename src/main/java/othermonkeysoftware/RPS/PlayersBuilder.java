package othermonkeysoftware.RPS;

public class PlayersBuilder
{
    private final RandomGesturePicker randomGesturePicker;
    private final UiGesturePicker uiGesturePicker;

    public PlayersBuilder(RandomGesturePicker randomGesturePicker, UiGesturePicker uiGesturePicker)
    {
        this.randomGesturePicker = randomGesturePicker;
        this.uiGesturePicker = uiGesturePicker;
    }

    public Players selectPlayers(GameMode mode, RpsUi ui)
    {
        Players players = null;

        switch (mode){
            case COMPUTER_VS_COMPUTER:
                players = computerVsComputer();
                break;
            case HUMAN_VS_COMPUTER:
                players = humanVsComputer(ui);
                break;
        }
        return players;
    }

    public Players computerVsComputer()
    {
        Player player1 = new Player("Computer 1", this.randomGesturePicker);
        Player player2 = new Player("Computer 2", this.randomGesturePicker);

        return new Players(player1, player2);
    }

    public Players humanVsComputer(othermonkeysoftware.RPS.RpsUi ui)
    {
        Player player1 = new Player(ui.askForPlayerName(), this.uiGesturePicker);
        Player player2 = new Player("Computer", this.randomGesturePicker);

        return new Players(player1, player2);
    }
}
