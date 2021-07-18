package cn.wsharkcoder.errorcodedemo;

import org.springframework.dao.DuplicateKeyException;

/**
 * @author WSharkCoder
 * @date 2021/07/06
 * 自定义Double Key
 */
public class CustomDuplicatedKeyException extends DuplicateKeyException {
    public CustomDuplicatedKeyException(String msg) {
        super(msg);
    }

    public CustomDuplicatedKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
