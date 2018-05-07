package com.example.SpringTest.Controllers;

import com.example.SpringTest.Visit;
import com.example.SpringTest.VisitsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by PStroganov on 16.03.2018.
 */

@Controller("/")
public class AjaxJSPController {

    final VisitsRepository visitsRepository;

    AjaxJSPController(VisitsRepository visitsRepository){this.visitsRepository=visitsRepository;}

    @GetMapping()
    public ModelAndView displayView(){
        ModelAndView pageView = new ModelAndView("jspTest");
        pageView.addObject("name","DaDaYaDa");
        return pageView;
    }
    @ResponseBody
    @RequestMapping( value = "/visitsTable", method = RequestMethod.POST, produces = "application/json")
    public Iterable<Visit> tableResponse() {
        System.out.println("/visitsTable");
        return visitsRepository.findAll();
    }

    @ResponseBody
    @RequestMapping( value = "/text", method = RequestMethod.POST, produces = "application/json")
    public String textResponse(){
        return "aga";
    }
}
