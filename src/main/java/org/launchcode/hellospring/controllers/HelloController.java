package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
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
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language){
        if (name == null){
            name = "World";
        }
        return createMessage(name, language);
    }

    @RequestMapping(value="message",method = RequestMethod.POST)
    @ResponseBody
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

    @GetMapping("form")
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +//tells the form to submit the request to /hello
                "<input type='text' name='name'>" +
                "<select name='language' id='language'>" +

                "<option value='french'>French</option>" +
                "<option value='german'>German</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='italian'>Italian</option>" +
                "<option value='english'>English</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
