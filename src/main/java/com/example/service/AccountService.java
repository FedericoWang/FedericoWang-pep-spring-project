package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Integer id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        return optionalAccount.orElse(null);
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(Integer id, Account account) {
        if (accountRepository.existsById(id)) {
            return accountRepository.save(account);
        }
        return null;
    }

    public void deleteAccount(Integer id) {
        accountRepository.deleteById(id);
    }

    public Account getAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
    
    public Account authenticate(String username, String password) {
        Account account = getAccountByUsername(username);
        if (account != null && account.getPassword().equals(password)) {
            return account;
        }
        return null;
    }

}