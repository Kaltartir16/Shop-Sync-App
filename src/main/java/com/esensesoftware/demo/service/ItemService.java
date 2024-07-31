package com.esensesoftware.demo.service;

import com.esensesoftware.demo.entity.Item;
import com.esensesoftware.demo.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {

    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long itemId, Item itemDetails) {
        Optional<Item> itemOptional = itemRepository.findById(itemId);
        if (itemOptional.isPresent()) {
            Item item = itemOptional.get();
            if (itemDetails.getItemName() != null) {
                item.setItemName(itemDetails.getItemName());
            }
            if (itemDetails.getItemDescription() != null) {
                item.setItemDescription(itemDetails.getItemDescription());
            }
            if (itemDetails.getItemType() != null) {
                item.setItemType(itemDetails.getItemType());
            }
            if (itemDetails.getItemPrice() != null) {
                item.setItemPrice(itemDetails.getItemPrice());
            }
            if (itemDetails.getItemQuantity() != null) {
                item.setItemQuantity(itemDetails.getItemQuantity());
            }
            if (itemDetails.getCategory() != null) {
                item.setCategory(itemDetails.getCategory());
            }
            return itemRepository.save(item);
        } else {
            throw new RuntimeException("Item not found with id " + itemId);
        }
    }

    public boolean deleteItem(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }

}//ItemService