package pl.silnepalce.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping({"/", "", "index", "index.html"})
    public String index() {
        System.out.println("index message");
        return "index";

    }
    @RequestMapping({"/oups"})
    public String oupsHandler() {
//        System.out.println("index message");
        return "notimplemented";

    }
}
