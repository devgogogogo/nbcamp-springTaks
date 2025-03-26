package hello.schedule.service;

import hello.schedule.dto.RequestDto;
import hello.schedule.dto.ResponseDto;

import java.util.List;

public interface TodoService {

    ResponseDto createTodo(RequestDto requestDto);

    ResponseDto findTodoById(Long id);
}
