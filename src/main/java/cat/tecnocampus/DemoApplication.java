package cat.tecnocampus;

import cat.tecnocampus.domain.BraveKnight;
import cat.tecnocampus.domain.DamselRescuingKnight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner (BraveKnight braveKnightA, BraveKnight braveKnightB, DamselRescuingKnight damselRescuingKnight) {
		return new CommandLineRunner() {
			@Override
			public void run(String... strings) throws Exception {
				braveKnightA.embarkQuest();

				System.out.println();

				braveKnightB.embarkQuest();

				System.out.println();

				damselRescuingKnight.embarkOnQuest();
			}
		};
	}
}
