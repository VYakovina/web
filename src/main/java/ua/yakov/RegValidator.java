package ua.yakov;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegValidator implements Validator {
    @Override
    public boolean supports(Class<?> calzz) {
        return CusUser.class.equals(calzz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LogicDao logicDao = new LogicDao();
        CusUser  cusUser = (CusUser) o;
        if ( logicDao.RegLog(cusUser) == false) {
            errors.rejectValue("uname","error.RegLogExists");
        }

    }
}