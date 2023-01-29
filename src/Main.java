import controller.Controller;
import model.Action;
import model.ActionFile;
import model.Storage;
import model.StorageAction;
import viewUser.View;

public class Main {
    public static void main(String[] args) {
        Action action = new ActionFile("Notes.txt");
        Storage storage = new StorageAction(action);
        Controller controller = new Controller(storage);
        View view = new View(controller);
        view.start();
    }
}