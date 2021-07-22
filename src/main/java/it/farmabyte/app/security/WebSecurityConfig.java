package it.farmabyte.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import it.farmabyte.app.services.DbUserDetailsService;

@Configuration
@EnableWebSecurity
@Order(2)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	public BCryptPasswordEncoder bCryptPasswordEncoder;

	UserDetailsService userDetailsService;

	@Bean
	public UserDetailsService userDetailsService() {
		return new DbUserDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManager();
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/home", "/registrazione", "/resources/**", "/hintFarmaco", "/hintComune").permitAll()
				.antMatchers("/farmacia/login", "/farmacia_login").permitAll().antMatchers("/farmacia/**")
				.hasAuthority("farmacista").antMatchers("/nuovaprenotazione", "/prenotazioni").hasAuthority("cliente")
				.anyRequest().hasAuthority("cliente").and().formLogin().loginPage("/login").permitAll().and().logout()
				.logoutUrl("/logout").logoutSuccessUrl("/").deleteCookies("JSESSIONID").and().exceptionHandling()
				.accessDeniedPage("/403").and().csrf().disable();
	}
}