package com.learnings.junit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-15
 */
@RestController
public class FirstController {

    @GetMapping("/hello")
    public String hello() {
        return "Hi Chetan";
    }
}
