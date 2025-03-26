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

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public ResponseDto createTodo(RequestDto dto) {

        Todo todo = new Todo(dto.getName(),dto.getPassword(),dto.getTitle(),dto.getTodo(),dto.getDate());

        Todo createdTodo = todoRepository.createTodo(todo);

        return new ResponseDto(createdTodo);
    }

    @Override
    public ResponseDto findTodoById(Long id) {
        Todo todo = todoRepository.findTodoById(id);
        if (todo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "아이뒤가 존재하지 않습니다 id = " + id);
        }

        return new ResponseDto(todo);
    }
}
