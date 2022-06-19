package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class MemberRepositoryTest {
      
      @Autowired
      private MemberRepository memberRepository;
      
      @BeforeEach
      void setUp() {
      }
      
      @AfterEach
      void tearDown() {
      }
      
      @Test
      @Transactional
      public void meberTest() throws Exception {
            //given
            Member member = new Member();
            member.setUsername("memberA");
            //when
            Long saveId = memberRepository.save(member);
            Member findMember = memberRepository.find(saveId);
            
            //then
            assertThat(findMember.getId()).isEqualTo(member.getId());
            assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
            assertThat(findMember).isEqualTo(member);
      }
      
      @Test
      public void find() throws Exception {
            //given
            
            //when
            
            //then
            
      }
      
}