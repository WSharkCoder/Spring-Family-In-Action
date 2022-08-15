package cn.wsharkcoder.common;

/**
 * @Author WSharkCoder
 * @Date 2022/08/15
 */
public enum ResultStatus {
    SUCCESS(0, "SUCCESS"),
    FAIL(400, "Bad Request"),
    EXCEPTION(500, "Server ERR");

    private Integer code;
    private String msg;

    ResultStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
