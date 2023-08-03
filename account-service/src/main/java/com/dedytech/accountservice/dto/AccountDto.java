package com.dedytech.accountservice.dto;

import com.dedytech.accountservice.entity.Account;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AccountDto {

    private String id;

    private String username;

    private String name;

    private String surname;

    private String email;

    private String password;

    private String phoneNumber;

    private String dob;

    private String address1;

    private String address2;

    private String city;

    private String zip;

    private String country;

    private String currentBalance;

    public static AccountDto fromEntity(Account account){
        if(account == null){
            return null;
        }

        return AccountDto.builder()
                .id(account.getId())
                .name(account.getName())
                .surname(account.getSurname())
                .username(account.getUsername())
                .email(account.getEmail())
                .password(account.getPassword())
                .phoneNumber(account.getPhoneNumber())
                .dob(account.getDob())
                .address1(account.getAddress1())
                .address2(account.getAddress2())
                .city(account.getCity())
                .zip(account.getZip())
                .country(account.getCountry())
                .currentBalance(account.getCurrentBalance())
                .build();
    }

    public static Account toEntity(AccountDto accountDto){
        if (accountDto == null){
            return null;
        }
        Account account = new Account();
        account.setName(accountDto.getName());
        account.setSurname(accountDto.getSurname());
        account.setUsername(accountDto.getUsername());
        account.setEmail(accountDto.getEmail());
        account.setPassword(accountDto.getPassword());
        account.setPhoneNumber(account.getPhoneNumber());
        account.setDob(accountDto.getDob());
        account.setAddress1(accountDto.getAddress1());
        account.setAddress2(accountDto.getAddress2());
        account.setCity(accountDto.getCity());
        account.setZip(accountDto.getZip());
        account.setCountry(accountDto.getCountry());
        account.setCurrentBalance(account.getCurrentBalance());

        return account;
    }
}
