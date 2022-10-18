package uz.bakhromjon.digitalocean;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import uz.bakhromjon.digitalocean.user.Users;
import uz.bakhromjon.digitalocean.user.UserRepository;


@SpringBootApplication
@EnableCaching
@RequiredArgsConstructor
public class Example1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Example1Application.class, args);
	}

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	private final UserRepository userRepository;


	@Override
	public void run(String... strings) {
		LOG.info("Saving users. Current user count is {}.", userRepository.count());
		Users shubham = new Users("Shubham", 2000);
		Users pankaj = new Users("Pankaj", 29000);
		Users lewis = new Users("Lewis", 550);

		userRepository.save(shubham);
		userRepository.save(pankaj);
		userRepository.save(lewis);
		LOG.info("Done saving users. Data: {}.", userRepository.findAll());
	}

}
