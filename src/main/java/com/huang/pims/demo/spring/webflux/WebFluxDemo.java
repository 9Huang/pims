package com.huang.pims.demo.spring.webflux;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/webflux")
public class WebFluxDemo {

    @ResponseBody
    @RequestMapping(value = "/demo01", method = RequestMethod.GET)
    public Mono<String> demo01() {
        return Mono.just("Welcome to reactive world ~");
    }


}
