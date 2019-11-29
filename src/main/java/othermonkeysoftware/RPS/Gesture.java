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
        return userInput.equalsIgnoreCase(getInputMatchValue());
    }

    public abstract Outcome compare(Gesture player2Gesture);

    protected boolean isGesture(Gesture gesture, Class<?> gestureClass)
    {
        return gesture.getClass().isAssignableFrom(gestureClass);
    }
}
