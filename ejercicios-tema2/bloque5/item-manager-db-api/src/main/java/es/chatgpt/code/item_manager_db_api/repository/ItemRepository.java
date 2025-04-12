package es.chatgpt.code.item_manager_db_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.chatgpt.code.item_manager_db_api.models.Item;;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
