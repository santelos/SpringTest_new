package com.example.SpringTest.Controllers;

import com.example.SpringTest.Visit;
import com.example.SpringTest.VisitsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by PStroganov on 20.02.2018.
 */
@Controller
public class IndexController {

    final VisitsRepository visitsRepository;

    public IndexController(VisitsRepository visitsRepository){
        this.visitsRepository=visitsRepository;
    }

    @GetMapping("/visit")
    public ModelAndView index(){
        Map<String, String> model = new HashMap<>();
        model.put("name","Petr");

        Visit visit = new Visit();
        visit.description = String.format("%s", LocalDateTime.now());
        visitsRepository.save(visit);

        return new ModelAndView("index",model);
    }
}
