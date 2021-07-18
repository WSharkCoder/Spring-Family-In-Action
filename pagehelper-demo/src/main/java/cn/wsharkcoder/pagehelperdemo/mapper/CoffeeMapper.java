package cn.wsharkcoder.pagehelperdemo.mapper;

import cn.wsharkcoder.pagehelperdemo.model.Coffee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author WSharkCoder
 * @date 2021/07/12
 */
@Mapper
public interface CoffeeMapper {
    /**
     * 根据行数界限查询所有数据
     *
     * @param rowBounds
     * @return
     */
    @Select("select * from t_coffee order by id")
    List<Coffee> findAllWithRowBounds(RowBounds rowBounds);

    /**
     * 根据页数和页间大小查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Select("select * from t_coffee order by id")
    List<Coffee> findAllWithParam(@Param("pageNum") int pageNum,
                                  @Param("pageSize") int pageSize);
}
