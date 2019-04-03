package xml3;


import java.io.File;

import javax.xml.parsers.*;

import org.w3c.dom.*;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Change extends Application {
	private TextField change = new TextField();
	private TextField name = new TextField();
	private TextField schoolno = new TextField();
	private TextField sex = new TextField();
	private TextField age = new TextField();
	private TextField phone = new TextField();
	private Button ensure = new Button("确定");
	private Button back = new Button("返回");

	File xmlfile = new File("datastorage.xml");

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane pane = new GridPane();
		pane.setHgap(6);
		pane.setVgap(6);
		pane.add(new Label("请输入要修改的学生学号:"), 0, 0);
		pane.add(change, 1, 0);
		pane.add(new Label("学号:"), 0, 1);
		pane.add(schoolno, 1, 1);
		pane.add(new Label("姓名:"), 0, 2);
		pane.add(name, 1, 2);
		pane.add(new Label("性别:"), 0, 3);
		pane.add(sex, 1, 3);
		pane.add(new Label("年龄："), 0, 4);
		pane.add(age, 1, 4);
		pane.add(new Label("电话:"), 0, 5);
		pane.add(phone, 1, 5);
		pane.add(ensure, 0, 6);
		pane.add(back, 1, 6);
		
		pane.setAlignment(Pos.CENTER);
		
		ensure.setOnAction(e -> Change(primaryStage));
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

		Scene sc = new Scene(pane, 450, 350);
		primaryStage.setTitle("修改界面");
		primaryStage.setScene(sc);
		primaryStage.show();
	}

	private void Change(Stage primaryStage) {
		primaryStage.hide();
		String schoolno1, n, a, s, p, sno;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		try {
			schoolno1 = change.getText();
			sno = schoolno.getText();
			n = name.getText();
			s = sex.getText();
			a = age.getText();
			p = phone.getText();
			builder = factory.newDocumentBuilder();
			doc = builder.parse(xmlfile);
			MainXml.Change(doc,schoolno1,sno,n,s,a,p);
			
			new Ok().start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}

