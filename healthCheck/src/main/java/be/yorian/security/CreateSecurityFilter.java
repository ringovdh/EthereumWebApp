package be.yorian.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class CreateSecurityFilter extends WebSecurityConfigurerAdapter {
	
	private static final String USERS_BY_USERNAME = "select username as username, passwd as passwd, user_id as user_id from users where username = ?";
	private static final String AUTHORITIES_BY_USERNAME = "select username as username, discriminator as authorities from users where username = ?";
	@Autowired
	private DataSource dataSource;
	
	@Override
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(USERS_BY_USERNAME)
		.authoritiesByUsernameQuery(AUTHORITIES_BY_USERNAME);
		auth.eraseCredentials(false);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/images/**").antMatchers("/styles/**").antMatchers("/fonts/**").antMatchers("/js/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").and().authorizeRequests().antMatchers("/", "/login").permitAll().antMatchers("/**")
				.authenticated();
	}
}
