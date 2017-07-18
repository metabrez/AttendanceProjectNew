package edu.mum.cs.projects.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

/*    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout, Model model) {

       *//* if (error != null) {

            model.addAttribute("error", "Invalid UserName and Password");
        }
        if (logout != null) {
            model.addAttribute("error", "You have been logout successfully");
        }*//*


        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout, Model model) {

        if (error != null) {

            model.addAttribute("error", "Invalid UserName and Password");
        }
        if (logout != null) {
            model.addAttribute("error", "You have been logout successfully");
        }


        return "login";
    }*/
}
