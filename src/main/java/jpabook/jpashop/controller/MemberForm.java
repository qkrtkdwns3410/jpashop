package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


/**
 * packageName    : jpabook.jpashop.controller
 * fileName       : MemberFrom
 * author         : ipeac
 * date           : 2022-07-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-04        ipeac       최초 생성
 */
@Getter
@Setter
public class MemberForm {
      
      @NotEmpty(message = "회원 이름은 필수입니다")
      private String name;
      
      private String city;
      private String street;
      private String zipcode;
      
}
