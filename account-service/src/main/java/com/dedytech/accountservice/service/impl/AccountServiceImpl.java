package com.dedytech.accountservice.service.impl;

import com.dedytech.accountservice.dto.AccountDto;
import com.dedytech.accountservice.entity.Account;
import com.dedytech.accountservice.exception.EntityNotFoundException;
import com.dedytech.accountservice.exception.ErrorCodes;
import com.dedytech.accountservice.exception.InvalidEntityException;
import com.dedytech.accountservice.repository.AccountRepository;
import com.dedytech.accountservice.service.AccountService;
import com.dedytech.accountservice.validator.AccountValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    public final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto saveAccount(AccountDto accountDto) {
        List<String> errors = AccountValidator.validate(accountDto);
        if (!errors.isEmpty()){
            log.error("Account is not valid {}", accountDto);
            throw new InvalidEntityException("Le compte n'est pas valide", ErrorCodes.ACCOUNT_NOT_VALID, errors);
        }
        return AccountDto.fromEntity(
                accountRepository.save(
                        AccountDto.toEntity(accountDto)
                )
        );
    }

    @Override
    public List<AccountDto> getAllAccount() {
        return accountRepository.findAll().stream()
                .map(AccountDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto getOneAccount(String id) {
        if (id == null){
            log.error("Account ID is null");
            return null;
        }
        return accountRepository.findById(id)
                .map(AccountDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'ID = " + id + "n'a ete trouve dans la BDD",
                        ErrorCodes.ACCOUNT_NOT_FOUND)
                );
    }

    @Override
    public AccountDto updateAccount(String id, AccountDto accountDto) {
        // Vérifier si l'identifiant existe dans la base de données
        Account foundAccount = accountRepository.findById(id).orElse(null);

        if (foundAccount == null) {
            // Gérer le cas où le compte n'existe pas
            throw new EntityNotFoundException(
                    "Le compte avec l'identifiant " + id + " n'existe pas.",
                    ErrorCodes.ACCOUNT_NOT_FOUND);
        }

        // Mettre à jour les informations du compte existant avec les valeurs fournies dans accountDto
//        foundAccount.
        foundAccount.setName(accountDto.getName());
        foundAccount.setEmail(accountDto.getEmail());
        foundAccount.setSurname(accountDto.getSurname());
        foundAccount.setUsername(accountDto.getUsername());
        foundAccount.setPassword(accountDto.getPassword());
        foundAccount.setPhoneNumber(accountDto.getPhoneNumber());
        foundAccount.setDob(accountDto.getDob());
        foundAccount.setAddress1(accountDto.getAddress1());
        foundAccount.setAddress2(accountDto.getAddress2());
        foundAccount.setCity(accountDto.getCity());
        foundAccount.setZip(accountDto.getZip());
        foundAccount.setCountry(accountDto.getCountry());
        foundAccount.setCurrentBalance(accountDto.getCurrentBalance());

        // Enregistrer les modifications dans la base de données
//        Account updatedAccount = accountRepository.save(foundAccount);

        // Convertir le compte mis à jour en DTO et le retourner
//        AccountDto updatedAccountDto = new AccountDto();
//        updatedAccountDto.setId(updatedAccount.getId());
//        updatedAccountDto.setName(updatedAccount.getName());
//        updatedAccountDto.setEmail(updatedAccount.getEmail());

//        return updatedAccountDto;
        return AccountDto.fromEntity(
                accountRepository.save(
                        AccountDto.toEntity(accountDto)
                )
        );
    }

    @Override
    public void deleteAccount(String id) {
        if (id == null){
            log.error("Account ID is null");
            return;
        }
        accountRepository.deleteById(id);
    }
}

