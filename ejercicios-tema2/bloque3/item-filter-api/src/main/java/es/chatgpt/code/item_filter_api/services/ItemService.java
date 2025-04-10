package es.chatgpt.code.item_filter_api.services;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import es.chatgpt.code.item_filter_api.models.Item;

@Service
public class ItemService {

    private ConcurrentMap<Long, Item> items = new ConcurrentHashMap<>();
    private AtomicLong nextId = new AtomicLong(1);

    public ItemService() {
        save(new Item("Milk", 1.2, false));
        save(new Item("Bread", 0.8, true));
        save(new Item("Cheese", 5.5, false));
    }

    public Collection<Item> findAll() {
        return items.values();
    }

    public Item findById(long id) {
        return items.get(id);
    }

    public void save(Item item) {
        if (item.getId() == null || item.getId() == 0) {
            item.setId(nextId.getAndIncrement());
        }
        items.put(item.getId(), item);
    }

    public void deleteById(long id) {
        items.remove(id);
    }

    public List<Item> findByPriceBelow(double limit) {
        return items.values().stream().filter(item -> item.getPrice() < limit).collect(Collectors.toList());
    }
}
