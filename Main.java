import config.Database;
import entities.TodoList;
import repositories.TodoListRepository;
import repositories.TodoListRepositoryDbimpl;
import repositories.TodoListRepositoryimpl;
import services.TodoListService;
import services.TodoListServiceimpl;
import views.TodoListTerminalView;
import views.TodoListView;

public class Main {
    public static void main(String[] args) {
        Database database = new Database("databaseku", "root", "", "Localhost", "3306");
        database.setup();

        TodoListRepository todoListRepository = new TodoListRepositoryDbimpl(database);

        
        TodoListService todoListService = new TodoListServiceimpl(todoListRepository);
        TodoListView todoListView = new TodoListTerminalView(todoListService);
        todoListView.run();

    }
}
