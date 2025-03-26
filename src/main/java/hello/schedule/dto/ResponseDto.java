package hello.schedule.dto;

import hello.schedule.entity.Todo;
import lombok.Getter;

//클라이언트에게 ResponseDto 로 보내줌
//모든 데이터를 보여주면 안됨
@Getter
public class ResponseDto {

    private Long id;
    private String name;
    private String title;
    private String todo;
    private Integer date;

    public ResponseDto(Todo todo) {
        this.id = todo.getId();
        this.name = todo.getName();
        this.title = todo.getTitle();
        this.todo = todo.getTodo();
        this.date = todo.getDate();
    }
}
