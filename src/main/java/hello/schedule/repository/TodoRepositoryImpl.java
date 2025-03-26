package hello.schedule.repository;

import hello.schedule.entity.Todo;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TodoRepositoryImpl implements TodoRepository{

    //DB역할을함. 아직 mysql을 못배워서 배열에 담았습니다 ㅠㅠ
    private final Map<Long, Todo> todoList = new HashMap<>();

    @Override
    public Todo createTodo(Todo todo) {

        //아이디를 비어있으면 "1"로 응답 그게 아니면 todoList안에 있는 키값의 가장 높은값 + 1 해줌
        long todoId = todoList.isEmpty() ? 1 : Collections.max(todoList.keySet()) + 1;

        //'todo'객체에 추가함
        todo.setId(todoId);

        // DB에 저장
        todoList.put(todoId, todo);

        return todo;
    }

    @Override
    public Todo findTodoById(Long id) {
        // 공부 차원으로 변수로 저장해서 담았습니다.
        Todo todo = todoList.get(id);
        return todo;
    }

    @Override
    public void deleteTodl(Long id) {
        todoList.remove(id);
    }
}
