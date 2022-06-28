package jpabook.jpashop.domain.exception;

/**
 * packageName    : jpabook.jpashop.domain.exception
 * fileName       : NotEnoughStockException
 * author         : jihye94
 * date           : 2022-06-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-25        jihye94       최초 생성
 */
public class NotEnoughStockException extends RuntimeException {
      
      public NotEnoughStockException() {
            super();
      }
      
      public NotEnoughStockException(String message) {
            super(message);
      }
      
      public NotEnoughStockException(String message, Throwable cause) {
            super(message, cause);
      }
      
      public NotEnoughStockException(Throwable cause) {
            super(cause);
      }
      
}
