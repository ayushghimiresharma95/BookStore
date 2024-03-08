package fi.haagaHelia.BookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagaHelia.BookStore.Domain.SignupForm;
import fi.haagaHelia.BookStore.Domain.User;
import fi.haagaHelia.BookStore.Domain.UserRepository;
import jakarta.validation.Valid;

public class UserConroller {
    @Autowired
    private UserRepository repositary;

    @RequestMapping(value = "signup")
    public String addStudent(Model model){
        model.addAttribute("signupform", new SignupForm() );
        return "signup";
    }

    @PostMapping("savuser")
    public String save(@Valid @ModelAttribute("/signupform") SignupForm signupform,BindingResult  bindingResult){
        System.out.println(bindingResult.toString()) ;

        if (!bindingResult.hasErrors()){
            if(signupform.getPassword().equals(signupform.getPasswordCheck())){
                String pwd = signupform.getPassword();
                BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
                String hashPwd = bc.encode(pwd);

                User newUser = new User() ;
                newUser.setPasswordHash(hashPwd);
                newUser.setUsername(signupform.getUsername());
                newUser.setRole("User");

                if (repositary.findByUsername(signupform.getUsername()) == null){
                    repositary.save(
                        newUser
                    );
                }
                else{
                    bindingResult.rejectValue("passwordCheck", "error.pwdmatch","Passwords does not match");
                    return "signup" ;
                }
            }
            else{
                bindingResult.rejectValue("passwordCheck", "error.pwdmatch","Passwords does not match");
                return "signup" ;
            }
        }
        else {
            return "singup" ;
        }
        return "redirect:/login" ;
    }
}
