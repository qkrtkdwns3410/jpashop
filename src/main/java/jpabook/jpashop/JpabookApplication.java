package jpabook.jpashop;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class JpabookApplication {
      
      public static void main(String[] args) {
            SpringApplication.run(JpabookApplication.class, args);
      }
      
      @Bean
      Hibernate5Module hibernate5Module() {
            Hibernate5Module hibernate5Module = new Hibernate5Module();
            return hibernate5Module;
      }
}
