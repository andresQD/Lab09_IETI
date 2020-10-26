/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.ieti.data;


import eci.ieti.data.model.Todo;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author AndrésQuintero
 */
public interface TodoRepository extends CrudRepository<Todo, Long> {
    
    Page<Todo> findByResponsibleContaining(String responsible, Pageable pageable);
    
   
    
}
