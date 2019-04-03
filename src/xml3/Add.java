package xml3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Add  extends Application {
	TextField name = new TextField();
	TextField sex = new TextField();
    TextField age = new TextField();
	TextField phone = new TextField();
	TextField schoolno = new TextField();
	private Button ensure = new Button("添加");
	private Button back =new Button("返回");
	
	File xmlfile = new File("datastorage.xml");
	
	
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder ;
	Document doc;
	TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer;
	
	public void start(Stage primaryStage) throws Exception {
		
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.add(new Label("学号:"), 0, 0);
		gridPane.add(schoolno, 1, 0);
		gridPane.add(new Label("姓名:"), 0, 2);
		gridPane.add(name, 1, 2);
		gridPane.add(new Label("性别:"), 0, 4);
		gridPane.add(sex, 1, 4);
		gridPane.add(new Label("年龄:"), 0, 6);
		gridPane.add(age, 1, 6);
		gridPane.add(new Label("电话:"), 0, 8);
		gridPane.add(phone, 1, 8);
		gridPane.add(ensure, 0, 10);
		gridPane.add(back, 1, 10);

		gridPane.setAlignment(Pos.CENTER);
		
		
		ensure.setOnAction(e ->Addinfo(primaryStage));
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
		
		Scene scene = new Scene(gridPane,400,250);
	    primaryStage.setTitle("Add");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	
	public void Addinfo(Stage primaryStage) {
		primaryStage.hide();
		try{
		String n=null, a=null, s=null, p=null;
		String sno=null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		
		sno=schoolno.getText();
		//System.out.println("sno="+sno);
		n = name.getText();
		s = sex.getText();
		a = age.getText();
		p = phone.getText();
//		System.out.println(n.length());
//		System.out.println(";;;;;"+n+s+a+p+"mmmmm");
		if(sno.length()==0||n.length()==0||s.length()==0||a.length()==0||p.length()==0){
			new Error().start(new Stage());
		}
		else{
			builder = factory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(xmlfile);	
			MainXml.add(doc,sno, n, s, a, p);
			if(Yz.validateXMLSchema("datastorage.xsd","datastorage.xml")==false){
				NodeList nodelist = doc.getElementsByTagName("姓名");
				NodeList nodelist2 =doc.getElementsByTagName("电话");
				for(int i = 0;i < nodelist.getLength();i++){
	        		String del1 = null,del2=null,del3=null,del4=null,del5=null;
	        		del1 = nodelist.item(i).getFirstChild().getTextContent();
	        		//del3 = nodelist.item(i).getFirstChild().getNextSibling().getTextContent();
	        		//del4 = nodelist.item(i).getFirstChild().getNextSibling().getNextSibling().getTextContent();
	        		//del5 = nodelist.item(i).getLastChild().getPreviousSibling().getTextContent();
	        	    del2 = nodelist2.item(i).getFirstChild().getTextContent();
	        		
	        		//System.out.println("I="+i+"del1="+del1+"del2="+del2);
	        		if(del1.equals(n)&&del2.equals(p)/*&&del3.equals(n)&&del4.equals(s)&&del5.equals(a)*/){
	        			Node node = nodelist.item(i).getParentNode();
	        			doc.getFirstChild().removeChild(node);
	        			transformer = transformerFactory.newTransformer();
	        			DOMSource newDomSource = new DOMSource(doc);
	        	        transformer.transform(newDomSource,new StreamResult(new FileOutputStream(xmlfile)));
	        	        new Error().start(new Stage());
	        		}

				//System.out.println("baocuo");
			}
				}
			else{
			new Ok().start(new Stage());	
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}


	public static void main(String[] args)  {
		Application.launch(args);
	}


}
