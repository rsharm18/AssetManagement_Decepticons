package com.decepticons.assetManagement.security;

//@Configuration
//@EnableWebSecurity
public class AssetManagementSecurityConfig {
	// extends WebSecurityConfigurerAdapter
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		System.out.println("&&&&&&&&&&&&&&& from security config ");
//		http.authorizeRequests().antMatchers("/", "/home", "/login").permitAll().anyRequest().permitAll().and().formLogin().loginPage("/userAuth/login").permitAll().and().logout().permitAll();
//	}
//
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		System.out.println("&&&&&&&&&&&&&&& from encoder config");
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		auth.authenticationProvider(dbAuthenticationProvider());
//	}
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	public DaoAuthenticationProvider dbAuthenticationProvider() {
//		System.out.println("&&&&&&&&&&&&&&& from DAO ");
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		authProvider.setUserDetailsService(userDetailsService);
//		authProvider.setPasswordEncoder(passwordEncoder());
//		return authProvider;
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		System.out.println("&&&&&&&&&&&&&&& encoder initlaized");
//		return new BCryptPasswordEncoder();
//	}
}