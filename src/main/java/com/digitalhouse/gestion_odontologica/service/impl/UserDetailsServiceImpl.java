package com.digitalhouse.gestion_odontologica.service.impl;

import com.digitalhouse.gestion_odontologica.entity.Usuario;
import com.digitalhouse.gestion_odontologica.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Buscar usuario de DB
        log.info(encoder.encode("toor"));

        Usuario usuario = usuarioRepository.findUsuarioByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario  no encontrado"));

        //Lista de Permisos/Roles. En NUESTRO caso solo tienen un ROL.
        Set<GrantedAuthority> grantList = new HashSet<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuario.getRol().toString());
        grantList.add(grantedAuthority);


        //Devuelvo un usuario de Spring
        UserDetails user = new User(usuario.getUsername(), usuario.getPassword(), grantList);

        return user;
    }



}