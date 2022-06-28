package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


/**
 * packageName    : jpabook.jpashop.repository
 * fileName       : ItemRepository
 * author         : jihye94
 * date           : 2022-06-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-25        jihye94       최초 생성
 */
@Repository
@RequiredArgsConstructor
public class ItemRepository {
      
      private final EntityManager em;
      
      public void save(Item item) {
            if (item.getId() == null) {
                  em.persist(item); // insert 랑 비슷
            } else {
                  em.merge(item); // update랑 비슷
            }
            
      }
      
      public Item findOne(long id) {
            return em.find(Item.class, id);
      }
      
      public List<Item> findAll() {
            return em.createQuery("select i from Item  i ", Item.class)
                     .getResultList();
      }
      
}
