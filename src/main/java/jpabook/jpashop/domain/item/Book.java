package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * packageName    : jpabook.jpashop.domain
 * fileName       : Book
 * author         : ipeac
 * date           : 2022-06-21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-21        ipeac       최초 생성
 */
@Entity
@DiscriminatorValue("B")
@Setter
@Getter
public class Book extends Item {
      
      private String author;
      private String isbn;
}
