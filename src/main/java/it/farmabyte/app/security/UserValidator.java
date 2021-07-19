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

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.email");
        if (!user.getEmail().contains("@") || user.getEmail().split(".").length < 0) {
            errors.rejectValue("email", "format.email");
        }
        if (userService.findByUsername(user.getEmail()) != null) {
            errors.rejectValue("email", "duplicate.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.password");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 128) {
            errors.rejectValue("password", "size.password");
        }
        boolean num = false, c = true;
        for (int i = 0; i < user.getPassword().length(); i++) {
            if (Character.isAlphabetic(user.getPassword().charAt(i)))
                c = true;
            if (Character.isDigit(user.getPassword().charAt(i)))
                num = true;
        }
        if (!c || !num)
            errors.rejectValue("password", "chars.password");
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "diff.password");
        }
        //Non so perchè non funzioni
/*      Calendar cal = Calendar.getInstance();
        System.out.println(user.getDataDiNascita());
        cal.setTime(user.getDataDiNascita());
        cal.add(Calendar.YEAR, 16);
        System.out.println(cal.getTime());
        if(cal.getTime().after(Calendar.getInstance().getTime()))
            errors.rejectValue("username", "minor.date"); */
    }
}