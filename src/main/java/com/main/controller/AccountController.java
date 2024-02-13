package com.main.controller;

import com.main.dto.AccountDto;
import com.main.service.AccountsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/bank")
public class AccountController {

    private final AccountsService accountsService;

    public AccountController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto)
    {
        AccountDto account = accountsService.createAccount(accountDto);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> findAccountById(@PathVariable Long id)
    {
        AccountDto accountById = accountsService.getAccountById(id);
        return new ResponseEntity<>(accountById, HttpStatus.OK);
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> depositAmount(@PathVariable Long id, @RequestBody Map<String, Double> amountRequest)
    {
        AccountDto updatedAccount = accountsService.depositAmount(id, amountRequest.get("amount"));
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdrawAmount(@PathVariable Long id, @RequestBody Map<String, Double> amountRequest)
    {
        AccountDto updatedAccount = accountsService.withdrawAmount(id, amountRequest.get("amount"));
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }
}

