package com.study.todolist.dto.request.todo;

import Entity.Todo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReqModifyTodoDto {
    private int todoId;
    private int userId;
    private String title;
    private String content;
    private int important;
    private int busy;
    private int status;
    private String todoDateTime;

    public Todo toEntity() {
        return Todo.builder()
                .todoId(todoId)
                .userId(userId)
                .title(title)
                .content(content)
                .important(important)
                .busy(busy)
                .status(status)
                .todoDateTime(LocalDateTime.parse(todoDateTime))
                .build();
    }
}
