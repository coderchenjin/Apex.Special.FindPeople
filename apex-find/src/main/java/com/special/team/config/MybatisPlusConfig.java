package com.special.team.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.special.team.datasource.DruidProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus配置
 *
 */
@Configuration
//@Order(2)
@MapperScan(basePackages = {"com.special.team.*.dao"})
public class MybatisPlusConfig {

    @Autowired
    DruidProperties druidProperties;

    //@Autowired
    //MutiDataSourceProperties mutiDataSourceProperties;

    /**
     * 另一个数据源
     */
//    private DruidDataSource bizDataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        druidProperties.config(dataSource);
//        mutiDataSourceProperties.config(dataSource);
//        return dataSource;
//    }

    /**
     * ws的数据源
     */
    private DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    /**
     * 单数据源连接池配置
     */
    @Bean
    @ConditionalOnProperty(prefix = "ws", name = "muti-datasource-open", havingValue = "false")
    public DruidDataSource singleDatasource() {
        return dataSource();
    }

//    /**
//     * 多数据源连接池配置
//     */
//    @Bean
//    @ConditionalOnProperty(prefix = "ws", name = "muti-datasource-open", havingValue = "true")
//    public DynamicDataSource mutiDataSource() {
//
//        DruidDataSource dataSourceGuns = dataSourceGuns();
//        DruidDataSource bizDataSource = bizDataSource();
//
//        try {
//            dataSourceGuns.init();
//            bizDataSource.init();
//        } catch (SQLException sql) {
//            sql.printStackTrace();
//        }
//
//        DynamicDataSource dynamicDataSource = new DynamicDataSource();
//        HashMap<Object, Object> hashMap = new HashMap();
//        hashMap.put(DatasourceEnum.DATA_SOURCE_GUNS, dataSourceGuns);
//        hashMap.put(DatasourceEnum.DATA_SOURCE_BIZ, bizDataSource);
//        dynamicDataSource.setTargetDataSources(hashMap);
//        dynamicDataSource.setDefaultTargetDataSource(dataSourceGuns);
//        return dynamicDataSource;
//    }

    /**
     * mybatis-plus分页插件
     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        return new PaginationInterceptor();
//    }

    /**
     * 数据范围mybatis插件
     */
//    @Bean
//    public DataScopeInterceptor dataScopeInterceptor() {
//        return new DataScopeInterceptor();
//    }

    /**
     * 乐观锁mybatis插件
     */
//    @Bean
//    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
//        return new OptimisticLockerInterceptor();
//    }

}
