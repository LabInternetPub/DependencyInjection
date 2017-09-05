package cat.tecnocampus.domain;

import org.springframework.stereotype.Component;

import java.io.PrintStream;

/**
 * Created by roure on 27/09/2016.
 */
@Component
public class RescueDamselQuest implements Quest {
    private PrintStream stream;

    public RescueDamselQuest(PrintStream stream) {
        this.stream = stream;
    }

    public void embark() {
        stream.println("Damsel rescued");
    }
}
