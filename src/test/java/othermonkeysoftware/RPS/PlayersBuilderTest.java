package othermonkeysoftware.RPS;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PlayersBuilderTest
{
    private RpsUi mockedUi;

    private PlayersBuilder target;

    @Before
    public void setUp()
    {
        mockedUi = mock(RpsUi.class);

        target = new PlayersBuilder(mock(RandomGesturePicker.class), mock(UiGesturePicker.class));
    }

    @Test
    public void humanVsComputer()
    {
        Players actual = target.humanVsComputer(mockedUi);
        Assert.assertNotNull(actual);
    }

    @Test
    public void humanVsComputerAsksForPlayerName()
    {
        target.humanVsComputer(mockedUi);
        verify(mockedUi).askForPlayerName();
    }

    @Test
    public void computerVsComputer()
    {
        Players actual = target.computerVsComputer();
        Assert.assertNotNull(actual);
    }
}