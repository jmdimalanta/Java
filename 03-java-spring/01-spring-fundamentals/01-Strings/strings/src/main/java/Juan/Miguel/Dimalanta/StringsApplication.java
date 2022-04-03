package Juan.Miguel.Dimalanta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class StringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}
	
	@RequestMapping("/")
	
	public String hello() {
		return "Hello client! How are you doing?";
	}
	
	@RequestMapping("/random")
	
	public String spring() {
		return "Spring Boot is great! So easy to respond with strings";
	}
}
