package com.example.andreyshop.web;

import com.example.andreyshop.domein.models.bindings.ItemViewModel;
import com.example.andreyshop.helpers.LoggedUser;
import com.example.andreyshop.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("home")
public class HomeController {
    private final LoggedUser loggedUser;
    private final ItemService itemService;

    public HomeController(LoggedUser loggedUser, ItemService itemService) {
        this.loggedUser = loggedUser;
        this.itemService = itemService;
    }

    @GetMapping
    public String index(Model model) {
        if (loggedUser.getId() == null) {
            return "index";
        }
        List<ItemViewModel> items = itemService.getAll();
        model.addAttribute("items", items);
        model.addAttribute("totalCount", items.size());

        return "home";
    }


}

