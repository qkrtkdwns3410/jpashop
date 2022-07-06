package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


/**
 * packageName    : jpabook.jpashop.service
 * fileName       : ItemService
 * author         : jihye94
 * date           : 2022-06-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-25        jihye94       최초 생성
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
      
      private final ItemRepository itemRepository;
      private EntityManager em;
      
      @Transactional
      public void saveItem(Item item) {
            itemRepository.save(item);
      }
      
      public List<Item> findItems() {
            return itemRepository.findAll();
      }
      
      public Item findOne(Long itemId) {
            return itemRepository.findOne(itemId);
      }
      
      /**
       * 영속성 컨텍스트가 자동 변경
       */
      @Transactional
      public void updateItem(Long id, String name, int price) {
            Item item = itemRepository.findOne(id);
            item.setName(name);
            item.setPrice(price);
      }
      
}
