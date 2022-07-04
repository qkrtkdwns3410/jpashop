package jpabook.jpashop.controller;

import groovy.lang.GrabExclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;


/**
 * packageName    : jpabook.jpashop.controller
 * fileName       : BookForm
 * author         : ipeac
 * date           : 2022-07-05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-05        ipeac       최초 생성
 */
@Getter
@Setter
public class BookForm {
      
      private Long id;
      
      private String name;
      private int price;
      private int stockQuantity;
      
      private String author;
      private String isbn;
      
}
