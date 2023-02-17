package com.example.andreyshop.web;

import com.example.andreyshop.domein.models.bindings.UserLoginModel;
import com.example.andreyshop.domein.models.bindings.UserRegisterModel;
import com.example.andreyshop.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @GetMapping("/register")
    public String getRegister(){
        return "register";
    }
    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute(name = "userRegisterModel") UserRegisterModel userRegisterModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterModel", userRegisterModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterModel",
                            bindingResult);
            return "redirect:register";
        }

        this.authService.registerUser(userRegisterModel);
        return "redirect:login";
    }
    @GetMapping("/login")
    public String getLogin(){
        return"login";
    }

    @PostMapping("/login")
    public String postLogin(@Valid @ModelAttribute(name = "userLoginModel") UserLoginModel userLoginModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginModel", userLoginModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginModel",
                            bindingResult);
            return "redirect:login";
        }

//        this.authService.loginUser(userLoginModel);
        this.authService.loginUser(userLoginModel);

        return "redirect:/";

    }
    @GetMapping("/logout")
    public String getLogout() {
        this.authService.logoutUser();
        return "redirect:/";
    }

    @ModelAttribute(name = "userLoginModel")
    public UserLoginModel userLoginModel(){
        return new UserLoginModel();
    }

    @ModelAttribute(name = "userRegisterModel")
    public UserRegisterModel userRegisterModel(){
        return new UserRegisterModel();

    }
}
