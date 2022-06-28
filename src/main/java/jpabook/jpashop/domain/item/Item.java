package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.domain.exception.NotEnoughStockException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {
      
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "item_id")
      private Long id;
      
      private String name;
      private int price;
      private int stockQuantity;
      
      @ManyToMany(mappedBy = "items")
      private List<Category> categories = new ArrayList<>();
      
      /**
       * stock 증가
       */
      /*비즈니스 로직*/
      public void addStock(int quantity) {
            this.stockQuantity += quantity; // 재고 수량 증가 로직
            
      }
      
      /**
       * stock 제거
       */
      public void removeStock(int quantity) {
            int restStock = this.stockQuantity - quantity;
            if (restStock < 0) {
                  throw new NotEnoughStockException("재고가 부족합니다");
            }
            this.stockQuantity -= quantity;
      }
      
}
