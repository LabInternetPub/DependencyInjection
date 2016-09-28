package cat.tecnocampus.domain;

import java.io.PrintStream;

/**
 * Created by roure on 27/09/2016.
 */
public class SlayDragonQuest implements Quest {
    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void embark() {
        stream.println("Dragon eliminated");
    }
}
