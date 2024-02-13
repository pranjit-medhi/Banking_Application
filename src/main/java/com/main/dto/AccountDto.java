package com.main.dto;

public class AccountDto {
    private Long accountId;
    private String accountHolderName;
    private double balance;

    public AccountDto(Long accountId, String accountHolderName, double balance) {
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public AccountDto() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "accountId=" + accountId +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
