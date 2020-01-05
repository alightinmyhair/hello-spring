package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("hello")
public class HelloController {

    //annotation - won't be using ResponseBody after this
    //just return a plain text HTTP response aka not returning a template
    //handles GET requests
    //this entire Method is setup to handle a request handler
    //now lets look at requests from /hello
    //some annotations will accept parameters


    //lives /hello/goodbye
    @GetMapping ("goodbye")
    public String goodbye(){
        return "Goodbye, Spring";
    }

    //live /hello/hello
    //Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method ={RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String hello(@RequestParam String name, Model model){
        String theGreeting = "Hello " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    //Handles requests of the form /hello/{LaunchCode}
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "Hello, " + name+ "!";
    }

    //lives /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }
}
