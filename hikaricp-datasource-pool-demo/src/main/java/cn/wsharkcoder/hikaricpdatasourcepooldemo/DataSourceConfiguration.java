package cn.wsharkcoder.hikaricpdatasourcepooldemo;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;


/**
 * @author WSharkCoder
 * @date 2021/07/04
 */
@Configuration
public class DataSourceConfiguration {
    /**
     * 当class path中有HikariDataSource类
     */
    @ConditionalOnClass(HikariDataSource.class)
    /**
     * 同时Spring上下文中没有配置DataSource的bean
     */
    @ConditionalOnMissingBean(DataSource.class)
    /**
     * 而且spring.datasource.type属性的值是com.zaxxer.hikari.HikariDataSource时执行如下配置
     */
    @ConditionalOnProperty(name = "spring.datasource.type", havingValue = "com.zaxxer.hikari.HikariDataSource", matchIfMissing = true)
    static class Hikari {
        @Bean
        @ConfigurationProperties(prefix = "spring.datasource.hikari")
        public HikariDataSource dataSource(DataSourceProperties properties) {
            HikariDataSource dataSource = createDataSource(properties, HikariDataSource.class);
            if (StringUtils.hasText(properties.getName())) {
                //设置连接池名
                dataSource.setPoolName(properties.getName());
            }
            return dataSource;
        }
    }

    @Qualifier
    private static HikariDataSource createDataSource(DataSourceProperties properties, Class<? extends DataSource> cls) {
        DataSource dataSource = properties.initializeDataSourceBuilder().build();
        HikariDataSource res = null;
        if (cls == dataSource.getClass()) {
            res = (HikariDataSource) dataSource;
        }
        return res;

    }
}
