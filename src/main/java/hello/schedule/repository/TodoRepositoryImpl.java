package hello.schedule.repository;

import hello.schedule.entity.Todo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TodoRepositoryImpl implements TodoRepository{

    private final Map<Long, Todo> todoList = new HashMap<>();
}
