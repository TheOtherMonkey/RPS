package othermonkeysoftware.RPS;

public class TestGesture extends Gesture {
    @Override
    protected String getName() {
        return "TEST";
    }

    @Override
    protected String getInputMatchValue() {
        return "T";
    }

    @Override
    protected String getWinningAdjective() {
        return "tests";
    }

    @Override
    public Outcome compare(Gesture player2Gesture) {
        return null;
    }
}
