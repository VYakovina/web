package ua.yakov.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(types = {CusUser.class})
public class RegConrtroller {

    @Autowired
    LogicDao logicDao;
    @Autowired
    LogValidator logValidator;
    @Autowired
    RegValidator regValidator;

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String getLog (Model model) {
        CusUser user = new CusUser();
        model.addAttribute("loginUser", user);
        return "log";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegForm(Model model) {
        CusUser user = new CusUser();
        model.addAttribute("registrationUser", user);
        return "register";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public ModelAndView doReg(@ModelAttribute("registrationUser") @Validated CusUser cusUser, BindingResult result){
        ModelAndView mod = new ModelAndView();

        if (result.hasErrors()) {
            mod.setViewName("register");
        } else {
            logicDao.Regist(cusUser);
            mod.setViewName("log");

        }
            return mod;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView doLog(@ModelAttribute("loginUser") @Validated CusUser cusUser, BindingResult result){
        ModelAndView mod = new ModelAndView();

        if (result.hasErrors()) {
            mod.setViewName("log");
        } else {
            mod.setViewName("welcome");
        }
        return mod;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getIndex() {
        ModelAndView model = new ModelAndView();
        model.setViewName("start");
        return model;
    }

    @RequestMapping(value = "/protected**", method = RequestMethod.GET)
    public ModelAndView protectedPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("protect");
        return model;
      }


    @InitBinder("loginUser")
    protected void logValidator(WebDataBinder binder) {
          binder.setValidator(this.logValidator); }

    @InitBinder("registrationUser")
    protected void regValidator(WebDataBinder binder) {
        binder.setValidator(this.regValidator); }

}
