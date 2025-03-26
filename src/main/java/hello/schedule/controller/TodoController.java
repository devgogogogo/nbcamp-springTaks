package hello.schedule.controller;

import hello.schedule.dto.RequestDto;
import hello.schedule.dto.ResponseDto;
import hello.schedule.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> findAllTodo(@RequestBody RequestDto requestDto) {

        return new ResponseEntity<>(todoService.creatTodo(requestDto), HttpStatus.OK);
    }
}
