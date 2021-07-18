package cn.wsharkcoder.jpademo.model;

/**
 * @author WSharkCoder
 * @date 2021/07/09
 */
public enum OrderState {
    /**
     * 初始
     */
    INIT,
    /**
     * 支付
     */
    PAID,
    /**
     * 制作中
     */
    BREWING,
    /**
     * 制作完成
     */
    BREWED,
    /**
     * 被拿走
     */
    TAKEN,
    /**
     * 已取消
     */
    CANCELLED,
    ;
}
