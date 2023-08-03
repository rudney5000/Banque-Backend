package com.dedytech.accountservice.controller;

import com.dedytech.accountservice.controller.api.AccountApi;
import com.dedytech.accountservice.dto.AccountDto;
import com.dedytech.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController implements AccountApi {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    public ResponseEntity<AccountDto> saveAccount(AccountDto accountDto) {
        return ResponseEntity.ok(accountService.saveAccount(accountDto));
    }

    @Override
    public ResponseEntity<List<AccountDto>> getAllAccount() {
        return ResponseEntity.ok(accountService.getAllAccount());
    }

    @Override
    public ResponseEntity<AccountDto> getOneAccount(String id) {
        return ResponseEntity.ok(accountService.getOneAccount(id));
    }

    @Override
    public ResponseEntity<AccountDto> updateAccount(String id, AccountDto accountDto) {
        return ResponseEntity.ok(accountService.updateAccount(id, accountDto));
    }

    @Override
    public void deleteAccount(String id) {
        accountService.deleteAccount(id);
    }
}
