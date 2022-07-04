package jpabook.jpashop.config;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * packageName    : jpabook.jpashop.confg
 * fileName       : LayOutConfig
 * author         : jihye94
 * date           : 2022-07-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-04        jihye94       최초 생성
 */
@Configuration
public class LayOutConfig {
      
      //thymeleaf layout
      @Bean
      public LayoutDialect layoutDialect() {
            return new LayoutDialect();
      }
      
}
