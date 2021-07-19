package it.farmabyte.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.services.UtenteService;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UtenteService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return ClienteRegistrato.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ClienteRegistrato user = (ClienteRegistrato) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getEmail().contains("@") && user.getEmail().split(".").length > 0) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getEmail()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 128) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        boolean num = false, c = true;
        for (int i = 0; i < user.getPassword().length(); i++) {
            if (Character.isAlphabetic(user.getPassword().charAt(i)))
                c = true;
            if (Character.isDigit(user.getPassword().charAt(i)))
                num = true;
        }
        if (!c || !num)
            errors.rejectValue("password", "Chars.userForm.password");
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}