package hello.schedule.controller;

import hello.schedule.dto.RequestDto;
import hello.schedule.dto.ResponseDto;
import hello.schedule.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 클라이언트의 요청을 처리하고, 서비스에게 요청하는 역할
@RestController // @Controller + @RequestBody 합친것
@RequestMapping("/todos")
public class TodoController {


    private final TodoService todoService;

    //생성자에게 서비스를 주입?함으로써 컨트롤러가 서비스에게 의존하기 위해
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    //Create
    //RequestBody를 입력하면 클라이언트에게 ResponseDto로 반환
    //서비스단으로 넘겨줌
    @PostMapping
    public ResponseEntity<ResponseDto> createTodo(@RequestBody RequestDto dto) {

        return new ResponseEntity<>(todoService.createTodo(dto), HttpStatus.OK);
    }
    //Read (단건조회)
    //식별자 {id}를 조회하면 클라이언트에게 ResponseDto 반환
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findTodoById(@PathVariable Long id) {

        return new ResponseEntity<>(todoService.findTodoById(id),HttpStatus.OK);
    }
}
