package othermonkeysoftware.RPS;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GestureTest
{
    private RpsUi mockedUi;
    private Gesture target;

    @Before
    public void setUp()
    {
        mockedUi = mock(RpsUi.class);
        target = new TestGesture();
    }

    @Test
    public void describeSelf()
    {
        target.describeSelf(mockedUi);
        verify(mockedUi).describeGesture("TEST", "T");
    }

    @Test
    public void matchesInputLowerCaseT()
    {
        Boolean actual = target.matchesInput("t");
        Assert.assertTrue(actual);
    }

    @Test
    public void matchesInputUpperCaseT()
    {
        Boolean actual = target.matchesInput("T");
        Assert.assertTrue(actual);
    }

    @Test
    public void matchesInputFalse()
    {
        Boolean actual = target.matchesInput("X");
        Assert.assertFalse(actual);
    }
}