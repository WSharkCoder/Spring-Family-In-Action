package cn.wsharkcoder.simplejdbcdemo;

import lombok.Builder;
import lombok.Data;

/**
 * @author WSharkCoder
 * @date 2021/07/05
 * Entity
 */
@Data
@Builder
public class Foo {
    private Long id;
    private String bar;
}
