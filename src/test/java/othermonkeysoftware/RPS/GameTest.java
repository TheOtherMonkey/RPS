package othermonkeysoftware.RPS;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class GameTest
{
    private RpsUi mockedUi;
    private Players mockedPlayers;
    private Gesture[] gestures = new Gesture[]{};

    private Game target;

    @Before
    public void setUp()
    {
        PlayersBuilder mockedBuilder = mock(PlayersBuilder.class);
        mockedUi = mock(RpsUi.class);
        mockedPlayers = mock(Players.class);

        validateMockitoUsage();

        when(mockedBuilder.selectPlayers(GameMode.COMPUTER_VS_COMPUTER, mockedUi)).thenReturn(mockedPlayers);
        when(mockedUi.askForGameMode()).thenReturn(GameMode.COMPUTER_VS_COMPUTER);
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

        verify(mockedPlayers).announceResult(mockedUi);
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
