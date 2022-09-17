package sn.amir.boss.restfullwebservices.helloword;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWordController {

    @RequestMapping(method = RequestMethod.GET, path ="/hello-word")
    public String hello(){
        return "Hello Word :)";
    }

    @RequestMapping(method = RequestMethod.GET, path ="/hello")
    public HelloWordBean helloWordBean(){
        return new HelloWordBean("Hello Word Bean :)");
    }

    @RequestMapping(method = RequestMethod.GET, path ="/hello-word/{name}")
    public HelloWordBean helloWordPathVariable(@PathVariable String name){
        return new HelloWordBean(String.format("Hello Word, %s ", name));
    }

}
