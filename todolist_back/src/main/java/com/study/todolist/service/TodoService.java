package com.study.todolist.service;

import Entity.Todo;
import com.study.todolist.dto.request.todo.ReqAddTodoDto;
import com.study.todolist.dto.request.todo.ReqTodoListDto;
import com.study.todolist.dto.response.todo.RespTodoCountsDto;
import com.study.todolist.dto.response.todo.RespTodoDto;
import com.study.todolist.repository.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoMapper todoMapper;

    // TODO 추가
    public int addTodo(ReqAddTodoDto reqDto) {

        return todoMapper.save(reqDto.toEntity());
    }

    // TODO 리스트 전체 호출
    public List<RespTodoDto> getTodoList(){
        List<Todo> todoList = todoMapper.findAll();
        List<RespTodoDto> dtoList = new ArrayList<>();

        for(Todo todo: todoList) {
            dtoList.add(todo.toTodoDto());
        }

        return dtoList;
    }

    public List<RespTodoDto> getTodoList(ReqTodoListDto reqDto){
        List<Todo> todoList = todoMapper.findTodoListByTitleandDate(reqDto);
        List<RespTodoDto> respTodoList = new ArrayList<>();

        return respTodoList;
    }

    public RespTodoCountsDto getTodoCounts() {
        return todoMapper.getTodoCounts().toDto();
    }
}
