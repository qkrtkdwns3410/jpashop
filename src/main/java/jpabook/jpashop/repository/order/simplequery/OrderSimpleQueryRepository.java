package jpabook.jpashop.repository.order.simplequery;
/*
 *packageName    : jpabook.jpashop.repository
 * fileName       : OrderSimpleQueryRepository
 * author         : ipeac
 * date           : 2022-07-09
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-09        ipeac       최초 생성
 */

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@AllArgsConstructor
public class OrderSimpleQueryRepository {
      
      private final EntityManager em;
      
      public List<OrderSimpleQueryDto> findOrderDtos() {
            
            return em.createQuery(
                    "select new jpabook.jpashop.repository.order.simplequery.OrderSimpleQueryDto(o.id,m.name,o.orderDate,o.status,d.address) from Order o" +
                        " join o.member m" +
                        " join o.delivery d", OrderSimpleQueryDto.class)
                .getResultList();
      }
      
}
