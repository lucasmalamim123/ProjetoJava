package Curso.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String numero;

    @JsonIgnore
    @org.hibernate.annotations.ForeignKey(name = "usuario_id")
    @ManyToOne(optional = false)
    private Usuario usuario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
