package br.edu.ifms.lpivlaboratorio04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ws/cliente")
@CrossOrigin(origins = "*")
public class ClienteRestController {
   
    @Autowired
    ClienteBusiness clienteBusiness;

    public ClienteRestController(){
        
    }

    @GetMapping
    public List<Cliente> listar(){
        return clienteBusiness.listar();
    }

    @PostMapping
    public void salvar(@RequestBody Cliente cliente){
       clienteBusiness.salvar(cliente);
    }

    @PutMapping
    public void atualizar(@RequestBody Cliente clienteAtualizado){
       clienteBusiness.atualizar(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id){
        clienteBusiness.remover(id);
    }
}
