package othermonkeysoftware.RPS;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RandomGesturePickerTest
{
    private Randomiser mockedRandomiser;
    private RandomGesturePicker target;

    @Before
    public void Setup()
    {
        mockedRandomiser = mock(Randomiser.class);
        target = new RandomGesturePicker(mockedRandomiser);
    }

    @Test
    public void selectGesture()
    {
        Gesture expected = mock(Gesture.class);
        Gesture[] gestures = new Gesture[] {
                mock(Gesture.class),
                mock(Gesture.class),
                expected,
                mock(Gesture.class)
        };

        when(mockedRandomiser.nextInt(0, 3)).thenReturn(2);
        Gesture actual = target.selectGesture(gestures);
        Assert.assertSame(expected, actual);
    }
}
