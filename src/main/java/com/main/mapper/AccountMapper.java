package com.main.mapper;

import com.main.dto.AccountDto;
import com.main.entity.Account;

public class AccountMapper {
    public static Account MaptoAccount(AccountDto accountDto) {
        Account account = new Account();
        account.setAccountId(accountDto.getAccountId());
        account.setAccountHolderName(accountDto.getAccountHolderName());
        account.setBalance(accountDto.getBalance());
        return account;
    }

    public static AccountDto MaptoAccountDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(account.getAccountId());
        accountDto.setAccountHolderName(account.getAccountHolderName());
        accountDto.setBalance(account.getBalance());
        return accountDto;
    }
}