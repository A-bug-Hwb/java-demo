package com.demo.config;

import com.demo.auth.JWTAuthenticationEntryPoint;
import com.demo.auth.JWTAuthorizationFilter;
import com.demo.auth.handle.LogoutSuccessHandlerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    /** 退出处理类 */
    @Autowired
    private LogoutSuccessHandlerImpl logoutSuccessHandler;

    @Autowired
    private CorsFilter corsFilter;

    /** token认证过滤器 */
    @Autowired private JWTAuthorizationFilter jwtAuthorizationFilter;

    /**
     * 解决 无法直接注入 AuthenticationManager
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Primary
    public AuthenticationManager AuthenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



    /**
     * 安全配置
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // CSRF禁用，因为不使用session
                .csrf().disable()
                //异常处理
                .exceptionHandling()
                .authenticationEntryPoint(new JWTAuthenticationEntryPoint())
                .and()
                // 基于token，所以不需要session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //过滤请求
                .authorizeRequests()
                //访问/data路径下的请求需要admin
//                .antMatchers("/data/**").hasRole("admin")
                //对登录做放行，生成token
                .antMatchers("/login","/register","/druid/**").anonymous()
                .antMatchers("/*.html").permitAll()
                .antMatchers("/*.mp4").permitAll()
                .antMatchers("/*.png").permitAll()
                .antMatchers("/*.jpg").permitAll()
                .antMatchers("/*.jpeg").permitAll()
                .antMatchers("/*.css").permitAll()
                .antMatchers("/*.js").permitAll()
                .antMatchers("/*.ico").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/swagger/**").permitAll()
                .antMatchers("/swagger-ui/**").permitAll()
                .antMatchers("/swagger-resources").permitAll()
                .antMatchers("/v2/**").permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest()
                .authenticated();

        httpSecurity.logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler);
        // 添加JWT filter
        httpSecurity.addFilterBefore(
                jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

        // 添加CORS filter
        httpSecurity.addFilterBefore(corsFilter, JWTAuthorizationFilter.class);
        httpSecurity.addFilterBefore(corsFilter, LogoutFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    //使用BCryptPasswordEncoder密码加密
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //跨域配置
    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //注册跨域配置
        source.registerCorsConfiguration("/**",new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
