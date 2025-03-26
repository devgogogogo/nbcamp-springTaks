package hello.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoList {

    private Long id;
    private String name;
    private Integer password;
    private String title;
    private String todo;
    private Integer date;

}
