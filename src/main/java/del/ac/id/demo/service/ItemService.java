package del.ac.id.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import del.ac.id.demo.jpa.*;

@Service
public class ItemService {

	@Autowired ItemRepository itemRepository;
	
	
}
