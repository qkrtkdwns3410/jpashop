package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * packageName    : jpabook.jpashop.domain
 * fileName       : Movie
 * author         : ipeac
 * date           : 2022-06-21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-21        ipeac       최초 생성
 */
@Entity
@DiscriminatorValue("M")
@Setter
@Getter
public class Movie extends Item {
      
      private String director;
      private String actor;

}
