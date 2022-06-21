package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * packageName    : jpabook.jpashop.domain
 * fileName       : Album
 * author         : ipeac
 * date           : 2022-06-21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-21        ipeac       최초 생성
 */
@Entity
@DiscriminatorValue("A")
@Setter
@Getter
public class Album extends Item {
      private String artist;
      private String etc;

}
