package Curso.Controller;

import Curso.Models.Usuario;
import Curso.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuario")
public class IndexController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping(value = "/{id}/codigovenda/{venda}", produces = "application/pdf")
    public ResponseEntity<Usuario> relatorio(@PathVariable(value = "id") Long id){

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Usuario> init(@PathVariable(value = "id") Long id){

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity <List<Usuario>> usuario(){
        List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();
        return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
         Usuario usuariosalvo = usuarioRepository.save(usuario);
         return new ResponseEntity<Usuario>(usuariosalvo, HttpStatus.OK);
    }
     @PostMapping(value = "/vendausuario", produces = "application/json")
    public ResponseEntity<Usuario> cadastrarvenda(@RequestBody Usuario usuario){

         Usuario usuariosalvo = usuarioRepository.save(usuario);

         return new ResponseEntity<Usuario>(usuariosalvo, HttpStatus.OK);
    }

}
