package br.edu.ifms.lpivlaboratorio04;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteResource extends JpaRepository<Cliente,Integer>{
    
}
