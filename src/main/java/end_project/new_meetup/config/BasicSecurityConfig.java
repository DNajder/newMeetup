package end_project.new_meetup.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/home", "home").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/login")
                .loginProcessingUrl("/login-process")
                .usernameParameter("emial")
                .passwordParameter("password")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/home");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT u.email, u.password_hash, 1 FROM user u WHERE u.email = ?")
                .authoritiesByUsernameQuery("SELECT u.email, u.password_hash, 1 FROM user u WHERE u.email = ?")
                .passwordEncoder(passwordEncoder);
    }
}
