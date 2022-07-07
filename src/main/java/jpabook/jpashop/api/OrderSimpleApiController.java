package jpabook.jpashop.api;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * packageName    : jpabook.jpashop.api
 * fileName       : OrderSimpleApiController
 * author         : jihye94
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        jihye94       최초 생성
 */

/**
 * x To One (many to one , one to one)
 * Order
 * Order -> Member
 * Order -> Delivery
 */
@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {
      
      private final OrderRepository orderRepository;
      
      @GetMapping("/api/v1/simple-orders")
      public List<Order> orderV1() {
            List<Order> all = orderRepository.findAllByCriteria(new OrderSearch());
            
            return all;
      }
      
}
