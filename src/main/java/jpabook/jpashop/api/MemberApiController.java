package jpabook.jpashop.api;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.bv.time.pastorpresent.PastOrPresentValidatorForInstant;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * packageName    : jpabook.jpashop.api
 * fileName       : MemberApiController
 * author         : jihye94
 * date           : 2022-07-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-06        jihye94       최초 생성
 */
@RestController // @controller + @responseBoby(데이터를 json 방식으로 전송) = api 방식 컨트롤러
@RequiredArgsConstructor
public class MemberApiController {
      
      private final MemberService memberService;
      
      @PostMapping("/api/v1/members")
      public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member) {
            Long id = memberService.join(member);
            
            return new CreateMemberResponse(id);
      }
      
      @PostMapping("/api/v2/members")
      public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request) {
            
            Member member = new Member();
            member.setName(request.getName());
            
            Long id = memberService.join(member);
            
            return new CreateMemberResponse(id);
      }
      
      @PutMapping("/api/v2/members/{id}")
      public UpdateMemberResponse updateMemberV2(@PathVariable("id") Long id, @RequestBody @Valid UpdateMemberRequest request) {
            
            memberService.update(id, request.getName());
            Member one = memberService.findOne(id);
            return new UpdateMemberResponse(one.getId(), one.getName());
      }
      
      @Data
      @AllArgsConstructor
      static class CreateMemberResponse {
            
            private Long id;
            
      }
      
      @Data
      static class CreateMemberRequest {
            
            private String name;
            
      }
      
      @Data
      @AllArgsConstructor
      static class UpdateMemberResponse {
            
            private Long id;
            private String name;
            
      }
      
      @Data
      static class UpdateMemberRequest {
            
            private String name;
            
      }
      
}
