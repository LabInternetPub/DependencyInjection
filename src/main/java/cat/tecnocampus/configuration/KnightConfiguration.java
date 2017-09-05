package cat.tecnocampus.configuration;

import cat.tecnocampus.domain.BraveKnight;
import cat.tecnocampus.domain.DamselRescuingKnight;
import cat.tecnocampus.domain.Quest;
import cat.tecnocampus.domain.SlayDragonQuest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by roure on 28/09/2016.
 */
@Configuration
@ComponentScan("cat.tecnocampus.domain")
public class KnightConfiguration {

}
