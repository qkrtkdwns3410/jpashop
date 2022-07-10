package jpabook.jpashop.api;

import com.sun.xml.bind.v2.model.core.ReferencePropertyInfo;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import jpabook.jpashop.repository.order.simplequery.OrderSimpleQueryDto;
import jpabook.jpashop.repository.order.simplequery.OrderSimpleQueryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;


/*
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
@Slf4j
public class OrderSimpleApiController {
      
      private final OrderRepository orderRepository;
      private final OrderSimpleQueryRepository orderSimpleQueryRepository;
      
      
      @GetMapping("/api/v1/simple-orders")
      
      public List<Order> orderV1() {
            List<Order> all = orderRepository.findAllByCriteria(new OrderSearch());
            for (Order order : all) {
                  order.getMember()
                      .getName(); //LAZY 강제 초기화
                  
                  order.getDelivery()
                      .getAddress(); //LAZY 강제 초기화
            }
            return all;
      }
      
      @GetMapping("/api/v2/simple-orders")
      public Result<List<SimpleOrderDto>> ordersV2() {
            log.info("OrderSimpleApiController.ordersV2 ");
            List<Order> orders = orderRepository.findAllByCriteria(new OrderSearch());
            
            List<SimpleOrderDto> collect = orders.stream()
                .map(SimpleOrderDto::new)
                .collect(toList());
            return new Result<>(collect);
      }
      
      /**
       * 페치 조인  => 성능 최적화
       */
      @GetMapping("/api/v3/simple-orders")
      public Result<List<SimpleOrderDto>> ordersV3() {
            log.info("OrderSimpleApiController.ordersV3 ");
            
            List<Order> orderList = orderRepository.findAllWithMemberDelivery();
            
            List<SimpleOrderDto> collect = orderList.stream()
                .map(SimpleOrderDto::new)
                .collect(toList());
            
            return new Result<>(collect);
      }
      
      @GetMapping("/api/v4/simple-orders")
      public Result<List<OrderSimpleQueryDto>> ordersV4() {
            log.info("OrderSimpleApiController.ordersV4 ");
            List<OrderSimpleQueryDto> orderDtos = orderSimpleQueryRepository.findOrderDtos();
            
            return new Result<>(orderDtos);
      }
      
      
      
      
      @Data
      @AllArgsConstructor
      static class Result<T> {
            
            private T data;
            
      }
      
      @Data
      @RequiredArgsConstructor
      static class SimpleOrderDto {
            
            private Long orderId;
            private String name;
            private LocalDateTime orderDate;
            private OrderStatus orderStatus;
            private Address address;
            
            public SimpleOrderDto(Order order) {
                  orderId = order.getId();
                  name = order.getMember()
                      .getName();
                  orderDate = order.getOrderDate();
                  orderStatus = order.getStatus();
                  address = order.getDelivery()
                      .getAddress();
            }
            
      }
      
}
