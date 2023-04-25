package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//a controller annotation tells spring boot that this class is a web controller
// - in other words, it tells spring boot that there are methods in this class that are set up to handle http requests
//the annotation is required for it to work

@Controller
@ResponseBody//returns a plain html text response
@RequestMapping("hello")//this makes it clear that every single request mapping path should begin with /hello
public class HelloController {
//controller handler method
    //the first 3 methods are static (including the commented out one
    //by default (because nothing else is specified) this method lives at the route path localhost:8080/
//    @GetMapping //this method only returns a http get method
//    @ResponseBody //returns a plain html text response
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //the method below handles request at localhost:8080/hello
//    @GetMapping("hello") //specifies the path this handler lives at localhost:8080/hello
//    @ResponseBody //returns a plain html text response
//    public String hello(){
//        return "Hello, Spring!";
//    }
// because of the Request mapping annotation at the top,
    //this lives at /hello/goodbye
    @GetMapping("goodbye") //this method only returns a http get method

    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //the handler below handles request of the form /hello?name=LaunchCode
    //in other words, it takes a query parameter called name with a given value - LaunchCode - and that value should be used in the response
// this is a dynamic handler - that means it accepts data
    //the query parameter name and the method parameter name must match up
// because of the Request mapping annotation at the top,
    //this lives at /hello/hello
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "hello")

    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }
    //handles requests of the form /hello/LaunchCode
    //this means that the url includes the pathparameter
    //name is the variable name - curly brackets & the @PathVariable denote this
//    @GetMapping("hello/{name}")
//    @ResponseBody
//    public String helloWithPathParam(@PathVariable String name){
//        return name;
//    }
// because of the Request mapping annotation at the top,
    //this lives at /hello/form
    @GetMapping("form")

    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +//tells the form to submit the request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
