/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.ieti.data;

import eci.ieti.data.model.User;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author AndrésQuintero
 */
public interface UserRepository extends MongoRepository<User, String> {
    
    User findByName(String name);

    List<User> findByEmail(String email);
    
}
