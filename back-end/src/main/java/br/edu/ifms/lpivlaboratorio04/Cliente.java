package br.edu.ifms.lpivlaboratorio04;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Cliente {
    @Id
    @SequenceGenerator(name = "gen_cliente", sequenceName = "seq_cliente" , allocationSize = 1)
    @GeneratedValue(generator = "gen_cliente", strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nome;
    private String email;

    public Cliente(){
        
    }

    public Cliente(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
}
