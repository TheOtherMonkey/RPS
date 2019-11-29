package othermonkeysoftware.RPS;

public class Player
{
    private final String name;
    private final GesturePicker gesturePicker;
    private Gesture lastGesture;

    public Player(String name, GesturePicker gesturePicker)
    {
       this.name = name;
       this.gesturePicker = gesturePicker;
    }

    public Gesture revealGesture(RpsUi ui)
    {
        ui.describePlayerGesture(name, this.lastGesture.getName());
        return this.lastGesture;
    }

    public void announceAsWinner(RpsUi ui)
    {
        ui.announceWinner(this.name);
    }

    public void selectGesture(Gesture[] gestures)
    {
        this.lastGesture = this.gesturePicker.selectGesture(gestures);
    }
}