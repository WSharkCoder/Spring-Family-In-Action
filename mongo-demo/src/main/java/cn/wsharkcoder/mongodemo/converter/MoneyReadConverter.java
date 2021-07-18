package cn.wsharkcoder.mongodemo.converter;

import org.bson.Document;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;

/**
 * @author WSharkCoder
 * @date 2021/07/13
 */
public class MoneyReadConverter implements Converter<Document, Money> {
    /**
     * Document 转 Money 转换器
     * (Document存储后的数据格式类似于json格式的名为bson格式)
     *
     * @param document
     * @return
     */
    @Override
    public Money convert(Document document) {
        Document money = (Document) document.get("money");
        //金额
        double amount = Double.parseDouble(money.getString("amount"));
        //币种
        String currency = ((Document) money.get("currency")).getString("code");
        //根据币种 和 金额构建Money
        return Money.of(CurrencyUnit.of(currency), amount);
    }
}
