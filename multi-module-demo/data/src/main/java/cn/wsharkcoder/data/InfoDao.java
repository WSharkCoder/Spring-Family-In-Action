package cn.wsharkcoder.data;

import org.springframework.stereotype.Repository;

/**
 * @Author WSharkCoder
 * @Date 2022/08/15
 */
@Repository
public class InfoDao {
    public int saveInfo(String info) {
        System.out.println(info + "have saved in the db.");
        return 1;
    }
}
