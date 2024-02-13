package com.main.service;

import com.main.dto.AccountDto;
import com.main.entity.Account;

public interface AccountsService {

    AccountDto createAccount(AccountDto accounts );
    AccountDto getAccountById(Long accountId);
    AccountDto depositAmount(Long accountId, double amount);
    AccountDto withdrawAmount(Long accountId, double amount);
}
