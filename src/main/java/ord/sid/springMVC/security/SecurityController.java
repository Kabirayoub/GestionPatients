package ord.sid.springMVC.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

	@GetMapping("/NotAuthorized")
	public String error() {
		return "NotAuthorized";
	}

}
