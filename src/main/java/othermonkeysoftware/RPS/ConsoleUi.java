package othermonkeysoftware.RPS;

import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public final class ConsoleUi implements RpsUi
{
    @Override
    public boolean askToPlayAgain()
    {
        System.out.println("Do you wish to play again?");
        String response;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Enter Y or N: ");
            response = in.nextLine().toUpperCase();
        } while(!(response.equals("Y") || response.equals("N")));

        return response.equals("Y");
    }

    @Override
    public String askForPlayerName()
    {
        System.out.println("Type player's name and press <ENTER>:");
        return new Scanner(System.in).nextLine();
    }

    @Override
    public GameMode askForGameMode()
    {
        System.out.println("Select the type of game you wish to play");
        System.out.println("1 = Computer vs. Computer");
        System.out.println("2 = Human vs. Computer");

        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\nPlease enter 1 or 2:");
            String keyInput = in.nextLine();

            switch (keyInput) {
                case "1":
                    return GameMode.COMPUTER_VS_COMPUTER;
                case "2":
                    return GameMode.HUMAN_VS_COMPUTER;
            }
        } while (false);

        return GameMode.UNKNOWN;
    }

    @Override
    public Gesture askForPlayerGesture(Gesture[] gestures)
    {
        Optional<Gesture> selectedGesture;

        do {

            System.out.println("Please select a gesture from the following...");
            for (Gesture gesture:gestures) {
                gesture.describeSelf(this);
            }
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            selectedGesture = Stream.of(gestures).filter(g -> g.matchesInput(input)).findFirst();

            if (!selectedGesture.isPresent()) System.out.println("Invalid selection...\n");

        }while (!selectedGesture.isPresent());

        return selectedGesture.get();
    }

    @Override
    public void describePlayerGesture(String playerName, String gestureName)
    {
        System.out.print(playerName);
        System.out.print(" selected ");
        System.out.println(gestureName);
    }

    @Override
    public void announceWinner(String playerName)
    {
        System.out.print(playerName);
        System.out.println(" won that round");
        System.out.println();
    }

    @Override
    public void announceDraw()
    {
        System.out.println("It was a draw");
        System.out.println();
    }

    @Override
    public void describeGesture(String name, String inputValue)
    {
        System.out.print(name);
        System.out.print(" = ");
        System.out.println(inputValue);
    }

    @Override
    public void describeWinningResult(String winningGesture, String winningAdjective, String losingGesture)
    {
        describeWinningGesture(winningGesture, winningAdjective);
        describeLosingGesture(losingGesture);
    }

    public void describeWinningGesture(String name, String winningAdjective)
    {
        System.out.print(name);
        System.out.print(" ");
        System.out.print(winningAdjective);
        System.out.print(" ");
    }

    public void describeLosingGesture(String name)
    {
        System.out.println(name);
        System.out.println();
    }
}