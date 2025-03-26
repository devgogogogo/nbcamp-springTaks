package hello.schedule.service;

import hello.schedule.dto.RequestDto;
import hello.schedule.dto.ResponseDto;
import hello.schedule.entity.Todo;
import hello.schedule.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public ResponseDto createTodo(RequestDto dto) {

        Todo todo = new Todo(dto.getName(),dto.getPassword(),dto.getTitle(),dto.getTodo(),dto.getDate());

        todoRepository.createTodo(todo);

        return new ResponseDto();
    }
}
