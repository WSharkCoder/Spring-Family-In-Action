package cn.wsharkcoder.mybatisdemo.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author WSharkCoder
 * @date 2021/07/10
 */
public class MoneyTypeHandler extends BaseTypeHandler<Money> {

    /**
     * 设置非空参数
     *
     * @param preparedStatement
     * @param i                 字段下标
     * @param money             参数
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Money money, JdbcType jdbcType) throws SQLException {
        preparedStatement.setLong(i, money.getAmountMajorLong());
    }

    /**
     * 根据字段名获取可空参数
     *
     * @param resultSet 结果集
     * @param s         字段名
     * @return
     * @throws SQLException
     */
    @Override
    public Money getNullableResult(ResultSet resultSet, String s) throws SQLException {

        return parseMoney(resultSet.getLong(s));
    }

    /**
     * 根据字段下标获取可空参数
     *
     * @param resultSet 结果集
     * @param i         字段下标
     * @return
     * @throws SQLException
     */
    @Override
    public Money getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return parseMoney(resultSet.getLong(i));
    }

    /**
     * 根据字段下标获取可空参数
     *
     * @param callableStatement
     * @param i 字段下表
     * @return
     * @throws SQLException
     */
    @Override
    public Money getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return parseMoney(callableStatement.getLong(i));
    }

    private Money parseMoney(Long value) {
        return Money.of(CurrencyUnit.of("CNY"), value / 100.0);
    }
}
