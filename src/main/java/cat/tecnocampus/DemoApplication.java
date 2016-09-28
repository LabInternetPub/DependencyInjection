package cat.tecnocampus;

import cat.tecnocampus.domain.BraveKnight;
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
	CommandLineRunner runner (BraveKnight braveKnight) {
		return new CommandLineRunner() {
			@Override
			public void run(String... strings) throws Exception {
				braveKnight.embarkQuest();
			}
		};
	}
}
