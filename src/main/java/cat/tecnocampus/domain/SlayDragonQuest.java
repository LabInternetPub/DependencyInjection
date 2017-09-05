package cat.tecnocampus.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

/**
 * Created by roure on 27/09/2016.
 */
@Component
public class SlayDragonQuest implements Quest {
    private PrintStream stream;

    public SlayDragonQuest() {
        stream = System.out;
    }

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void embark() {
        stream.println("Dragon eliminated");
    }
}
