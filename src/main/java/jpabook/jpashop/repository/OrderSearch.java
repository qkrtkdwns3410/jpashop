package jpabook.jpashop.repository;

import jpabook.jpashop.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;


/**
 * packageName    : jpabook.jpashop.repository
 * fileName       : OrderSearch
 * author         : ipeac
 * date           : 2022-06-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-30        ipeac       최초 생성
 */
@Repository
@Getter
@Setter
public class OrderSearch {
      
      private String memberName; // 회원 이름
      private OrderStatus orderStatus; // 주문 상태 [ORDER , CANCEL]
      
}
