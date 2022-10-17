package com.example.maintenance_magazine_spare_parts.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Auth extends WebSecurityConfigurerAdapter {

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("test").password(passwordEncoder().encode("test")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/parts")//mają dostęp wszyscy z ROLE_USER
                .hasAnyAuthority("ROLE_USER")
                .antMatchers("/suppliers")//mają dostęp wszyscy z ROLE_ADMIN
                .hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/")
                .permitAll()
                .and()
                .csrf().disable() // wyłączamy zabezpieczenia w celu uzycia postmana
                .headers().frameOptions().disable()
                .and()
                .formLogin()//wskazuje, że teraz będziemy konfigurować forlmularz uwierzytelniania
                .loginPage("/login")//wskazuje endpoint w którym będzie sieodbywać uwierzytelnienie
                .usernameParameter("username")//nadajemy nazwę jaka będzie jako name w inpucie loginu w form
                .passwordParameter("password")//nadajemy nazwę jaka będzie jako name w inpucie password w form
                .loginProcessingUrl("/login")
                .failureForwardUrl("/login?error")//co sie stanie w momencie błędnego wpisania usern,passwr
                .defaultSuccessUrl("/spareParts")// co się stanie w momencie prawidłowego wpisania login,passw
                .and()
                .logout()//tutaj mówimy springowi, że będziemy obsługiwać mu logout
                .logoutSuccessUrl("/login");
    }
}
