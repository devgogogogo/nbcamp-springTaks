package hello.schedule.service;

import hello.schedule.dto.RequestDto;
import hello.schedule.dto.ResponseDto;

public interface TodoService {

    ResponseDto createTodo(RequestDto requestDto);
}
