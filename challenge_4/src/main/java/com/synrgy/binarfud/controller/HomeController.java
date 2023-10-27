package com.synrgy.binarfud.controller;

import com.synrgy.binarfud.view.HomeMenu;
import org.springframework.stereotype.Component;

@Component
public class HomeController {
    public void home(){
        HomeMenu.welcomeMessage();
        HomeMenu.mainMenuOption();
    }
}