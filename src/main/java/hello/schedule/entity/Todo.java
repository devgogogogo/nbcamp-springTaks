package hello.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Todo {

    @Setter
    private Long id;
    private String name;
    private Integer password;
    private String title;
    private String todo;
    private Integer date;


    public Todo(String name, Integer password, String title, String todo, Integer date) {
        this.name = name;
        this.password = password;
        this.title = title;
        this.todo = todo;
        this.date = date;
    }
}
