package jpabook.jpashop;

import com.sun.source.tree.LambdaExpressionTree;
import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;


/**
 * packageName    : jpabook.jpashop
 * fileName       : InitDb
 * author         : jihye94
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        jihye94       최초 생성
 */
@Component
@RequiredArgsConstructor
public class InitDb {
      
      private final InitService initService;
      
      @PostConstruct
      public void init() {
            
            initService.dbInit1();
            initService.dbInit2();
      }
      
      @Component
      @Transactional
      @RequiredArgsConstructor
      static class InitService {
            
            private final EntityManager em;
            
            public void dbInit1() {
                  Member member = getMember("userA", "서울", "1", "1111");
                  em.persist(member);
                  
                  Book book1 = getBook("Jpa1 book", 10000, 300);
                  em.persist(book1);
                  
                  Book book2 = getBook("Jpa2 book", 20000, 200);
                  em.persist(book2);
                  
                  OrderItem orderItem1 = OrderItem.createOrderItem(book1, 10000, 1);
                  OrderItem orderItem2 = OrderItem.createOrderItem(book2, 20000, 2);
                  
                  Delivery delivery = getDelivery(member);
                  Order order = Order.createOrder(member, delivery, orderItem1, orderItem2);
                  em.persist(order);
            }
            
            private Delivery getDelivery(Member member) {
                  Delivery delivery = new Delivery();
                  delivery.setAddress(member.getAddress());
                  return delivery;
            }
            
            private Book getBook(String book_p, int price, int stockQuantity) {
                  Book book1 = new Book();
                  book1.setName(book_p);
                  book1.setPrice(price);
                  book1.setStockQuantity(stockQuantity);
                  return book1;
            }
            
            public void dbInit2() {
                  Member member = getMember("userB", "충청", "2", "1234");
                  em.persist(member);
                  
                  Book book1 = getBook("Spring book1", 10000, 200);
                  em.persist(book1);
                  
                  Book book2 = getBook("Spring book2", 20000, 400);
                  em.persist(book2);
                  
                  OrderItem orderItem1 = OrderItem.createOrderItem(book1, 10000, 1);
                  OrderItem orderItem2 = OrderItem.createOrderItem(book2, 40000, 2);
                  
                  Delivery delivery = getDelivery(member);
                  Order order = Order.createOrder(member, delivery, orderItem1, orderItem2);
                  em.persist(order);
            }
            
            private Member getMember(String user, String city, String street, String zipcode) {
                  Member member = new Member();
                  member.setName(user);
                  member.setAddress(new Address(city, street, zipcode));
                  return member;
            }
            
      }
      
}
      

