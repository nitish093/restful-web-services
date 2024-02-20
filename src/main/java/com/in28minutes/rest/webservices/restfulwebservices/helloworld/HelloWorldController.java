package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import com.in28minutes.rest.webservices.restfulwebservices.helloworld.entity.User;
import com.in28minutes.rest.webservices.restfulwebservices.helloworld.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.parser.Entity;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

//REST API
@RestController
public class HelloWorldController {

    private UserService userService;

    @Autowired
    public HelloWorldController(UserService userService)
    {
        this.userService = userService;
    }

    //@RequestMapping(method = RequestMethod.GET, path = "/hello-world")             //Give specific URL to this method using @RequestMapping()
    @GetMapping("/hello-world")
    public ResponseEntity<Map<String,String>> helloWorld()
    {
        Map<String,String> map = new HashMap<>();
        map.put("message","Hello World");
       return ResponseEntity.ok(map);
    }

    @PostMapping("/users")
    public ResponseEntity<User> create(@Valid @RequestBody User user)
    {
        System.out.println("Input User: "+user);
        User savedUser = userService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedUser);
    }

    @GetMapping("/users")
    public List<User> allUsers()
    {
        return userService.findAll();
    }

    //HATEOAS
    //EntityModel
    //WebMvcLinkBuilder
    @GetMapping("/users/{id}")
    public EntityModel<User> getUserById(@PathVariable Integer id)
    {
        User user = userService.getUserById(id);
        EntityModel entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).allUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

}
