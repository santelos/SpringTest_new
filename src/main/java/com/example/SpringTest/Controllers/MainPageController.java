package com.example.SpringTest.Controllers;

import com.example.SpringTest.Storage.StorageService;
import com.example.SpringTest.Visit;
import com.example.SpringTest.VisitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by PStroganov on 16.03.2018.
 */

@Controller("/")
public class MainPageController {

    private final VisitsRepository visitsRepository;
    private final StorageService storageService;

    @Autowired
    MainPageController(VisitsRepository visitsRepository, StorageService storageService) {
        this.visitsRepository = visitsRepository;
        this.storageService = storageService;
    }

    @GetMapping()
    public ModelAndView displayView() {
        ModelAndView pageView = new ModelAndView("jspTest");
        pageView.addObject("name", "DaDaYaDa");
        pageView.addObject("files",storageService.loadAllAsStringList());
        System.out.println(pageView.getModel());
        return pageView;
    }

    @ResponseBody
    @RequestMapping(value = "/visitsTable", method = RequestMethod.POST, produces = "application/json")
    public Iterable<Visit> tableResponse() {
        System.out.println("/visitsTable");
        return visitsRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/text", method = RequestMethod.POST, produces = "application/json")
    public String textResponse() {
        return "aga";
    }
}
