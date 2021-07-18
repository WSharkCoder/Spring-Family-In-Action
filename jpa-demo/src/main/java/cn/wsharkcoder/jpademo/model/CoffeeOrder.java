package cn.wsharkcoder.jpademo.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;


/**
 * @author WSharkCoder
 * @date 2021/7/8
 */

/**
 * 标注实体
 */
@Entity
/**
 * 标注对应表
 */
@Table(name = "T_ORDER")
@Builder
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeOrder extends BaseEntity implements Serializable {
    private String customer;
    /**
     * 标注多对多关系
     */
    @ManyToMany
    @JoinTable(name = "T_ORDER_COFFEE")
    @OrderBy("id")
    private List<Coffee> items;
    /**
     * 订单状态
     */
    @Enumerated
    @Column(nullable = false)
    private OrderState state;


}
