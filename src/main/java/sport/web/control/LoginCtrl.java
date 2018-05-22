package sport.web.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginCtrl {

	@RequestMapping(value="/login")
	public String login(@RequestParam String name,
						@RequestParam String password){
		System.out.println(name+" "+password);
		return "login";
	}
}
