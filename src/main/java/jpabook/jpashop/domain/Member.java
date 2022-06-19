package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * packageName    : jpabook.jpashop.domain
 * fileName       : Member
 * author         : jihye94
 * date           : 2022-06-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-19        jihye94       최초 생성
 */
@Entity
@Getter
@Setter
public class Member {
      
      @Id
      @Generate
      dValue
      private Long id;
      private String username;
      
}





