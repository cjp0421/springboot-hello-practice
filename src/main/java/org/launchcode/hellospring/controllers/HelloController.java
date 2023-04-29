package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody//returns a plain html text response
@RequestMapping("hello")//this makes it clear that every single request mapping path should begin with /hello
public class HelloController {

// because of the Request mapping annotation at the top,
    //this lives at /hello/goodbye
    @GetMapping("goodbye") //this method only returns a http get method

    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //this lives at /hello/hello
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "hello")

    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

// because of the Request mapping annotation at the top,
    //this lives at /hello/form
    @GetMapping("form")

    public String helloForm(){
        return "form";
    }
}
