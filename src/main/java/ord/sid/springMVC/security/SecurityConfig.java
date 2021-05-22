package ord.sid.springMVC.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// super.configure(auth);*
		PasswordEncoder passwordEncoder = passwordEncoder();
		System.out.println("-------------------------");
		System.out.println(passwordEncoder.encode("1234"));
		System.out.println("-------------------------");
		auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder.encode("1234")).roles("user");
		auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder.encode("1234")).roles("user");
		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("1234")).roles("user", "admin");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		// http.httpBasic();
		http.authorizeRequests().antMatchers("/save**/**", "/delete**/**","/form**/**").hasRole("admin");
		http.authorizeRequests().anyRequest().authenticated();
		http.csrf();
		http.exceptionHandling().accessDeniedPage("/NotAuthorized");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
