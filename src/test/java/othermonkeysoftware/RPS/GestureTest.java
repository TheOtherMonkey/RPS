package othermonkeysoftware.RPS;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GestureTest {

    private RpsUi mockedUi;
    private Gesture target;

    @Before
    public void setUp() {
        mockedUi = mock(RpsUi.class);
        target = new TestGesture();
    }

    @Test
    public void revealFor() {
        String playerName = "Player Name 1";
        target.revealFor(playerName, mockedUi);

        verify(mockedUi).rescribePlayerGesture(playerName, "TEST");
    }
}