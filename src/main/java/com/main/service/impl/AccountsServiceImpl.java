package com.main.service.impl;

import com.main.dto.AccountDto;
import com.main.entity.Account;
import com.main.mapper.AccountMapper;
import com.main.repo.AccountRepository;
import com.main.service.AccountsService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AccountsServiceImpl implements AccountsService {
    private final AccountRepository accountRepository;

    public AccountsServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.MaptoAccount(accountDto);
        Account savedAccount = accountRepository.save(account);


        return AccountMapper.MaptoAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not Found"));
        return AccountMapper.MaptoAccountDto(account);
    }

    @Override
    public AccountDto depositAmount(Long accountId, double amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not Found"));
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        return AccountMapper.MaptoAccountDto(account);
    }

    @Override
    public AccountDto withdrawAmount(Long accountId, double amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not Found"));
        if (account.getBalance() > amount) {
            account.setBalance(account.getBalance() - amount);
            accountRepository.save(account);
        }
        else {
            throw new RuntimeException("Insufficient balance");
        }

        return AccountMapper.MaptoAccountDto(account);
    }
}
