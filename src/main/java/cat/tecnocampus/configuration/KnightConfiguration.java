package cat.tecnocampus.configuration;

import cat.tecnocampus.domain.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by roure on 28/09/2016.
 */
@Configuration
public class KnightConfiguration {

    @Bean
    public BraveKnight braveKnightA(Quest questDragon) {
        return new BraveKnight(questDragon, "AAAA");
    }

    @Bean
    public BraveKnight braveKnightB(Quest questDamsel) {
        return new BraveKnight(questDamsel, "BBBB");
    }

    @Bean
    public DamselRescuingKnight damselRescuingKnight(RescueDamselQuest questDamsel) {
        return new DamselRescuingKnight(questDamsel);
    }

    @Bean
    public Quest questDragon() {
        return new SlayDragonQuest(System.out);
    }

    @Bean
    public Quest questDamsel() {
        return new RescueDamselQuest(System.out);
    }
}
