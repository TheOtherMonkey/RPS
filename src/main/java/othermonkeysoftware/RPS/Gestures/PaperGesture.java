package othermonkeysoftware.RPS.Gestures;

import othermonkeysoftware.RPS.Gesture;
import othermonkeysoftware.RPS.Outcome;

public class PaperGesture extends Gesture {
    @Override
    protected String getName() {
        return "Paper";
    }

    @Override
    protected String getInputMatchValue() {
        return "P";
    }

    @Override
    protected String getWinningAdjective() {
        return "wraps";
    }

    @Override
    public Outcome compare(Gesture player2Gesture) {
        if (isGesture(player2Gesture, RockGesture.class)) return Outcome.PLAYER_1_WIN;
        if (isGesture(player2Gesture, ScissorsGesture.class)) return Outcome.PLAYER_2_WIN;

        return Outcome.DRAW;
    }
}
