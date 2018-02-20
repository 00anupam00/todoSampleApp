package com.rakshitlabs.springbootangulartodo.service;


import com.rakshitlabs.springbootangulartodo.domain.Todo;
import com.rakshitlabs.springbootangulartodo.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class for to-do lists.
 */
@Service
@Transactional
public class TodoService {

    private final Logger log = LoggerFactory.getLogger(TodoService.class);

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAllTodos(){
        return todoRepository.findAll();
    }

    public List<Todo> findAllByUser(long userId){
        return todoRepository.findAllByUser(userId);
    }
}
