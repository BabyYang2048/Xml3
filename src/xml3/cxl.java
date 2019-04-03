package xml3;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class cxl extends Application {

  public void start(Stage primaryStage) {
    BorderPane root = new BorderPane();
    Scene scene = new Scene(root, 300, 250, Color.BLACK);

    MenuBar menuBar = new MenuBar();
    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
    root.setTop(menuBar);

    Label label =new Label(" Welcome to the Address Book \n\n请在上方选项出选择你想进行的操作");
    label.setFont(new Font("Consolas", 14));
	label.setTextFill(Color.web("black"));
    root.setCenter(label);
    // File menu - new, save, exit
    Menu fileMenu = new Menu("选项");
    MenuItem addMenuItem = new MenuItem("添加信息");
    MenuItem changeMenuItem = new MenuItem("修改信息");
    MenuItem deleteMenuItem = new MenuItem("删除信息");
    MenuItem searchMenuItem = new MenuItem("查询信息");
    MenuItem searchAllMenuItem = new MenuItem("查询全部");
    MenuItem exitMenuItem = new MenuItem("退出");
    exitMenuItem.setOnAction(actionEvent -> Platform.exit());
   

    fileMenu.getItems().addAll(addMenuItem, changeMenuItem,deleteMenuItem,searchMenuItem,searchAllMenuItem,
        exitMenuItem);

      menuBar.getMenus().addAll(fileMenu);
      
  
      addMenuItem.setOnAction(e ->addmethod(primaryStage));
      searchMenuItem.setOnAction(e ->searchmethod(primaryStage));
      deleteMenuItem.setOnAction(e ->deletemethod(primaryStage));
      changeMenuItem.setOnAction(e ->changemethod(primaryStage));
      searchAllMenuItem.setOnAction(e ->searchAllmethod(primaryStage));
      
      
      primaryStage.setScene(scene);
      primaryStage.setTitle("通讯录主界面");
      primaryStage.show();
  }

  
    private void searchAllmethod(Stage primaryStage) {
    	primaryStage.hide();
    	try {
			new SecrchAll().start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }


	private void changemethod(Stage primaryStage) {
		primaryStage.hide();
		try {
			new Change().start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

  	private void deletemethod(Stage primaryStage) {
		primaryStage.hide();
		try {
			new Delete().start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void searchmethod(Stage primaryStage) {
		primaryStage.hide();
		try {
			new Search().start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addmethod(Stage primaryStage) {
		primaryStage.hide();
		try {
			new Add().start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
  
}
