package othermonkeysoftware.RPS.Gestures;

import othermonkeysoftware.RPS.Gesture;
import othermonkeysoftware.RPS.Outcome;

public final class ScissorsGesture extends Gesture
{
    @Override
    protected final String getName()
    {
        return "Scissors";
    }

    @Override
    protected final String getInputMatchValue()
    {
        return "S";
    }

    @Override
    protected final String getWinningAdjective()
    {
        return "cuts";
    }

    @Override
    public Outcome compare(Gesture player2Gesture)
    {
        if (isGesture(player2Gesture, PaperGesture.class)) return Outcome.PLAYER_1_WIN;
        if (isGesture(player2Gesture, RockGesture.class)) return Outcome.PLAYER_2_WIN;

        return Outcome.DRAW;
    }
}
