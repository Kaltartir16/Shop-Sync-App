package com.esensesoftware.demo.controller;

import com.esensesoftware.demo.entity.Item;
import com.esensesoftware.demo.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("items/")
public class ItemController {

    private ItemService itemService;

    @GetMapping("/getItems")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @PostMapping("/createItem")
    public List<Item> createItem(@RequestBody Item item) {
        itemService.createItem(item);
        return itemService.getAllItems();
    }

    @PostMapping("/updateItem/{id}")
    public List<Item> updateItem(@PathVariable Long id, @RequestBody Item itemDetails) {
        itemService.updateItem(id, itemDetails);
        return itemService.getAllItems();

    }

    @PostMapping("/deleteItem/{id}")
    public List<Item> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return itemService.getAllItems();
        }


}