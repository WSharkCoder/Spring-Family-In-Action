package cn.wsharkcoder.mybatisdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import java.util.Date;

/**
 * @author WSharkCoder
 * @date 2021/07/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coffee {
    private Long id;
    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;


}
