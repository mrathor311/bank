package com.assigenment.bank.bank;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class OnboardingController {

    private static final String template = "Hello, %s%s%d!";
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/greeting")
public Greeting greeting(
        @RequestParam(value = "name")
       String name
)
    {
return new Greeting(counter.incrementAndGet(),String.format("my name is rahulsaxsena "+ template, name,"Muskesh",6));
}
@PostMapping("/login")
    public  LoginResponse loginUser(@RequestBody User user){

      String email  =user.email();
       String pass = user.pass();
        if ( email== null|| email.isEmpty())
            return  new LoginResponse(0,"email id is invlid",null) ;
        if ( pass==null|| pass.isEmpty())
            return new LoginResponse(0," pass in valid",null);

        // database valid entry
    final String name = "ss1@getnada.com";
    final String passw="Aa123456@";
    if (email.equals(name) && pass.equals(passw)){
        return new LoginResponse(1,"success",
                new Login("mukesh","8107776311","ss1@getnada.com"));
    }
    return new LoginResponse(0,"invelid user id and password",null);

    }
public record User( String email, String pass){

}
public  record  LoginResponse(int Status,String Message, Login user
                              ){

}
public  record Login(String name,String Phone,String email){

}
}
