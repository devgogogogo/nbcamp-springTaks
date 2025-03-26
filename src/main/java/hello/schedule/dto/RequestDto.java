package hello.schedule.dto;

import lombok.Getter;

@Getter
public class RequestDto {

    private Long id;
    private String name;
    private Integer password;
    private String title;
    private String todo;
    private Integer date;

}
