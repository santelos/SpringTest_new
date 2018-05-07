package com.example.SpringTest.Controllers;

import com.example.SpringTest.Visit;
import com.example.SpringTest.VisitsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by PStroganov on 14.03.2018.
 */

@RestController
@RequestMapping("/api")
public class ApiController {

    final VisitsRepository visitsRepository;

    public ApiController(VisitsRepository visitsRepository){
        this.visitsRepository = visitsRepository;
    }

    @GetMapping("/visits")
    public Iterable<Visit> getVisits(){
        return visitsRepository.findAll();
    }

    @GetMapping("/ViewVis")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView();
        List<Visit> tableViews = (List) visitsRepository.findAll();
        modelAndView.addObject("table",tableViews);
        modelAndView.setViewName("index2");
        return modelAndView;
    }

}
