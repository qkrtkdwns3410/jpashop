package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.EntityManager;
import java.util.List;


/**
 * packageName    : jpabook.jpashop.repository
 * fileName       : OrderRepository
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
public class OrderRepository {
      
      private final EntityManager em;
      
      public void save(Order order) {
            em.persist(order);
      }
      
      public Order findOne(Long id) {
            return em.find(Order.class, id);
      }
      
      //      public List<Order> findAll(OrderSerach orderSearch){}
      
}
