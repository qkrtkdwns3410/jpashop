package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {
      
      @Autowired
      MemberService memberService;
      @Autowired
      MemberRepository memberRepository;
      @Autowired
      EntityManager em;
      
      @Test
      public void 회원가입() throws Exception {
            //given
            Member member = new Member();
            member.setName("kim");
            //when
            Long saveId = memberService.join(member);
            
            //then
            assertThat(member).isEqualTo(memberRepository.findOne(saveId));
            
      }
      
      @Test(expected = IllegalStateException.class)
      public void 중복_회원_예외() throws Exception {
            //given
            Member member1 = new Member();
            Member member2 = new Member();
            
            member1.setName("kim");
            member2.setName("kim");
            //when
            memberService.join(member1);
            memberService.join(member2); // 예외가 발생해야합니다.
            
            //then
            fail("예외 발생");
      }
      
}