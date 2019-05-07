package com.example.demo.seguridad;



import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.model.Usuarios;
import com.example.demo.repositorios.UsuarioRepositorio;




@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UsuarioRepositorio repositorio;
	
	@Override
	protected void configure(AuthenticationManagerBuilder build) throws Exception {
		//Codificamos la contraseña
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		//Creador de usuarios
		UserBuilder users = User.builder().passwordEncoder(encoder::encode);
		//guardamos en memoria un usuario para poder entrar al servicio el cual tiene el rol de admin y user
		/*build.inMemoryAuthentication()
			.withUser(users.username("admin").password("admin").roles("ADMIN", "USER"));*/

		Iterable<Usuarios> usuarios=repositorio.findAll();
		Iterator<Usuarios> iterador = usuarios.iterator();
		
		while(iterador.hasNext()) {
			Usuarios u = iterador.next();
			build.inMemoryAuthentication().withUser(users.username(u.getUsername()).password(u.getPassword()).roles(u.getAuthority()));
			System.out.println(u.getUsername());
		}
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
			.authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.permitAll()
				.and()
			.logout();
		
	}

}
