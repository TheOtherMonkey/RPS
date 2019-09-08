package othermonkeysoftware.RPS;

public class Player {

    private String name;
    private GesturePicker gesturePicker;
    private Gesture lastGesture;

    public Player(String name, GesturePicker gesturePicker)
    {
       this.name = name;
       this.gesturePicker = gesturePicker;
    }

    public void revealGesture(RpsUi ui){
        this.lastGesture.revealFor(name, ui);
    }

    public void announceAsWinner(RpsUi ui) {
        ui.announceWinner(this.name);
        this.lastGesture.announceWon(ui);
    }

    public void announceAsLoser(RpsUi ui){
        this.lastGesture.announceLost(ui);
    }

    public Gesture selectGesture(Gesture[] gestures){
        this.lastGesture = this.gesturePicker.selectGesture(gestures);
        return this.lastGesture;
    }
}
