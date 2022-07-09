package jpabook.jpashop.api;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * packageName    : jpabook.jpashop.api
 * fileName       : OrderApiController
 * author         : jihye94
 * date           : 2022-07-09
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-09        jihye94       최초 생성
 */
@RestController
@RequiredArgsConstructor
public class OrderApiController {
      
      private final OrderRepository orderRepository;
      
      @GetMapping("/api/v1/orders")
      public List<Order> orderV1() {
            List<Order> all = orderRepository.findAllByCriteria(new OrderSearch());
            
            for (Order order : all) {
                  order.getMember().getName();
                  
                  order.getDelivery().getAddress();
                  
                  order.getOrderItems();
                  
                  List<OrderItem> orderItems = order.getOrderItems();
                  
                  orderItems.stream().forEach(orderItem -> orderItem.getItem().getName());
            }
            return all;
      }
      
}
