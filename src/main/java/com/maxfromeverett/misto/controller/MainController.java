package com.maxfromeverett.misto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/react")
  public String mainRouteHandler(){
    return "react";
  }
}
