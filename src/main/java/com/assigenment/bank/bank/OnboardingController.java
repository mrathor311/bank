package com.assigenment.bank.bank;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class OnboardingController {

    private static final String template = "Hello, %s%s%d!";
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/greeting")
public Greeting greeting(
        @RequestParam(value = "rahul")
       String name
){
return new Greeting(counter.incrementAndGet(),String.format("my name is rahulsaxsena "+ template, name,"Muskesh",6));
}


}
