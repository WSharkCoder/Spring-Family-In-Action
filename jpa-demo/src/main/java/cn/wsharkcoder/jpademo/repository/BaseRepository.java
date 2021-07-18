package cn.wsharkcoder.jpademo.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author WSharkCoder
 * @date 2021/07/09
 */
@NoRepositoryBean
public interface BaseRepository<T, Long> extends PagingAndSortingRepository<T, Long> {
    /**
     * 查询
     * @return
     */
    List<T> findTop3ByOrderByUpdateTimeDescIdAsc();
}
