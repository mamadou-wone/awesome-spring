package sn.amir.boss.limitsservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.amir.boss.limitsservice.bean.Limits;
import sn.amir.boss.limitsservice.configuration.Configuration;

@RestController
public class LimitsController {

    private Configuration configuration;

    public LimitsController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public Limits retrieveLimits(){
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }

}
