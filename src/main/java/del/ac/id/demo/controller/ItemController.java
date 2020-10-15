package del.ac.id.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import del.ac.id.demo.jpa.Item;
import del.ac.id.demo.jpa.ItemRepository;

@RestController
public class ItemController {
	@Autowired ItemRepository itemRepository;
	
	@RequestMapping("/item")
	public ModelAndView item() {
		List<Item> items = itemRepository.findAll();
		
		ModelAndView mv = new ModelAndView("item");
		mv.addObject("items", items);
		
		return mv;
	}
	
	@PutMapping("/item/{id}")
	  public ResponseEntity<Item> updateTutorial(@PathVariable("id") String id, @RequestBody Item item) {
		Optional<Item> items = itemRepository.findById(id);

		  if (items.isPresent()) {
		    Item _item = items.get();
		    _item.setStock(item.getStock());
		    _item.setRating(item.getRating());
		    _item.setSold(item.getSold());
		    _item.setSeen(item.getSeen());
		    return new ResponseEntity<>(itemRepository.save(_item), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }
	

}
