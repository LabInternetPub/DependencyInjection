package cat.tecnocampus.domain;

import java.io.PrintStream;

/**
 * Created by roure on 27/09/2016.
 */
public class DamselRescuingKnight {
    private RescueDamselQuest quest;

    public DamselRescuingKnight() {
        quest = new RescueDamselQuest(System.out);
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
