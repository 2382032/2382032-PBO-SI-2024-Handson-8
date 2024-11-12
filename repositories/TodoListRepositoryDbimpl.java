package repositories;

import config.Database;
import entities.TodoList;

import javax.management.loading.ClassLoaderRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoListRepositoryDbimpl implements TodoListRepository {

    private final Database databse;

    public TodoListRepositoryDbimpl(Database databse) {
        this.databse = databse;
    }

    @Override
    public TodoList[] getAll() {
        Connection connection = databse.getConnection();
        String sqlStatement = "SELECT * FROM todos";
        List<TodoList> todoLists = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                TodoList todoList = new TodoList();
                int id = resultSet.getInt(1);
                String todo = resultSet.getNString(2);
                todoList.setId(id);
                todoList.setTodo(todo);
                todoList.add(todoList);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return todoLists.toArray(TodoList[]::new);

    }

    @Override
    public void add(TodoList todoList) {

    }

    @Override
    public Boolean remove(Integer id) {
        return null;
    }

    @Override
    public Boolean edit(TodoList todoList) {
        return null;
    }
}
