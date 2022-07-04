package jpabook.jpashop.controller;

import jpabook.jpashop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * packageName    : jpabook.jpashop.controller
 * fileName       : BookController
 * author         : ipeac
 * date           : 2022-07-05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-05        ipeac       최초 생성
 */
@Controller
@RequiredArgsConstructor
public class itemController {
      
      private final ItemService itemService;
      
      @GetMapping("/items/new")
      public String createForm(Model model) {
            
            model.addAttribute("form", new BookForm());
            return "/items/createItemForm";
      }
      
      @PostMapping("/items/new")
      public String create(BookForm bookForm) {
            
            
            return "";
      }
      
}
