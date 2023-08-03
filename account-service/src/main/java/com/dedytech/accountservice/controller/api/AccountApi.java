package com.dedytech.accountservice.controller.api;

import com.dedytech.accountservice.dto.AccountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("accounts/v1")
public interface AccountApi {

    @PostMapping("/create")
    ResponseEntity<AccountDto> saveAccount(@RequestBody AccountDto accountDto);

    @GetMapping("/all")
    ResponseEntity<List<AccountDto>> getAllAccount();

    @GetMapping("/getOne/{id}")
    ResponseEntity<AccountDto> getOneAccount(@PathVariable ("id") String id);

    @PutMapping("/update/{id}")
    ResponseEntity<AccountDto> updateAccount(@PathVariable ("id") String id, @RequestBody AccountDto accountDto);

    @DeleteMapping("/delete/{id}")
    void deleteAccount(@PathVariable ("id") String id);
}
