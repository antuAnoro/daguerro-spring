package app.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import app.services.UserService;

@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class ApplicationSecurityAdapter extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties security;

    @Autowired
    private UserService userService;
    
    @Value("${app.secret}")
    private String applicationSecret;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
	        .authorizeRequests()
		        .antMatchers("/","/public/**","user/activate","/css/**","/js/**").permitAll()
		        .antMatchers("/admin/**").hasRole("ADMIN")
		        .anyRequest().authenticated()
		        .and()
	        .formLogin()
	        	.loginPage("/public/login")
	        	.defaultSuccessUrl("/public/refresh")
	            .failureUrl("/public/login?error")
	        	.and()
	        .logout()
	            .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
	            .logoutSuccessUrl("/public/refresh")
	            .and()
	        .rememberMe()
	        	.key(applicationSecret)
	            .tokenValiditySeconds(31536000)
        		.and()
        	.csrf().disable()
        	// Permito usar frames si mismo origen
       		.headers().frameOptions().sameOrigin();
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    	// Meto un usuario administrador a pincho
    	auth.inMemoryAuthentication().withUser("user").password("passUser").roles("USER");
    	auth.inMemoryAuthentication().withUser("admin").password("passAdmin").roles("ADMIN");
    	// Introducimos el servicio del que consultar el resto de usuarios
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    
}
