package com.nalbam.sample.controller;

import com.nalbam.sample.util.PackageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "<p>OK</p>";
    }

    @GetMapping("/live")
    public String live() {
        log.info("live check");
        return "<p>live OK</p>";
    }

    @GetMapping("/read")
    public String read() {
        log.info("read check");
        return "<p>read OK</p>";
    }

    @GetMapping("/spring")
    public String spring() {
        log.info("spring check");
        return "<p>spring OK</p>";
    }

    @GetMapping("/stress")
    public String stress() {
        log.info("stress check");

        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum = sum + i;
        }

        return "<p>stress " + sum + "</p>";
    }

    @GetMapping("/package")
    public Map<String, String> health() {
        return PackageUtil.getData(this.getClass());
    }

}
