package Curso.Security;


import Curso.Service.ImplementacaoUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/*mapeia urls, endereços ... autoriza ou bloqueia acesso */
@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private ImplementacaoUserDetailsService implementacaoUserDetailsService;

    /*configura as solicitacoes de acesso por http*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*ativando a protecao de usuarios que não estao validados por token*/
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())

        /*ativando a permissao para acesso a pagina inicial do sistema*/
                .disable().authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/index").permitAll()
        /*URL de logout - redimencionar após o user deslogar do sistema*/
                .anyRequest().authenticated().and().logout().logoutSuccessUrl("index.html")
        /*mapeia URL de logout e invalida usuario*/
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

        /*filtra as requisiçoes de login para autenticacao*/

        /*filtra demais requisiçoes para verificar a presença de TOKEN JWT no HEADER HTTP*/


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /*service que irá consultar o usuario no banco de dados*/
        auth.userDetailsService(implementacaoUserDetailsService)
                /*padrao que codificacao de senha*/
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
