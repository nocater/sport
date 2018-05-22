package sport.web.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value="/school")
public class SchoolCtrl {
	/***
	 * info
	 * @return
	 */
	@RequestMapping("/info")
	public String index(){
		return "/school/schoolinfo";
	}
}
