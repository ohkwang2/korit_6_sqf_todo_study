package com.study.todolist.dto.request.todo;

import Entity.Todo;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class ReqAddTodoDto {
    private String title;
    private String content;
    private String dateTime;
    private int important;
    private int busy;

    public Todo toEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime todoDateTime = LocalDateTime.parse(dateTime + ":00", formatter);  // formatter의 데이터 형식으로 받아온 자료의 형을 변경

        return Todo.builder()
                .title(title)
                .content(content)
                .important(important)
                .busy(busy)
                .todoDateTime(todoDateTime)
                .build();
    }
}