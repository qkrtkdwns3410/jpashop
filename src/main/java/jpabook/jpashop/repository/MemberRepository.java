package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * packageName    : jpabook.jpashop.repository
 * fileName       : MemberRepository
 * author         : jihye94
 * date           : 2022-06-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-19        jihye94       최초 생성
 */
@Repository
public class MemberRepository {
      
      @PersistenceContext
      private EntityManager em;
      
      public Long save(Member member) {
            em.persist(member);
            return member.getId();
      }
      
      public Member find(Long id) {
            return em.find(Member.class, id);
      }
      
}

