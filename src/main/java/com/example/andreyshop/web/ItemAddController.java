package com.example.andreyshop.web;

import com.example.andreyshop.domein.models.bindings.ItemAddModel;
import com.example.andreyshop.services.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/items")
public class ItemAddController {

    private final ItemService itemService;

    @Autowired
    public ItemAddController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/add")
    public String getAddItem(){
        return "add-item";
    }

    @PostMapping("/add")
    public String postItem (@Valid @ModelAttribute(name = "itemAddModel") ItemAddModel itemAddModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("itemAddModel", itemAddModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.itemAddModel", bindingResult);
            return "redirect:add";
        }
        this.itemService.addItem(itemAddModel);

        return "redirect:/home";
    }



    @ModelAttribute(name = "itemAddModel")
    public ItemAddModel itemAddModel(){
        return new ItemAddModel();

    }
}
