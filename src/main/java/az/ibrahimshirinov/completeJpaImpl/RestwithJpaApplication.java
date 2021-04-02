package az.ibrahimshirinov.completeJpaImpl;

import az.ibrahimshirinov.RestwithJpa.folksdev.model.Car;
import az.ibrahimshirinov.RestwithJpa.folksdev.model.Owner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class RestwithJpaApplication implements CommandLineRunner {




	public static void main(String[] args) {
		SpringApplication.run(RestwithJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Car car = new Car();
		car.setModel("BMW");
		List<Car> cars= new ArrayList<>();
		cars.add(car);

		Owner owner = new Owner();
		owner.setName("ibrahim");
		owner.setSurname("shirinov");
		owner.setCars(cars);





	}
}
