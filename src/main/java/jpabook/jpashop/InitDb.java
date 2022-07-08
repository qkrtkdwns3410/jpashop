package jpabook.jpashop;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;


/**
 * packageName    : jpabook.jpashop
 * fileName       : InitDb
 * author         : ipeac
 * date           : 2022-07-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-07        ipeac       최초 생성
 */

/**
 * 총 주문 2개
 * * userA
 * * *JPA1 BOOK
 * * *JPA2 BOOK
 * * userB
 * * * SPRING1 BOOK
 * * * SPRING2 BOOK
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
                  Member member = createMember("userA", "1");
                  em.persist(member);
                  
                  Book book1 = getBook("JPA1 BOOK", 10000, 200);
                  em.persist(book1);
                  
                  Book book2 = getBook("JPA2 BOOK", 20000, 300);
                  em.persist(book2);
                  
                  OrderItem orderItem1 = OrderItem.createOrderItem(book1, 10000, 1);
                  OrderItem orderItem2 = OrderItem.createOrderItem(book2, 20000, 2);
                  
                  Delivery delivery = createDelivery(member);
                  Order order = Order.createOrder(member, delivery, orderItem1, orderItem2);
                  em.persist(order);
            }
            
            private Book getBook(String book_param, int price, int stockQuantity) {
                  Book book = new Book();
                  book.setName(book_param);
                  book.setPrice(price);
                  book.setStockQuantity(stockQuantity);
                  return book;
            }
            
            private Member createMember(String user, String street) {
                  Member member = new Member();
                  member.setName(user);
                  member.setAddress(new Address("서울", street, "1111"));
                  return member;
            }
            
            public void dbInit2() {
                  Member member = createMember("userB", "11");
                  em.persist(member);
                  
                  Book book1 = getBook("spring1 BOOK", 20000, 200);
                  em.persist(book1);
                  
                  Book book2 = getBook("spring2 BOOK", 40000, 300);
                  em.persist(book2);
                  
                  OrderItem orderItem1 = OrderItem.createOrderItem(book1, 20000, 3);
                  OrderItem orderItem2 = OrderItem.createOrderItem(book2, 40000, 4);
                  
                  Delivery delivery = createDelivery(member);
                  Order order = Order.createOrder(member, delivery, orderItem1, orderItem2);
                  em.persist(order);
            }
            
            private Delivery createDelivery(Member member) {
                  Delivery delivery = new Delivery();
                  delivery.setAddress(member.getAddress());
                  return delivery;
            }
            
      }
      
}


