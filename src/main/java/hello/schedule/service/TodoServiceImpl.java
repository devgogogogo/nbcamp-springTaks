package hello.schedule.service;

import hello.schedule.dto.RequestDto;
import hello.schedule.dto.ResponseDto;
import hello.schedule.entity.Todo;
import hello.schedule.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    //생성자에게 repository를 주입?함으로써 서비스가 repository에게 의존하기 위해
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //인터페이스에 있는 메소드를 구현한 것
    @Override
    public ResponseDto createTodo(RequestDto dto) {

        Todo todo = new Todo(dto.getName(),dto.getPassword(),dto.getTitle(),dto.getTodo(),dto.getDate());

        Todo createdTodo = todoRepository.createTodo(todo);

        return new ResponseDto(createdTodo);
    }
    //인터페이스에 있는 메소드를 구현한 것
    @Override
    public ResponseDto findTodoById(Long id) {
        Todo todo = todoRepository.findTodoById(id);

        //만약 찾을 객체가 없으면? --> 예외처리함
        if (todo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "아이뒤가 존재하지 않습니다 id = " + id);
        }

        return new ResponseDto(todo);
    }
}
