package jpabook.jpashop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * packageName    : jpabook.jpashop.controller
 * fileName       : HelloController
 * author         : jihye94
 * date           : 2022-06-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-19        jihye94       최초 생성
 */
@Controller
public class HelloController {
      
      @GetMapping("/hello")
      public String hello(Model model) {
            model.addAttribute("data", "hello!!!");
            
            return "hello";
      }
      
}
