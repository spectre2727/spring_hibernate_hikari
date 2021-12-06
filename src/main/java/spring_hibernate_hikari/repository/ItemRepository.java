package spring_hibernate_hikari.repository;

import java.util.List;
import java.util.UUID;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring_hibernate_hikari.entity.Item;

@Repository
@Transactional
public class ItemRepository {

	private final SessionFactory sessionFactory;

	public ItemRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Item> selectAllItems() {
		String query = "select * from items order by value";
		return sessionFactory.getCurrentSession().createNativeQuery(query, Item.class).getResultList();
	}

	public int insertItem(Item item) {
		item.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 16));
		sessionFactory.getCurrentSession().save(item);
		return 1;
	}

	public int updateItem(String id, Item item) {
		item.setId(id);
		sessionFactory.getCurrentSession().update(item);
		return 1;
	}

	public int deleteItem(String id) {
		Item item = new Item();
		item.setId(id);
		sessionFactory.getCurrentSession().delete(item);
		return 1;
	}

}
