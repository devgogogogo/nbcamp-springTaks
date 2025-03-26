package hello.schedule.dto;

import lombok.Getter;

//클라이언트에게 요청받을 데이터
//컨트롤러에서 RequestDto를 요청받음
@Getter
public class RequestDto {

    private String name;
    private Integer password;
    private String title;
    private String todo;
    private Integer date;
}
