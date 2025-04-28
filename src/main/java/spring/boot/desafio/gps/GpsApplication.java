package spring.boot.desafio.gps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.boot.desafio.gps.model.poi;
import spring.boot.desafio.gps.repository.poiRepository;

@SpringBootApplication
public class GpsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GpsApplication.class, args);
	}

	@Autowired
	private poiRepository repo;

	@Override
	public void run(String... args) throws Exception {
		repo.save(new poi("Lanchonete", 27L, 12L));
		repo.save(new poi("Posto", 31L, 18L));
		repo.save(new poi("Joalheria", 15L, 12L));
		repo.save(new poi("Floricultura", 19L, 21L));
		repo.save(new poi("Pub", 12L, 8L));
		repo.save(new poi("Supermercado", 23L, 6L));
		repo.save(new poi("Churrascaria", 28L, 2L));
	}
}
