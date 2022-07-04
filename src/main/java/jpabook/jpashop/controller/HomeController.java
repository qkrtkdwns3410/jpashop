package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * packageName    : jpabook.jpashop.controller
 * fileName       : HomeController
 * author         : jihye94
 * date           : 2022-07-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-04        jihye94       최초 생성
 */
@Controller
@Slf4j
public class HomeController {
      
      @RequestMapping("/")
      public String home() {
            log.info("HomeController.home ");
            
            return "home";
      }
      
}
