package othermonkeysoftware.RPS;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class UiGesturePickerTest
{
    private RpsUi mockedUi;

    private UiGesturePicker target;

    @Before
    public void setUp()
    {
        mockedUi = mock(RpsUi.class);
        target = new UiGesturePicker(mockedUi);

        validateMockitoUsage();
    }

    @Test
    public void selectGestureShouldUseUi()
    {
        Gesture[] gestures = new Gesture[]{};

        target.selectGesture(gestures);

        verify(mockedUi).askForPlayerGesture(gestures);
    }

    @Test
    public void selectGestureShouldNotBeNull()
    {
        Gesture[] gestures = new Gesture[]{};

        when(mockedUi.askForPlayerGesture(gestures)).thenReturn(mock(Gesture.class));
        Gesture actual = target.selectGesture(gestures);

        Assert.assertNotNull(actual);
    }

    @Test
    public void selectGesture()
    {
        Gesture[] gestures = new Gesture[]{};

        Gesture expected = mock(Gesture.class);
        when(mockedUi.askForPlayerGesture(gestures)).thenReturn(expected);
        Gesture actual = target.selectGesture(gestures);

        Assert.assertSame(expected, actual);
    }
}