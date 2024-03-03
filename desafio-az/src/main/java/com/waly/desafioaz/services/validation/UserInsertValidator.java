package com.waly.desafioaz.services.validation;

import java.util.ArrayList;
import java.util.List;

import com.waly.desafioaz.dtos.ClientDTO;
import com.waly.desafioaz.entities.Client;
import com.waly.desafioaz.exceptions.FieldMessage;
import com.waly.desafioaz.repositories.Clientrepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;


public class UserInsertValidator implements ConstraintValidator<UserInsertValid, ClientDTO> {

    @Autowired
    private Clientrepository userRepository;
    @Override
    public void initialize(UserInsertValid ann) {
    }

    @Override
    public boolean isValid(ClientDTO dto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        Client client = userRepository.findByEmail(dto.getEmail());
        if(client != null){
            list.add(new FieldMessage("Email", "Email ja cadastrado"));
        }
        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}