package com.study.todolist.dto.request.todo;

import Entity.Todo;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class ReqTodoListDto {
    private int uerId;
    private String title;
    private String dateTime;

    public Todo toEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime todoDateTime = LocalDateTime.parse(dateTime, formatter);  // formatter의 데이터 형식으로 받아온 자료의 형을 변경

        return Todo.builder()
                .userId(uerId)
                .title(title)
                .todoDateTime(todoDateTime)
                .build();
    }
}
