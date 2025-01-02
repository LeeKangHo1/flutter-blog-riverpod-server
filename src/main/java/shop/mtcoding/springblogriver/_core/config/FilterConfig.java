package shop.mtcoding.springblogriver._core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shop.mtcoding.springblogriver._core.auth.JwtAuthorizationFilter;

@Slf4j
@Configuration
public class FilterConfig {

    @Bean
    FilterRegistrationBean<JwtAuthorizationFilter> jwtAuthorizationFilter() {
        log.debug("JwtAuthorizationFilter scan");
        FilterRegistrationBean<JwtAuthorizationFilter> bean =
                new FilterRegistrationBean<>(new JwtAuthorizationFilter());
        bean.addUrlPatterns("/api/*");
        bean.setOrder(0);
        return bean;
    }

}
