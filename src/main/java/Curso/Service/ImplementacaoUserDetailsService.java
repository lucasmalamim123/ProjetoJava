package Curso.Service;

import Curso.Models.Usuario;
import Curso.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ImplementacaoUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /* consultar no banco o usuario */

        Usuario usuario = usuarioRepository.findUserByLogin(username);
        if(usuario == null){
            throw new UsernameNotFoundException("usuario não foi encontrado");
        }
        return new User(usuario.getLogin(), usuario.getSenha(), usuario.getAuthorities());
    }
}
