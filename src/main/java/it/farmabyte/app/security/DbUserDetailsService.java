package it.farmabyte.app.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import it.farmabyte.app.model.ClienteRegistrato;

public class DbUserDetailsService implements UserDetailsService {
    public static ClienteRegistrato[] clienti = new ClienteRegistrato[10]; // per ora è quà, poi lo cambiamo
    public static final int maxclienti = 10;
    public static final boolean initialized = false;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public boolean initialize() {
        for(int i =0; i<maxclienti; i++){
            clienti[i] = new ClienteRegistrato();
        }
        clienti[0].setEmail("federico.chesani@unibo.it");
        clienti[0].setPassword(bCryptPasswordEncoder.encode("password"));
        clienti[1].setEmail("luca.chesani@unibo.it");
        clienti[1].setPassword(bCryptPasswordEncoder.encode("machiè"));
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        for (int i = 0; i < maxclienti; i++) {
            if (clienti[i].getEmail().equals(username)) {
                // ancora non lo utilizziamo, ma serve per dare accesso ai
                // clienti solo a clienti e per i farmacisti solo a farmacisti
                Set grantedAuthorities = new HashSet<>();
                grantedAuthorities.add(new SimpleGrantedAuthority("cliente"));
                return new org.springframework.security.core.userdetails.User(clienti[i].getEmail(),
                        clienti[i].getPassword(), grantedAuthorities);
            }
        }
        throw new UsernameNotFoundException("L'utente non è stato trovato");
    }
}