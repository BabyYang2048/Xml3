package xml3;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ok extends Application{
	private Text t = new Text("完成");
	private Button Ok = new Button("OK");

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane pane = new GridPane();
		pane.add(t,0,0);
		pane.add(Ok,0,1);
		
		pane.setAlignment(Pos.CENTER);
		
		Ok.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	primaryStage.close();
            	new cxl().start(new Stage());
            }
        });
		
		Scene scene = new Scene(pane, 100, 80);
		primaryStage.setTitle("OK");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
