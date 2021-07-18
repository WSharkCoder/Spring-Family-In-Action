package cn.wsharkcoder.declarativetransactiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author WSharkCoder
 * @date 2021/07/06
 */
@Service
public class FooServiceImpl implements FooService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @Transactional 声明式事务
     */
    @Override
    @Transactional
    public void insertRecord() {
        jdbcTemplate.execute("INSERT INTO FOO(BAR) VALUES ('AAA')");

    }

    /**
     * 抛出指定异常时RollBack
     *
     * @throws RollbackException
     */
    @Override
    @Transactional(
            rollbackFor = RollbackException.class
    )
    public void insertThenRollback() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('BBB') ");
        throw new RollbackException();
    }

    @Override
    public void invokeInsertThenRollback() throws RollbackException {
        insertThenRollback();
    }
}
