package cn.wsharkcoder.mybatisdemo.mapper;

import cn.wsharkcoder.mybatisdemo.entity.Coffee;
import org.apache.ibatis.annotations.*;

/**
 * @author WSharkCoder
 * @date 2021/07/10
 */
@Mapper
public interface CoffeeMapper {
    /**
     * 保存Coffee
     *
     * @param coffee
     * @return
     */
    @Insert("insert into t_coffee (name, price, create_time, update_time)"
            + "values (#{name}, #{price}, now(), now())")
    @Options(useGeneratedKeys = true)
    int save(Coffee coffee);

    /**
     * 根据ID查询数据
     *
     * @param id
     * @return
     */
    @Select("select * from t_coffee where id =#{id}")
    @Results(
            {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "create_time", property = "createTime")
                    // mybatis.configuration.map-underscore-to-camel-case=true 实现同样效果
            }
    )
    Coffee findById(@Param("id") Long id);
}
