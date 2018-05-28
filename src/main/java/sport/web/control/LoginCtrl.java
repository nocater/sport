package sport.web.control;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import sport.bean.Account;
import sport.service.account.AccountService;

@Controller
public class LoginCtrl {
	@Autowired
	private AccountService accountService;
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
						HttpSession session,
						ModelMap model
						){
		System.out.println(name+"/"+password);
		Account account = accountService.login(name, password);
		if(account!=null){
			session.setAttribute("LOGIN_ACCOUNT", account);
			return "redirect:/school";
		}else{
			model.addAttribute("message", "登录失败");
			System.out.println(name+"登录失败！");
			return "login";
		}
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
