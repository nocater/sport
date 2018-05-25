package sport.web.control;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class LoginCtrl {
	
	/***
	 * 登录
	 * session 写入DEMO
	 * @param name
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(@RequestParam String name,
						@RequestParam String password,
						HttpSession session
						){
		System.out.println(name+" "+password);
		session.setAttribute("LOGIN_ACCOUNT", name);
		return "redirect:/school";
	}
	
	/***
	 * 测试Session获取值
	 * @param LOGIN_ACCOUNT
	 * @return
	 */
	@RequestMapping(value="/logintest")
	public String login_test(@SessionAttribute String LOGIN_ACCOUNT
						){
		System.out.println("已获取Session 中LOGIN_ACCOUNT："+LOGIN_ACCOUNT);
		return "index";
	}
}
