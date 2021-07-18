package cn.wsharkcoder.declarativetransactiondemo;

/**
 * @author WSharkCoder
 * @date 2021/07/06
 */
public interface FooService {
    /**
     * 插入记录
     */
    void insertRecord();

    /**
     * 插入然后回滚
     */
    void insertThenRollback()throws  RollbackException;
    void invokeInsertThenRollback()throws RollbackException;


}
