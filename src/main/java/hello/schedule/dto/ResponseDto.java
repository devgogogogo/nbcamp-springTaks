package hello.schedule.dto;

import hello.schedule.entity.Todo;
import lombok.Getter;

@Getter
public class ResponseDto {

    private String name;
    private String title;
    private String todo;
    private Integer date;

    public ResponseDto(Todo todo) {
        this.name = todo.getName();
        this.title = todo.getTitle();
        this.todo = todo.getTodo();
        this.date = todo.getDate();
    }
}
