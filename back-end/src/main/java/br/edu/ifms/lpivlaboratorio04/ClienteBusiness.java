package br.edu.ifms.lpivlaboratorio04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteBusiness {
    @Autowired
    ClienteResource resource;

   public ClienteBusiness(){
       
   }

   public List<Cliente> listar(){
      return resource.findAll();
   }

   public void salvar(Cliente cliente){
      resource.save(cliente);
   }

   public void atualizar(Cliente clienteAtualizado){
      resource.save(clienteAtualizado);
   }

   public void remover(Integer id){
     resource.deleteById(id);
   }
}
