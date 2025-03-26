package hello.schedule.repository;

import hello.schedule.entity.Todo;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TodoRepositoryImpl implements TodoRepository{

    private final Map<Long, Todo> todoList = new HashMap<>();

    @Override
    public Todo createTodo(Todo todo) {

        long todoId = todoList.isEmpty() ? 1 : Collections.max(todoList.keySet()) + 1;
        todo.setId(todoId);

        todoList.put(todoId, todo);

        return todo;
    }

    @Override
    public Todo findTodoById(Long id) {
        // 공부차원으로 변수로 저장해서 담았습니다.
        Todo todo = todoList.get(id);
        return todo;
    }
}
