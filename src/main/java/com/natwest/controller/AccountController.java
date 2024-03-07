package com.natwest.controller;

import com.natwest.entity.Account;
import com.natwest.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountRepository accountRepository;
    @PostMapping("/account")
    public Account addAccount(@RequestBody Account account){
      return accountRepository.save(account);

    }
    @PostMapping("/accounts")
    public List<Account> addAccounts(@RequestBody List<Account> accounts) {
        List<Account> savedAccounts = accountRepository.saveAll(accounts);
        return savedAccounts;
    }

    @GetMapping("/account")
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
    @GetMapping("/account/{id}")
    public Account getAccountById(@PathVariable int id){
//        Optional<Account> accountOption=accountRepository.findById(id);
        return accountRepository.findById(id).get();
    }
    @PutMapping("/account/{id}")
    public Account updateAccount(@RequestBody Account account,@PathVariable int id){
        if(!accountRepository.existsById(id)){
            System.out.println("No id found");
        }return accountRepository.save(account);
    }
    @DeleteMapping("/account/{id}") // Define the URL path for the DELETE endpoint
    public void deleteById(@PathVariable int id) {
        accountRepository.deleteById(id);
    }
}
