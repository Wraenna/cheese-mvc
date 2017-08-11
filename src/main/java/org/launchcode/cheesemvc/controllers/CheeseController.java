package org.launchcode.cheesemvc.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="cheese")
public class CheeseController {

    static HashMap<String, String> cheeses = new HashMap<>();

    @RequestMapping(value="")
    public String index(Model model ) {


        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {

        model.addAttribute("title", "Add Cheeses");
        return "cheese/add";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDesc) {
        cheeses.put(cheeseName, cheeseDesc);
        return "redirect:";
    }

    // TODO: Write method @ GET to display a remove form ("remove")

    @RequestMapping(value="remove", method=RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "Remove Cheeses");
        return "cheese/remove";
    }

    // TODO: Write method @ POST to remove a HashMap from ArrayList
    @RequestMapping(value="remove", method=RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam String removeCheese) {
        // Use a for loop to iterate over the hashmaps arraylist
        // for (HashMap<String, String> cheese : cheeses) {
            // Use a for loop to iterate over the keys in the hashmap
        for (Map.Entry<String, String> cheeseToRemove : cheeses.entrySet()) {
            String cheeseName = cheeseToRemove.getKey();
            if (cheeseName.contains(removeCheese)) {
                cheeses.remove(cheeseName);
            }
        }
        return "redirect:";


        // Redirect to index
    }
}
