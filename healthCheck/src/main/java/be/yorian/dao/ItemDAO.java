package be.yorian.dao;

import be.yorian.domain.Item;

public interface ItemDAO {
	
	public Item findItemByID(int id);

	public int saveItem(Item item);
}
