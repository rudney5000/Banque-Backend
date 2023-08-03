package com.dedytech.accountservice.service;

import com.dedytech.accountservice.dto.AccountDto;
import com.dedytech.accountservice.entity.Account;

import java.util.List;

public interface AccountService {

    AccountDto saveAccount(AccountDto accountDto);

    List<AccountDto> getAllAccount();

    AccountDto getOneAccount(String id);

    AccountDto updateAccount(String id, AccountDto accountDto);

    void deleteAccount(String id);
}
