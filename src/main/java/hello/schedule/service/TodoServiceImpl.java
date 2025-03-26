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

    @Override
    public ResponseDto updateTodo(Long id, String title, String name, String todo) {
                          //조회로 불러온다. -->>위에 구현한것을 재활용할수 있다.
        Todo foundTodo = todoRepository.findTodoById(id);

        if (foundTodo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "아이뒤가 존재하지 않습니다 id = " + id);
        }
        if (title == null || name == null || todo == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "올려놓은 todo가 존재하지 않습니다.");
        }

        // 내일 아침에 질문할거 !
//        Todo todo1 = new Todo(name, title, todo); //새로운 시도로 해봤는데. (X) --> 반환DTO에 id,date값이 null값이 나온다.
        foundTodo.updateTodo(name, title, todo);

        return new ResponseDto(foundTodo);
    }

    @Override
    public void deleteTodo(Long id) {
        Todo foundTodo = todoRepository.findTodoById(id);
        if (foundTodo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "아이뒤가 존재하지 않습니다 id = " + id);
        }
        todoRepository.deleteTodl(id);
    }
}
