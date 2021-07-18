package cn.wsharkcoder.mongorepositorydemo.repository;

import cn.wsharkcoder.mongorepositorydemo.model.Coffee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author WSharkCoder
 * @date 2021/07/14
 */
public interface CoffeeRepository extends MongoRepository<Coffee, String> {
    List<Coffee> findByName(String name);

}
