package cn.wsharkcoder.jpademo.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.joda.money.Money;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


/**
 * @author WSharkCoder
 * @date 2021/07/08
 */

/**
 * 标注实体
 */
@Entity
/**标注对应表*/
@Table(name = "T_MENU")
@Builder
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Coffee extends BaseEntity implements Serializable {
    private String name;
    @Column
    /**
     * 指定Money属性映射的数值
     * PersistentMoneyAmount ==>decimal
     * PersistentMoneyMinorAmount==>bigint
     */
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyMinorAmount",
            parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY")})
    private Money money;
}
