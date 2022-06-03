package com.example.buurttuindeelopdracht2.Config;

import com.example.buurttuindeelopdracht2.JwtFilter.JwtRequestFilter;
import com.example.buurttuindeelopdracht2.Services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtService jwtService;


//    private final DataSource dataSource;
//    @Autowired
//    public SecurityConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }





    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }




//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//
//                .inMemoryAuthentication()
//                .withUser("karel").password("{noop}appel").roles("ARTIST");
//
//
////                .jdbcAuthentication()
////                .dataSource(dataSource)
////                .usersByUsernameQuery("select userName, password, enabled "
////                        + "from Buren "
////                        + "where userName=?")
////                .authoritiesByUsernameQuery("select userName, role "
////                        +"from Buren "
////                        +"where userName=?");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests().antMatchers(HttpMethod.POST, "/auth").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .addFilterBefore(new JwtRequestFilter(jwtService, userDetailsService()), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable();
    }
}
