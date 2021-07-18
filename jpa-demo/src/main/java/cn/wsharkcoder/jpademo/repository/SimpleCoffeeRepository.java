package cn.wsharkcoder.jpademo.repository;

import cn.wsharkcoder.jpademo.model.Coffee;
import org.springframework.data.repository.CrudRepository;

/**
 * @author WSharkCoder
 * @date 2021/07/09
 */
public interface SimpleCoffeeRepository extends CrudRepository<Coffee, Long> {
}
