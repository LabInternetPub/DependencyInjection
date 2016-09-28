package cat.tecnocampus;

import cat.tecnocampus.domain.BraveKnight;
import cat.tecnocampus.domain.Quest;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by roure on 28/09/2016.
 */
public class BraveKnightTest {
    @Test
    public void knightShouldEmbarkQuest() {
        Quest mockQuest = mock(Quest.class);
        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkQuest();
        verify(mockQuest,times(1)).embark();
    }
}
