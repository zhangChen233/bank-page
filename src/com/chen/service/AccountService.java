package com.chen.service;

import java.io.IOException;

import com.chen.pojo.Account;

public interface AccountService {
	
	/**
	 * 账号密码不匹配-----状态码
	 */
	int ACCOUNT_PASSWORD_NOT_MATCH=1;
	
	/**
	 * 余额不足
	 */
	int ACCOUNT_BALANCE_NOT_ENOUGH=2;
	
	/**
	 * 账户和姓名不匹配
	 */
	int ACCOUNT_NAME_NOT_MATCH=3;
	
	/**
	 * 提交失败
	 */
	int ERROR = 4;
	/**
	 * 提交成功
	 */
	int SUCCESS = 5;
	
	/**
	 * 转账
	 * @param accIn
	 * @param accOut
	 * @return
	 */
	int transfer(Account accIn,Account accOut)throws IOException;

}
