package othermonkeysoftware.RPS;

import othermonkeysoftware.RPS.Gestures.PaperGesture;
import othermonkeysoftware.RPS.Gestures.RockGesture;
import othermonkeysoftware.RPS.Gestures.ScissorsGesture;

public final class Main
{
    public static void main(String[] args)
    {

        Gesture[] validGestures =
                {
                    new RockGesture(),
                    new ScissorsGesture(),
                    new PaperGesture()
                };

        RpsUi rpsUi = new ConsoleUi();
        PlayersBuilder playersBuilder = new PlayersBuilder(
                new RandomGesturePicker(new Randomiser()),
                new UiGesturePicker(rpsUi));
        Game game = new Game(rpsUi, playersBuilder, validGestures);

        do {
            game.playRound();
        } while (game.playAgain());

    }
}
