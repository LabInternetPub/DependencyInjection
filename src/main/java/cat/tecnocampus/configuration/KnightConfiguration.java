package cat.tecnocampus.configuration;

import cat.tecnocampus.domain.BraveKnight;
import cat.tecnocampus.domain.Quest;
import cat.tecnocampus.domain.SlayDragonQuest;
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
    public BraveKnight braveKnight() {
        return new BraveKnight(quest(), "AAAA");
    }

    @Bean
    public BraveKnight braveKnightB() {
        return new BraveKnight(quest(), "BBBB");
    }


    @Bean
    Quest quest() {
        return new SlayDragonQuest(System.out);
    }
}