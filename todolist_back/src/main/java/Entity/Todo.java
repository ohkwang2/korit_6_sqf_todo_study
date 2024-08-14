package Entity;

import com.study.todolist.dto.response.todo.RespTodoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private int todoId;
    private int userId;
    private String title;
    private String content;
    private int important;
    private int busy;
    private int status;
    private LocalDateTime todoDateTime;

    public RespTodoDto toTodoDto() {
        return RespTodoDto.builder()
                .todoId(todoId)
                .userId(userId)
                .title(title)
                .content(content)
                .important(important)
                .busy(busy)
                .status(status)
                // format 형태로 바꿔서 String 자료 타입으로 리턴해줌
                .todoDateTime(todoDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                .build();
    }
}
