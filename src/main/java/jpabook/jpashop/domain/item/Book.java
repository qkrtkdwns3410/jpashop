package jpabook.jpashop.domain.item;

import jpabook.jpashop.controller.BookForm;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * packageName    : jpabook.jpashop.domain
 * fileName       : Book
 * author         : ipeac
 * date           : 2022-06-21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-21        ipeac       최초 생성
 */
@Entity
@DiscriminatorValue("B")
@Setter
@Getter
public class Book extends Item {
      
      private String author;
      private String isbn;
      
      public static Book createBook(BookForm form) {
            Book book = new Book();
            book.setName(form.getName());
            book.setPrice(form.getPrice());
            book.setStockQuantity(form.getStockQuantity());
            book.setAuthor(form.getAuthor());
            book.setIsbn(form.getIsbn());
            
            return book;
      }
      
}
