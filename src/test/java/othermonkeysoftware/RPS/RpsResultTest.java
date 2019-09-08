package othermonkeysoftware.RPS;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RpsResultTest {

    private Player mockedPlayer1;
    private Player mockedPlayer2;
    private RpsUi mockedUi;

    private RpsResult target;

    @Before
    public void setUp(){
        mockedPlayer1 = mock(Player.class);
        mockedPlayer2 = mock(Player.class);
        mockedUi = mock(RpsUi.class);

        validateMockitoUsage();
    }

    @Test
    public void announceWinnerShouldRevealPlayer1Gesture(){
        target = new RpsResult(mockedPlayer1, mockedPlayer2, Outcome.DRAW);

        target.announceWinner(mockedUi);
        verify(mockedPlayer1).revealGesture(mockedUi);
    }

    @Test
    public void announceWinnerShouldRevealPlayer2Gesture(){
        target = new RpsResult(mockedPlayer1, mockedPlayer2, Outcome.DRAW);

        target.announceWinner(mockedUi);
        verify(mockedPlayer2).revealGesture(mockedUi);
    }

    @Test
    public void announceWinnerWhenPlayer1WinsShouldAnnouncePlayer1Winner()
    {
        target = new RpsResult(mockedPlayer1, mockedPlayer2, Outcome.PLAYER_1_WIN);

        target.announceWinner(mockedUi);
        verify(mockedPlayer1).announceAsWinner(mockedUi);
    }

    @Test
    public void announceWinnerWhenPlayer2WinsShouldAnnouncePlayer2Winner()
    {
        target = new RpsResult(mockedPlayer1, mockedPlayer2, Outcome.PLAYER_2_WIN);

        target.announceWinner(mockedUi);
        verify(mockedPlayer2).announceAsWinner(mockedUi);
    }

    @Test
    public void announceWinnerWhenDrawShouldAnnounceDraw()
    {
        target = new RpsResult(mockedPlayer1, mockedPlayer2, Outcome.PLAYER_2_WIN);

        target.announceWinner(mockedUi);
        verify(mockedUi).announceDraw();
    }
}
