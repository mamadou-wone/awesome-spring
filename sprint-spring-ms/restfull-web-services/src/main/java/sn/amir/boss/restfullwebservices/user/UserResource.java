package sn.amir.boss.restfullwebservices.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDAOService service;

    public UserResource(UserDAOService service) {
        this.service = service;
    }

    //GET /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    //GET /users
    @GetMapping("/users/{id}")
    public User retrieveUsersById(@PathVariable Integer id){
        User findUser = service.findById(id);
        if (findUser == null){
            throw new UserNotFoundException("id: " + id);
        }
        return findUser;
    }

    //POST /users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
       User saveUser =  service.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    //GET /users
    @DeleteMapping("/users/{id}")
    public void deleteUsersById(@PathVariable Integer id){
        System.out.println(id);
        service.deleteById(id);
    }

}
