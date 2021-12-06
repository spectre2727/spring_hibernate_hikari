package spring_hibernate_hikari.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring_hibernate_hikari.entity.Item;
import spring_hibernate_hikari.repository.ItemRepository;

@RestController
@RequestMapping("/items")
@CrossOrigin
public class ItemController {
	
	private final ItemRepository itemRepository;
	
	public ItemController(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	@GetMapping
	public List<Item> selectAllItems() {
		return itemRepository.selectAllItems();
	}
	
	@PostMapping
	public int insertItem(@RequestBody Item item) {
		return itemRepository.insertItem(item);
	}
	
	@PutMapping("/{id}")
	public int updateItem(@PathVariable("id") String id, @RequestBody Item item) {
		return itemRepository.updateItem(id, item);
	}
	
	@DeleteMapping("/{id}")
	public int deleteItem(@PathVariable("id") String id) {
		return itemRepository.deleteItem(id);
	}

}
