package othermonkeysoftware.RPS;

import java.util.concurrent.ThreadLocalRandom;

public class Randomiser {

    public int nextInt(int lower, int upper)
    {
        return ThreadLocalRandom.current().nextInt(lower, upper + 1);
    }
}
