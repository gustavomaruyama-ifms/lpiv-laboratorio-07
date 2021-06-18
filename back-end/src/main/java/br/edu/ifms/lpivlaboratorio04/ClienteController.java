package br.edu.ifms.lpivlaboratorio04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteBusiness clienteBusiness;

    public ClienteController(){

    }

    @GetMapping("/listagem")
    public ModelAndView listagem(){
        List<Cliente> clientes = clienteBusiness.listar();
        ModelAndView modelAndView = new ModelAndView("cliente/listagem");
        modelAndView.addObject("clientes", clientes);
        return modelAndView;
    }

    @GetMapping("/formulario")
    public String formulario(Cliente cliente){
        return "cliente/formulario";
    }

    @GetMapping("/formulario/{id}")
    public ModelAndView formularioEdicao(@PathVariable Integer id){
        List<Cliente> clientes = clienteBusiness.listar();
        ModelAndView modelAndView = new ModelAndView("cliente/formulario");
        for(Cliente cliente: clientes){
            if(cliente.getId().equals(id)){
                modelAndView.addObject("cliente", cliente);
                break;
            }
        }
        return modelAndView;
    }

    @PostMapping("/salvar")
    public String salvar(Cliente cliente){
        clienteBusiness.salvar(cliente);
        return "redirect:/cliente/listagem";
    }

    @PostMapping("/atualizar")
    public String atualizar(Cliente clienteAtualizado){
        clienteBusiness.atualizar(clienteAtualizado);
        return "redirect:/cliente/listagem";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Integer id){
        clienteBusiness.remover(id);
        return  "redirect:/cliente/listagem";
    }
    
}
