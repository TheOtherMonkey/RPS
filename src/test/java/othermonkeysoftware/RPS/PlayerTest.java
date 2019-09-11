package othermonkeysoftware.RPS;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class PlayerTest
{
    private RpsUi mockedUi;
    private GesturePicker mockedPicker;
    private Gesture[] gestures;
    private static String PlayerName = "Some Player Name";
    private Player target;

    @Before
    public void Setup()
    {
        mockedUi = mock(RpsUi.class);
        mockedPicker = mock(GesturePicker.class);
        gestures = new Gesture[]{};

        target = new Player(PlayerName, mockedPicker);
    }

    @Test
    public void revealGesture()
    {
        Gesture mockedGesture = mock(Gesture.class);
        when(mockedPicker.selectGesture(gestures)).thenReturn(mockedGesture);

        target.selectGesture(gestures);
        target.revealGesture(mockedUi);

        verify(mockedGesture).revealFor(PlayerName, mockedUi);
    }

    @Test
    public void selectGestureUsesGesturePicker()
    {
        target.selectGesture(gestures);
        verify(mockedPicker).selectGesture(gestures);
    }

    @Test
    public void selectGestureReturnsSelectedGesture()
    {
        Gesture mockedGesture = mock(Gesture.class);
        when(mockedPicker.selectGesture(gestures)).thenReturn(mockedGesture);

        Gesture actual = target.selectGesture(gestures);

        Assert.assertSame(mockedGesture, actual);
    }
}