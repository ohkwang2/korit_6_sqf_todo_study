package com.study.todolist.controller;

import com.study.todolist.dto.request.todo.ReqAddTodoDto;
import com.study.todolist.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/todo")
    public ResponseEntity<?> add(@RequestBody ReqAddTodoDto reqDto) {
//        log.info("{}", reqDto);
        int successCount = todoService.addTodo(reqDto);
        return ResponseEntity.created(null).body(successCount > 0? "successfully saved" : "Failed saving"); // created (post 요청에 많이 사용하는 것 (created = 201 status)
    }

    @GetMapping("/todolist")
    public ResponseEntity<?> getAll() {
//        log.info("{}", reqDto);
        return ResponseEntity.ok().body(todoService.getTodoList());
    }

    @GetMapping("/todo/counts")
    public ResponseEntity<?> getCounts() {
//        log.info("{}", reqDto);
        return ResponseEntity.ok().body(todoService.getTodoCounts());
    }
}
