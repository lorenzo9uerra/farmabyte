package it.farmabyte.app.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@Order(1)
public class WebSecurityConfigFarma extends WebSecurityConfigurerAdapter {
	public BCryptPasswordEncoder bCryptPasswordEncoder;

	UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// in / o /home possono andare tutti, per qualunque altra sezione bisogna fare
		// login
		http.antMatcher("/farmacia/**").authorizeRequests().antMatchers("/farmacia/login").permitAll().antMatchers("/farmacia/**")
				.hasAuthority("farmacista").and().formLogin()
				.loginPage("/farmacia/login").failureUrl("/farmacia/login?error=loginError").defaultSuccessUrl("/farmacia").permitAll().and()
				.logout().logoutUrl("/farmacia/logout").logoutSuccessUrl("/").deleteCookies("JSESSIONID")
				.and().exceptionHandling().accessDeniedPage("/403")
				.and().csrf().disable();
	}
}