package jpabook.jpashop.api;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import jpabook.jpashop.repository.order.query.OrderQueryDto;
import jpabook.jpashop.repository.order.query.OrderQueryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


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
      private final OrderQueryRepository orderQueryRepository;
      
      @GetMapping("/api/v1/orders")
      public List<Order> orderV1() {
            List<Order> all = orderRepository.findAllByCriteria(new OrderSearch());
            
            for (Order order : all) {
                  order.getMember()
                       .getName();
                  
                  order.getDelivery()
                       .getAddress();
                  
                  List<OrderItem> orderItems = order.getOrderItems();
                  
                  orderItems.stream()
                            .forEach(orderItem -> orderItem.getItem()
                                                           .getName());
            }
            return all;
      }
      
      @GetMapping("/api/v2/orders")
      public Result<List<OrderDto>> ordersV2() {
            List<Order> all = orderRepository.findAllByCriteria(new OrderSearch());
            List<OrderDto> collect = all.stream()
                                        .map(OrderDto::new)
                                        .collect(Collectors.toList());
            
            return new Result<>(collect);
      }
      
      @GetMapping("/api/v3/orders")
      public Result<List<OrderDto>> ordersV3() {
            List<Order> all = orderRepository.findAllWithItem();
            List<OrderDto> collect = all.stream()
                                        .map(OrderDto::new)
                                        .collect(Collectors.toList());
            return new Result<>(collect);
      }
      
      @GetMapping("/api/v3.1/orders")
      public Result<List<OrderDto>> ordersV3_page(@RequestParam(value = "offset", defaultValue = "0") int offset,
                                                  @RequestParam(value = "limit", defaultValue = "100") int limit) {
            //order 기준 ToOne관계 모두 페치조인
            List<Order> all = orderRepository.findAllWithMemberDelivery(offset, limit);
            
            List<OrderDto> collect = all.stream()
                                        .map(OrderDto::new)
                                        .collect(Collectors.toList());
            return new Result<>(collect);
      }
      
      @GetMapping("/api/v4/orders")
      public Result<List<OrderQueryDto>> ordersV4() {
            return new Result<>(orderQueryRepository.findOrderQueryDtos());
      }
      @GetMapping("/api/v5/orders")
      public Result<List<OrderQueryDto>> ordersV5() {
            return new Result<>(orderQueryRepository.findAllByDto_opt());
      }
      
      @Data
      static class OrderDto {
            
            private Long orderId;
            private String name;
            private LocalDateTime orderDate;
            private OrderStatus orderStatus;
            private Address address;
            private List<OrderItemDto> orderItems;
            
            public OrderDto(Order order) {
                  orderId = order.getId();
                  name = order.getMember()
                              .getName();
                  orderDate = order.getOrderDate();
                  orderStatus = order.getStatus();
                  address = order.getDelivery()
                                 .getAddress();
                  orderItems = order.getOrderItems()
                                    .stream()
                                    .map(OrderItemDto::new)
                                    .collect(Collectors.toList());
            }
            
      }
      
      @Getter
      static class OrderItemDto {
            
            private String itemName;
            private int orderPrice;
            private int count;
            
            public OrderItemDto(OrderItem orderItem) {
                  itemName = orderItem.getItem()
                                      .getName();
                  orderPrice = orderItem.getOrderPrice();
                  count = orderItem.getCount();
            }
            
      }
      
      @Data
      @AllArgsConstructor
      static class Result<T> {
            
            private T data;
            
      }
      
}
