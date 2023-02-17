package com.example.andreyshop.services;

import com.example.andreyshop.domein.entities.Item;
import com.example.andreyshop.domein.models.CategoryModel;
import com.example.andreyshop.domein.models.ItemModel;
import com.example.andreyshop.domein.models.bindings.ItemAddModel;
import com.example.andreyshop.domein.models.bindings.ItemViewModel;
import com.example.andreyshop.helpers.LoggedUser;
import com.example.andreyshop.repositories.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ItemRepository itemRepository;

@Autowired
    public ItemService(ModelMapper modelMapper, LoggedUser loggedUser, UserService userService, CategoryService categoryService, ItemRepository itemRepository) {
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.categoryService = categoryService;
        this.itemRepository = itemRepository;
    }
    public void addItem(ItemAddModel itemAddModel){

        Item itemToSave = this.modelMapper.map(ItemModel.builder()
                .name(itemAddModel.getName())
               .description(itemAddModel.getDescription())
                .category(categoryService.findByName(itemAddModel.getCategory()))
                .price(itemAddModel.getPrice())
                .gender(itemAddModel.getGender()).build(), Item.class);

        this.itemRepository.saveAndFlush(itemToSave);


    }
//
//    public List<ItemViewModel> getAll (){
//
////    return itemRepository
////            .findAll().
////            stream()
////            .map(item -> {
////                this.modelMapper.map (ItemViewModel.builder()
////                        .name(item.getName())
////                        .price(item.getPrice())
////                        .imageUrl(item.set)
////
////                        .build()), ItemViewModel.class);
////
////        }
//
//
//
//
//
//
//
//    }
        public void clearItem (Long id){
            itemRepository.deleteById(id);

        }

}
