package cat.tecnocampus.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by roure on 27/09/2016.
 */
@Component
public class BraveKnight {
    private Quest quest;
    private String me = "Default name";

    @Autowired
    public BraveKnight(Quest slayDragonQuest) {
        this.quest = slayDragonQuest;
    }

    public BraveKnight(Quest quest, String me) {
        this.quest = quest;
        this.me = me;
    }

    public void embarkQuest() {
        System.out.println("Hi, this is  " + me);
        quest.embark();
    }
}
