package br.edu.uniritter.searchPhone.controller;

import br.edu.uniritter.searchPhone.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public ModelAndView index()
    {
        ModelAndView mav = new ModelAndView("home/index");
        mav.addObject("cliente", new Cliente());

        return mav;
    }
}
