package vn.edu.tto.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import vn.edu.tto.domain.User;
import vn.edu.tto.mapper.UserMapper;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    private Collection<GrantedAuthority> grantedAuthorities;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findUserByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        grantedAuthorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole());
        grantedAuthorities.add(grantedAuthority);

        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword() == null ? "" : user.getPassword(), grantedAuthorities);
    }

}
