package com.jcb.spring.json.config.beanUtil;

import com.jcb.spring.json.config.beanUtil.bean.BasicConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.jcb.spring.json.config.dao"}, sqlSessionTemplateRef = "userSqlSessionTemplate")
public class DateSourceBeanFactory {
    @Autowired
    private BasicConfig basicConfig;

    @Bean
    @Primary
    public DataSource buildDatasource(){
        String driveClassName="com.mysql.jdbc.Driver";
        //"jdbc:mysql://192.168.12.218:3305/jcb_strategy"
        String url="jdbc:mysql://"+basicConfig.getMysqlConfig().getHost()+":"+basicConfig.getMysqlConfig().getPort()+"/"+basicConfig.getMysqlConfig().getName() ;
        String username=basicConfig.getMysqlConfig().getUsername();
        String password=basicConfig.getMysqlConfig().getPassword();
    return DataSourceBuilder.create().driverClassName(driveClassName).url(url).username(username).password(password).build();
    }

    @Bean
    public SqlSessionFactory userSqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath*:com/jcb/spring/json/config/mapping/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    @Bean
    public SqlSessionTemplate userSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }

}
