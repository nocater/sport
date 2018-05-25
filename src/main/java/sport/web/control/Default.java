package sport.web.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Default {
	/***
	 * login
	 * @return
	 */
	@RequestMapping("/")
	public String index(){
		return "login";
	}
}
