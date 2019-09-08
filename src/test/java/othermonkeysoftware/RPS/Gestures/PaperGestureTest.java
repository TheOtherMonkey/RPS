package othermonkeysoftware.RPS.Gestures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import othermonkeysoftware.RPS.Gesture;
import othermonkeysoftware.RPS.Outcome;

public class PaperGestureTest {

    private PaperGesture target;

    @Before
    public void setUp(){
        this.target = new PaperGesture();
    }


    @Test
    public void comparePaperShouldBeatRock() {
        Outcome expected = Outcome.PLAYER_1_WIN;

        Gesture player2Gesture = new RockGesture();
        Outcome actual = target.compare(player2Gesture);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void comparePaperShouldLoseToScissors() {
        Outcome expected = Outcome.PLAYER_2_WIN;

        Gesture player2Gesture = new ScissorsGesture();
        Outcome actual = target.compare(player2Gesture);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void comparePaperShouldDrawWithPaper() {
        Outcome expected = Outcome.DRAW;

        Gesture player2Gesture = new PaperGesture();
        Outcome actual = target.compare(player2Gesture);

        Assert.assertEquals(expected, actual);
    }
}
