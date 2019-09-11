package othermonkeysoftware.RPS;

public abstract class  Gesture
{
    protected abstract String getName();
    protected abstract String getInputMatchValue();
    protected abstract String getWinningAdjective();

    public void describeSelf(RpsUi ui)
    {
        ui.describeGesture(getName(), getInputMatchValue());
    }

    public boolean matchesInput(String userInput)
    {
        boolean result = userInput.equalsIgnoreCase(getInputMatchValue());
        return result;
    }

    public void revealFor(String playerName, RpsUi ui)
    {
        ui.describePlayerGesture(playerName, getName());
    }

    public abstract Outcome compare(Gesture player2Gesture);

    protected boolean isGesture(Gesture gesture, Class<?> gestureClass)
    {
        return gesture.getClass().isAssignableFrom(gestureClass);
    }

    public void announceWon(RpsUi ui)
    {
        ui.describeWinningGesture(getName(), getWinningAdjective());
    }

    public void announceLost(RpsUi ui)
    {
        ui.describeLosingGesture(getName());
    }
}
