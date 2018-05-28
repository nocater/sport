package sport.service.account;

import sport.bean.Account;

public interface AccountService {
	
	Account login(String name, String password);
}
