package it.farmabyte.app.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import it.farmabyte.app.controller.MockSingletonDatabase;
import it.farmabyte.app.model.ClienteRegistrato;

public class DbUserDetailsService implements UserDetailsService {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    MockSingletonDatabase db = MockSingletonDatabase.getDatabaseInstance();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ClienteRegistrato cliente = db.findByUsername(username);
        if(cliente != null){
                Set grantedAuthorities = new HashSet<>();
                grantedAuthorities.add(new SimpleGrantedAuthority("cliente"));
            return new org.springframework.security.core.userdetails.User(cliente.getEmail(), cliente.getPassword(), grantedAuthorities);
        }
        throw new UsernameNotFoundException("L'utente non è stato trovato");
    }
}