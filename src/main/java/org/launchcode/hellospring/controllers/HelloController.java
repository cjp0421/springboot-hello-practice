package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("hello")
public class HelloController {

//    @GetMapping("goodbye")
//    public String goodbye(){
//        return "Goodbye, Spring!";
//    }

//    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "hello")
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }


    @RequestMapping(value="hello",method = RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String language){
        if (name == null){
            name = "World";
        }
        return createMessage(name, language);
    }

    @RequestMapping(value="message",method = RequestMethod.POST)

    public static String createMessage(@RequestParam String n, @RequestParam String l){
        String greeting = "";
        if(l.equals("english")) {
            greeting = "Hello";
        } else if(l.equals("french")) {
            greeting = "Bonjour";
        } else if(l.equals("italian")) {
            greeting = "Bonjourno";
        }else if(l.equals("spanish")) {
            greeting = "Hola";
        }else if(l.equals("german")) {
            greeting = "Hallo";
        }
        return greeting + " " + n;
    }

    //Springboot assumes the string returned as such in the method below is a template
    //if @ResponseBody isn't there but a string is.
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }
}
