package sport.web.control;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sport.bean.Account;

@Controller
public class DefaultCtrl {
	/***
	 * login
	 * @return
	 */
	@RequestMapping("/")
	public String index(HttpSession session){
		Account account = (Account) session.getAttribute("LOGIN_ACCOUNT");
		if(account == null) return "login";
		else return "index";
	}
}
