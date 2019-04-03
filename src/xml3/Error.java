package xml3;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Error extends Application{
	private Label t = new Label("操作失败!!\n可能原因如下:\n");
	Label t1 = new Label("1.查找学号不存在");
	Label t2 = new Label("2.添加信息为空");
	Label t3 = new Label("3.添加信息重复");
	Label t4 = new Label("4.添加信息不符合规范\n如:性别只能为男/女\n  年龄在0-120之间");
	
	private Button Error = new Button("Back");

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane pane = new GridPane();
		pane.add(t,0,0);
		pane.add(t1,0,2);
		pane.add(t2,0,4);
		pane.add(t3,0,6);
		pane.add(t4,0,8);
		pane.add(Error,0,10);
		
		pane.setAlignment(Pos.CENTER);
		
		Error.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	primaryStage.close();
            	new cxl().start(new Stage());
            }
        });
		
		Scene scene = new Scene(pane, 300, 300);
		primaryStage.setTitle("失败");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
