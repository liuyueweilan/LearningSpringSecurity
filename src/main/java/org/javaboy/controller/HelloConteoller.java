package org.javaboy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloConteoller {

    @GetMapping("hello")
    private static String hello() {
        return "hello";
    }

    @GetMapping("/admin/hello")
    private static String admin() {
        return "hello,admin";
    }

    @GetMapping("/user/hello")
    private static String user() {
        return "hello,user";
    }
}
