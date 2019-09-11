package othermonkeysoftware.RPS;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class GameTest
{
    private RpsUi mockedUi;
    private PlayersBuilder mockedBuilder;
    private Players mockedPlayers;
    private RpsResult mockedResult;
    private Gesture[] gestures = new Gesture[]{};

    private Game target;

    @Before
    public void setUp()
    {
        mockedBuilder = mock(PlayersBuilder.class);
        mockedUi = mock(RpsUi.class);
        mockedPlayers = mock(Players.class);
        mockedResult = mock(RpsResult.class);

        validateMockitoUsage();

        when(mockedUi.askForGameMode()).thenReturn(GameMode.COMPUTER_VS_COMPUTER);
        when(mockedPlayers.roShamBo(gestures)).thenReturn(mockedResult);
        target = new Game(mockedUi, mockedBuilder, gestures);
    }

    @Test
    public void playRoundAsksForGameMode()
    {
        target.playRound();

        verify(mockedUi).askForGameMode();
    }

    @Test
    public void playRoundExecutesRoShamBo()
    {
        target.playRound();

        verify(mockedPlayers).roShamBo(gestures);
    }

    @Test
    public void playRoundDisplaysResult()
    {
        target.playRound();

        verify(mockedResult).announceWinner(mockedUi);
    }

    @Test
    public void playAgainIsFalseWhenFalseReturnFromConsole()
    {
        when(mockedUi.askToPlayAgain()).thenReturn(false);

        boolean actual = target.playAgain();

        Assert.assertFalse(actual);
    }

    @Test
    public void playAgainIsTrueWhenTrueReturnFromConsole()
    {
        when(mockedUi.askToPlayAgain()).thenReturn(true);

        boolean actual = target.playAgain();

        Assert.assertTrue(actual);
    }
}
