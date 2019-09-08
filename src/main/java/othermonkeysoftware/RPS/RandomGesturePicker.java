package othermonkeysoftware.RPS;

public class RandomGesturePicker extends GesturePicker {

    private Randomiser randomiser;

    public RandomGesturePicker(Randomiser randomiser) {
        this.randomiser = randomiser;
    }

    @Override
    public Gesture selectGesture(Gesture[] gestures) {
        int index = this.randomiser.nextInt(0, gestures.length -1);
        return gestures[index];
    }
}
