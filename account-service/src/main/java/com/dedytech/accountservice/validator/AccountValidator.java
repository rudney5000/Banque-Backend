package com.dedytech.accountservice.validator;

import com.dedytech.accountservice.dto.AccountDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AccountValidator {

    public static List<String> validate(AccountDto accountDto){
        List<String> errors = new ArrayList<>();

        if (accountDto == null) {
            errors.add("Veuillez renseigner votre name de compte");
            errors.add("Veuillez renseigner votre surname de compte");
            errors.add("Veuillez renseigner votre email de compte");
            errors.add("Veuillez renseigner votre password de compte");
            errors.add("Veuillez renseigner votre city de compte");
            errors.add("Veuillez renseigner votre phoneNumber de compte");
            errors.add("Veuillez renseigner votre dob de compte");
            return errors;
        }

        if (!StringUtils.hasLength((accountDto.getName()))){
            errors.add("Veuillez renseigner votre name de compte");
        }
        if (!StringUtils.hasLength((accountDto.getSurname()))){
            errors.add("Veuillez renseigner votre surname de compte");
        }
        if (!StringUtils.hasLength((accountDto.getEmail()))){
            errors.add("Veuillez renseigner votre email de compte");
        }
        if (!StringUtils.hasLength((accountDto.getPassword()))){
            errors.add("Veuillez renseigner votre mot de passe de compte");
        }
        if (!StringUtils.hasLength((accountDto.getPhoneNumber()))){
            errors.add("Veuillez renseigner votre numero de telephone de compte");
        }
        if (!StringUtils.hasLength((accountDto.getDob()))){
            errors.add("Veuillez renseigner votre date de naissance de compte");
        }
        if(!StringUtils.hasLength((accountDto.getAddress1()))){
            errors.add("le champs de l'addresse 1 est obligatoire");
        }
        if(!StringUtils.hasLength((accountDto.getAddress2()))){
            errors.add("le champs de l'addresse 2 est obligatoire");
        }
        if(!StringUtils.hasLength((accountDto.getZip()))){
            errors.add("le champs code postale est obligatoire");
        }
        if(!StringUtils.hasLength((accountDto.getCity()))){
            errors.add("le champs city est obligatoire");
        }
        if(!StringUtils.hasLength((accountDto.getCountry()))){
            errors.add("le champs pays est obligatoire");
        }
        return errors;
    }
}
