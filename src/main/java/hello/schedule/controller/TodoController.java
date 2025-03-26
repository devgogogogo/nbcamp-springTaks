package hello.schedule.controller;

import hello.schedule.dto.RequestDto;
import hello.schedule.dto.ResponseDto;
import hello.schedule.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createTodo(@RequestBody RequestDto requestDto) {

        return new ResponseEntity<>(todoService.createTodo(requestDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findTodoById(@PathVariable Long id) {

        return new ResponseEntity<>(todoService.findTodoById(id),HttpStatus.OK);
    }
}
