import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Ale's listening bar");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) throws Exception {
        System.out.println("Ale's listening bar");
    }
}
