package othermonkeysoftware.RPS.Gestures;

import othermonkeysoftware.RPS.Gesture;
import othermonkeysoftware.RPS.Outcome;

public final class RockGesture extends Gesture
{
    @Override
    protected final String getName()
    {
        return "Rock";
    }

    @Override
    protected final String getInputMatchValue()
    {
        return "R";
    }

    @Override
    protected final String getWinningAdjective()
    {
        return "crushes";
    }

    @Override
    public Outcome compare(Gesture player2Gesture)
    {
        if (isGesture(player2Gesture, ScissorsGesture.class)) return Outcome.PLAYER_1_WIN;
        if (isGesture(player2Gesture, PaperGesture.class)) return Outcome.PLAYER_2_WIN;

        return Outcome.DRAW;
    }
}
