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

        long createdTodo = todoList.isEmpty() ? 1 : Collections.max(todoList.keySet()) + 1;

        todoList.put(createdTodo, todo);

        return todo;
    }
}
