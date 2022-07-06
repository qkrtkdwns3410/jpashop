package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import jpabook.jpashop.service.ItemService;
import jpabook.jpashop.service.MemberService;
import jpabook.jpashop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * packageName    : jpabook.jpashop.controller
 * fileName       : OrderController
 * author         : jihye94
 * date           : 2022-07-05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-05        jihye94       최초 생성
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class OrderController {
      
      private final OrderService orderService;
      private final OrderRepository orderRepository;
      private final MemberService memberService;
      private final ItemService itemService;
      
      @GetMapping("/order")
      public String createOrder(Model model) {
            log.info("OrderController.createOrder ");
            
            List<Member> members = memberService.findMembers();
            List<Item> items = itemService.findItems();
            
            model.addAttribute("members,", members);
            model.addAttribute("items,", items);
            
            
            return "order/orderForm";
      }
      
      @PostMapping("/order")
      public String create(@RequestParam("memberId") Long memberId, @RequestParam("itemId") Long itemId, @RequestParam("count") int count) {
            
            orderService.order(memberId, itemId, count);
            return "redirect:/orders";
      }
      
      @GetMapping("/orders")
      public String orderList(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model) {
            List<Order> orders = orderRepository.findAllByCriteria(orderSearch);
            model.addAttribute("orders", orders);
            
            return "order/orderList";
      }
      
      @PostMapping("/orders/{orderId}/cancel")
      public String cancleOrder(@PathVariable("orderId") Long orderId) {
            orderService.cancelOrder(orderId);
            
            return "redirect:/orders";
      }
      
}
