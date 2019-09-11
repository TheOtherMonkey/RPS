package othermonkeysoftware.RPS;

public class UiGesturePicker extends GesturePicker
{
    private final RpsUi ui;

    public UiGesturePicker(RpsUi ui)
    {
        this.ui = ui;
    }

    @Override
    public Gesture selectGesture(Gesture[] gestures)
    {
        return this.ui.askForPlayerGesture(gestures);
    }
}
