package com.rakshitlabs.springbootangulartodo.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.rakshitlabs.springbootangulartodo.config.Constants;
import com.rakshitlabs.springbootangulartodo.domain.Todo;
import com.rakshitlabs.springbootangulartodo.repository.UserRepository;
import com.rakshitlabs.springbootangulartodo.security.AuthoritiesConstants;
import com.rakshitlabs.springbootangulartodo.service.TodoService;
import com.rakshitlabs.springbootangulartodo.service.UserService;
import com.rakshitlabs.springbootangulartodo.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/*Rest API to view the todo list */

@RestController
@RequestMapping("/api")
public class TodoResource {
    private final Logger log = LoggerFactory.getLogger(TodoResource.class);

    private final TodoService todoService;

    private final UserService userService;

    public TodoResource(TodoService todoService, UserService userService) {
        this.todoService = todoService;
        this.userService = userService;
    }

    @GetMapping("/todos")
    @Timed
    @Secured(AuthoritiesConstants.ADMIN)
    public ResponseEntity getTodoList(){
        return ResponseEntity.ok().body(todoService.findAllTodos());
    }

    @GetMapping("/todos/{login:" + Constants.LOGIN_REGEX + "}")
    @Timed
    @Secured(AuthoritiesConstants.ADMIN)
    public ResponseEntity getTodoListByUser(@PathVariable String login){
        boolean isPresent= userService.getUserWithAuthoritiesByLogin(login)
            .map(UserDTO::new).isPresent();
        return  ResponseEntity.ok().body(isPresent ? todoService.findAllByUser(userService.getUserWithAuthoritiesByLogin(login)
            .map(UserDTO::new).get().getId()): "No user present with the provided login id." );

    }
}
