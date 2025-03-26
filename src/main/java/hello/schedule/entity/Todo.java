package hello.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// 데이터베이스의 매핑되는 객체이다.
//entity객체는 데이터베이스에 실질적으로 저장됨
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
