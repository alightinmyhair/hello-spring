package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
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
    public String helloWithQueryParam(@RequestParam String language, @RequestParam String name){
        return  language +" "+ name + "!";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name+ "!";
    }

    //lives /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'>" +
                "<select name = 'language'>" +
                "<option value = 'Bonjour'>French</option>" +
                "<option value = 'Hola'>Spanish</option>" +
                "<option value = 'Konichiwa'>Japanese</option>" +
                "<input type='submit' value='Greet me!'>" +
                "</select" +
                "</form>" +
                "</body" +
                "</html>";
    }
}
