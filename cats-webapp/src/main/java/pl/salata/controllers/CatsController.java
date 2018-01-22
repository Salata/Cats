package pl.salata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.salata.Cat;
import pl.salata.CatDAO;
import pl.salata.dto.CatDTO;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@Controller
public class CatsController {

    @Autowired
    private CatDAO catDao;

    @RequestMapping("/lista")
    public String listaKotow(Model model) {
        model.addAttribute("cats", catDao.getCats());
        return "lista";
    }


    @RequestMapping("/addcat")
    public String dodajKota(HttpServletRequest request, @ModelAttribute("catDto") @Valid CatDTO catDto, BindingResult result) {
        if (request.getMethod().equalsIgnoreCase("post") && !result.hasErrors()) {
            Cat cat = new Cat();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            try {
                cat.setDateBirth(sdf.parse(catDto.getDataUrodzenia()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cat.setName(catDto.getImie());
            cat.setNameHandler(catDto.getImieOpiekuna());
            cat.setWeight(catDto.getWaga());
            catDao.addCat(cat);
            return "redirect:/lista";
        }
        return "addcat";
    }


    @RequestMapping("/cat-{id}")
    public String displaycats(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("cat", catDao.getKotById(id));
        return "displaycats";
    }


}
