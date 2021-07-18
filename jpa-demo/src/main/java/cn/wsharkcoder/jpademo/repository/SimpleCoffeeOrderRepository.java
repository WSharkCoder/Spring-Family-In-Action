package cn.wsharkcoder.jpademo.repository;

import cn.wsharkcoder.jpademo.model.CoffeeOrder;
import org.springframework.data.repository.CrudRepository;

/**
 * @author WSharkCoder
 * @date 2021/07/09
 */
public interface SimpleCoffeeOrderRepository extends CrudRepository<CoffeeOrder, Long> {
}
