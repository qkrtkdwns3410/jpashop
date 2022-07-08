package jpabook.jpashop.repository.order.simplequery;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;


/*
 *packageName    : jpabook.jpashop.repository
 * fileName       : SimpleOrderDto
 * author         : ipeac
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        ipeac       최초 생성
 */
@Data
public class OrderSimpleQueryDto {
      
      private Long orderId;
      private String name;
      private LocalDateTime orderDate;
      private OrderStatus orderStatus;
      private Address address;
      
      public OrderSimpleQueryDto(Long orderId, String name, LocalDateTime orderDate, OrderStatus orderStatus, Address address) {
      
            this.name = name;
            this.orderId = orderId;
            this.orderDate = orderDate;
            this.orderStatus = orderStatus;
            this.address = address;
      }
      
}
