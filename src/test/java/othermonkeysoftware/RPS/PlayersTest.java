package othermonkeysoftware.RPS;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class PlayersTest {

    private Player mockedPlayer1;
    private Player mockedPlayer2;
    private Gesture mockedPlayer1Gesture;
    private Gesture mockedPlayer2Gesture;
    private Gesture[] validGestures = new Gesture[]{};

    private Players target;

    @Before
    public void setUp() {
        mockedPlayer1 = mock(Player.class);
        mockedPlayer2 = mock(Player.class);
        mockedPlayer1Gesture = mock(Gesture.class);
        mockedPlayer2Gesture = mock(Gesture.class);

        when(mockedPlayer1.selectGesture(validGestures)).thenReturn(mockedPlayer1Gesture);
        when(mockedPlayer2.selectGesture(validGestures)).thenReturn(mockedPlayer2Gesture);

        when(mockedPlayer1Gesture.compare(mockedPlayer2Gesture)).thenReturn(Outcome.DRAW);
        target = new Players(mockedPlayer1, mockedPlayer2);
    }

    @Test
    public void roShamBoShouldNotReturnNull() {
        RpsResult actual = target.roShamBo(validGestures);
        Assert.assertNotNull(actual);
    }

    @Test
    public void roShamBoShouldSelectPlayer1Gesture(){
        target.roShamBo(validGestures);
        verify(mockedPlayer1).selectGesture(validGestures);
    }

    @Test
    public void roShamBoShouldSelectPlayer2Gesture(){
        target.roShamBo(validGestures);
        verify(mockedPlayer2).selectGesture(validGestures);
    }

    @Test
    public void roShamBoShouldCompareGestures(){
        target.roShamBo(validGestures);

        verify(mockedPlayer1Gesture).compare(mockedPlayer2Gesture);
    }
}