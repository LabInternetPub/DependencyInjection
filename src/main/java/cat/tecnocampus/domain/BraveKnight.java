package cat.tecnocampus.domain;

/**
 * Created by roure on 27/09/2016.
 */
public class BraveKnight {
    private Quest quest;
    private String me;

    public BraveKnight(Quest quest) {
        this.quest = quest;
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
