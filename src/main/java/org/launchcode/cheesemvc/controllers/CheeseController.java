package org.launchcode.cheesemvc.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.launchcode.cheesemvc.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping(value="cheese")
public class CheeseController {

    @RequestMapping(value="")
    public String index(Model model ) {


        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {

        model.addAttribute("title", "Add Cheeses");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheeses");
            return "cheese/add";
        }

        CheeseData.add(newCheese);
        return "redirect:";
    }

    @RequestMapping(value="remove", method=RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "Remove Cheeses");
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIDs) {

        for (int cheeseID : cheeseIDs) {
            CheeseData.remove(cheeseID);
        }

        return "redirect:";
    }

    @RequestMapping(value = "edit/{cheeseID}", method=RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseID) {

        Cheese cheeseToEdit = CheeseData.getByID(cheeseID);

        model.addAttribute("cheese", cheeseToEdit);
        model.addAttribute("cheeseTypes", CheeseType.values());

        return "cheese/edit";

    }

    @RequestMapping(value = "edit", method=RequestMethod.POST)
    public String processEditCheeseForm(@RequestParam String cheeseName,
                                        @RequestParam String cheeseDesc,
                                        @RequestParam int cheeseID,
                                        @RequestParam CheeseType cheeseType,
                                        @RequestParam int cheeseRating) {

        CheeseData.edit(cheeseID, cheeseName, cheeseDesc, cheeseType, cheeseRating);

        return "redirect:";

    }
}
