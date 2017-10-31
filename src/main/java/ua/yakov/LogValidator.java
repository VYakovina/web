package ua.yakov;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LogValidator implements Validator {

    @Override
    public boolean supports(Class<?> calzz) {
        return CusUser.class.equals(calzz);
    }

    @Override
    public void validate(Object o, Errors errors) {
       LogicDao logicDao = new LogicDao();
       CusUser  cusUser = (CusUser) o;
       if (logicDao.Log(cusUser) == true){
           errors.rejectValue("uname","error.LogExists");
       }

    }
}