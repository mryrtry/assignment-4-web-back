package org.mryrt.web.Auth.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.mryrt.web.Auth.Annotation.Username;
import org.mryrt.web.Auth.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UsernameValidator implements ConstraintValidator<Username, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (userRepository.existsByUsername(username)) {
            context.buildConstraintViolationWithTemplate("Username: %s is already in use".formatted(username))
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            return false;
        }
        return true;
    }

}