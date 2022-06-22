package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;


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
      @GeneratedValue
      @Column(name = "member_id")
      private Long id;
      private String name;
      
      @Embedded
      private Address address;
      
      @OneToMany(fetch = LAZY, mappedBy = "member")
      private List<Order> orders = new ArrayList<>();
      
}





