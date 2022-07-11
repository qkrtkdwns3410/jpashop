package jpabook.jpashop.repository.order.query;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


/*
 *packageName    : jpabook.jpashop.repository.order.query
 * fileName       : OrderItemQueryDto
 * author         : ipeac
 * date           : 2022-07-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-11        ipeac       최초 생성
 */
@Data
public class OrderItemQueryDto {
    
    @JsonIgnore
    private Long orderId;
    private String itemName;
    private int orderPrice;
    private int count;
    
    public OrderItemQueryDto(Long orderId, String itemName, int orderPrice, int count) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.orderPrice = orderPrice;
        this.count = count;
    }
    
}
