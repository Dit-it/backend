package com.example.backend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/")
public class IndexController {

    @GetMapping
    @ResponseBody
    public String index() {
        log.info("index page");
        return "index";
    }

}
