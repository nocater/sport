package sport.config;


import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.pagehelper.PageInterceptor;

@Configuration
public class PageHelperConfiguration {
    private static final Logger log = LoggerFactory.getLogger(PageHelperConfiguration.class);
    
    @Bean
    public PageInterceptor pageHelper() {
        log.info("MyBatis PageHelper: Registed");
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties prop = new Properties();
        prop.setProperty("helperDialect", "mysql");
        prop.setProperty("reasonable", "true");  //当该参数设置为 true 时，pageNum<=0 时会查询第一页， pageNum>pages（超过总数时），会查询最后一页
        prop.setProperty("pageSizeZero", "true");//pageSize=0 查询所有结果
        pageInterceptor.setProperties(prop);
        return pageInterceptor;
    }
    
}