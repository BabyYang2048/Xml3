package xml3;

import java.io.File;

import javax.xml.parsers.*;

import org.w3c.dom.Document;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Delete extends Application{
	private TextField delete= new TextField();
	private Button ensure = new Button("确定");
	private Button back = new Button("返回");
	
	File xmlfile = new File("datastorage.xml");
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	    GridPane pane = new GridPane();// TODO 自动生成的方法存根
	    pane.setHgap(5);
		pane.setVgap(5);
		pane.add(new Label("请输入要删除的学生学号:"),0,0);
		pane.add(delete,0,1);
		pane.add(ensure,1,0);
		pane.add(back,1,1);
		
		ensure.setOnAction(e ->Delete(primaryStage));
		back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	primaryStage.hide();
            	try {
					new cxl().start(new Stage());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            }
        });
		
		Scene sc = new Scene(pane,250,60);
		primaryStage.setTitle("删除界面");
		primaryStage.setScene(sc);
		primaryStage.show();
	}
	
	
	private void Delete(Stage primaryStage) {
		primaryStage.hide();
		String n=null;
		//System.out.println(n);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		try{
			n = delete.getText();
			//System.out.println("nnnnnnn="+n);
			builder = factory.newDocumentBuilder();
			doc = builder.parse(xmlfile);
//			System.out.println(n);
			MainXml.delete(doc, n);
			
			new Ok().start(new Stage());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		Application.launch(args);
	}

}
