package ord.sid.springMVC;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ord.sid.springMVC.dao.PatientRepository;
import ord.sid.springMVC.entities.Patient;

@SpringBootApplication
public class SpringMvcApplication implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		patientRepository.save(new Patient(null, "Hassan", new Date(), false,6));
		patientRepository.save(new Patient(null, "Ayoub", new Date(), false,8));
		patientRepository.save(new Patient(null, "Sara", new Date(), false,11));

		patientRepository.findAll().forEach(p -> {
			System.out.println(p.getName());
		});
	}

}
