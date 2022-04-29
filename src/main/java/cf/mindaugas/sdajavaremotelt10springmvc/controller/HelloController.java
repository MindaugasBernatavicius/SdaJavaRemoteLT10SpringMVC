package cf.mindaugas.sdajavaremotelt10springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    // Returns the hello.html, not a string.
    @RequestMapping("/")
    public String greeting(Model model, @RequestParam(required = false) String name){
        model.addAttribute("name_in_view", name);
//        return "index.html"; // return the view by name
        return "index"; // return the view by name
    }
}
