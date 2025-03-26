package hello.schedule.repository;

import hello.schedule.entity.Todo;

public interface TodoRepository {


    Todo createTodo(Todo todo);

    Todo findTodoById(Long id);

    void deleteTodl(Long id);
}
