package com.study.todolist.repository;

import Entity.Todo;
import Entity.TodoCounts;
import com.study.todolist.dto.request.todo.ReqTodoListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // 해당 인터페이스와 mapper xml을 연결시켜주기 위한 어노테이션
public interface TodoMapper {
    int save(Todo todo);
    List<Todo> findAll();
    List<Todo> findTodoListByTitleandDate(ReqTodoListDto reqDto);
    TodoCounts getTodoCounts();
    int changeStatus(int todoId);
    int modifyTodoByTodoId(Todo todo);
    int deletebyTodoId(int todoId);
}
