package xml3;

import java.io.File;

import javax.xml.parsers.*;

import org.w3c.dom.Document;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Search extends Application{
	private TextField selete = new TextField();
	private TextField name = new TextField();
    private TextField sex = new TextField();
    private TextField age = new TextField();
    private TextField phone = new TextField();
    private TextField schoolno = new TextField();
	private Button ensure = new Button("确定");
	private Button back = new Button("返回");
	
	File xmlfile = new File("datastorage.xml");
	
	public void start(Stage primaryStage) throws Exception {
	    GridPane pane = new GridPane();// TODO 自动生成的方法存根
	    pane.setHgap(5);
		pane.setVgap(5);
		pane.add(new Label("请输入要查找的学生学号:"),0,0);
		pane.add(selete,1,0);
		pane.add(new Label("学号"),0,1);
		pane.add(schoolno,1,1);
		pane.add(new Label("姓名:"),0,2);
		pane.add(name,1,2);
		pane.add(new Label("性别："),0,3);
		pane.add(sex,1,3);
		pane.add(new Label("年龄："),0,4);
		pane.add(age,1,4);
		pane.add(new Label("电话："),0,5);
		pane.add(phone,1,5);
		pane.add(ensure,0,6);
		pane.add(back,1,6);
		
		pane.setAlignment(Pos.CENTER);
		
		schoolno.setEditable(false);
		name.setEditable(false);
		sex.setEditable(false);
		age.setEditable(false);
		phone.setEditable(false);
		
		ensure.setOnAction(e ->Selete());
		back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	primaryStage.hide();
            	try {
					new cxl().start(new Stage());
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
            }
        });
		
		Scene sc = new Scene(pane,450,350);
		primaryStage.setTitle("查找界面");
		primaryStage.setScene(sc);
		primaryStage.show();
		}

	private void Selete() {
		String n=null;
		n = selete.getText();
		System.out.println("n="+n);
		String[] info = null;
 		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		try{
			builder = factory.newDocumentBuilder();
			doc = builder.parse(xmlfile);
			info = MainXml.search(doc,n);
			schoolno.setText(info[0]);
			name.setText(info[1]);
			sex.setText(info[2]);
			age.setText(info[3]);
			phone.setText(info[4]);
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args){
		Application.launch(args);
	}

}
