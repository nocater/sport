package sport.service.account.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sport.bean.Account;
import sport.dao.AccountMapper;
import sport.service.account.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public Account login(String name, String password) {
		// TODO Auto-generated method stub
		Account account = new Account();
		account.setName(name);
		account.setPassword(password);
		return accountMapper.login(account);
	}

}
