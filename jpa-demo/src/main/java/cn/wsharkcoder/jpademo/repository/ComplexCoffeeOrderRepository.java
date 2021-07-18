package cn.wsharkcoder.jpademo.repository;

import cn.wsharkcoder.jpademo.model.CoffeeOrder;

import java.util.List;

/**
 * @author WSharkCoder
 * @date 2021/07/09
 */
public interface ComplexCoffeeOrderRepository extends BaseRepository<CoffeeOrder, Long> {
    /**
     * 查询
     *
     * @param customer
     * @return
     */
    List<CoffeeOrder> findByCustomerOrderById(String customer);

    /**
     * 查询
     *
     * @param name
     * @return
     */
    List<CoffeeOrder> findByItems_Name(String name);
}
