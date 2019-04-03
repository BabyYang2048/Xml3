package xml3;

import java.io.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SecrchAll extends Application{
	
   	 @SuppressWarnings("unchecked")
	public void start(Stage primaryStage) throws Exception {
   		 
   		TableView<TXL> table = new TableView<>();
   		File xmlfile = new File("datastorage.xml");
   		
   		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
   		DocumentBuilder builder=factory.newDocumentBuilder();;
   		
   		Document doc = builder.parse(xmlfile);;
   		String sno = null,sname = null,ssex = null,sage = null,sphone = null;
   	 	NodeList nodelist = doc.getElementsByTagName("学号");
   	    ObservableList<TXL> data=null,data2=null;
   	 
   	    TableColumn<TXL, String> Schoolno =new TableColumn<TXL, String>("学号");
		Schoolno.setMinWidth(100);
		//Schoolno.setCellValueFactory(new PropertyValueFactory<>("sno"));
		
		TableColumn<TXL, String> Name =new TableColumn<TXL, String>("姓名");
		Name.setMinWidth(100);
		//Name.setCellValueFactory(new PropertyValueFactory<>("sname"));
		
		TableColumn<TXL, String> sex =new TableColumn<TXL, String>("性别");
		sex.setMinWidth(100);
		//sex.setCellValueFactory(new PropertyValueFactory<>("ssex"));
		
		TableColumn<TXL, String> age =new TableColumn<TXL, String>("年龄");
		age.setMinWidth(100);
		//age.setCellValueFactory(new PropertyValueFactory<>("sage"));
		
		TableColumn<TXL, String> phone =new TableColumn<TXL, String>("电话");
		phone.setMinWidth(100);
		//phone.setCellValueFactory(new PropertyValueFactory<>("sphone"));
   	     
		
		table.getColumns().addAll(Schoolno,Name,sex,age,phone);
		data2=FXCollections.observableArrayList();

		
		 for(int i = 0;i < nodelist.getLength();i++){
	   			sno = doc.getElementsByTagName("学号").item(i).getFirstChild().getNodeValue();
	   			sname = doc.getElementsByTagName("姓名").item(i).getFirstChild().getNodeValue(); 
	   			ssex = doc.getElementsByTagName("性别").item(i).getFirstChild().getNodeValue();
	   			sage = doc.getElementsByTagName("年龄").item(i).getFirstChild().getNodeValue(); 
	   			sphone = doc.getElementsByTagName("电话").item(i).getFirstChild().getNodeValue();
	   	 		String[] info={sno,sname,ssex,sage,sphone};
	   	 		
	   	 		System.out.println("i="+i+"info="+info[0]+info[1]+info[2]+info[3]+info[4]);
	   	 	       
				phone.setCellValueFactory(new PropertyValueFactory<>("sphone"));
	   	 	    age.setCellValueFactory(new PropertyValueFactory<>("sage"));
	   	 	    sex.setCellValueFactory(new PropertyValueFactory<>("ssex"));
	   	 	    Name.setCellValueFactory(new PropertyValueFactory<>("sname"));
	   	 	    Schoolno.setCellValueFactory(new PropertyValueFactory<>("sno"));
			
	   	 	    //table.setItems(data);
	   	 	    
		   	 	data2.add(new TXL(sno,sname,ssex,sage,sphone));
	   	 		table.setItems(data2);
		   	 	
	   	 		}
		 			
//		 ObservableList<TXL> data3 = FXCollections.observableArrayList(
//				 new TXL(sno,sname,ssex,sage,sphone),
//				 new TXL("1","1","2","1","1")
//				 );
		
//		 data=FXCollections.singletonObservableList(new TXL(sno,sname,ssex,sage,sphone));
//		 data2=FXCollections.singletonObservableList(new TXL("1","1","1","1","1"));
		 //table.setItems(data);
		 //data.add(new TXL("1","1","1","1","1"));
//		 table.setItems(data3);	
		 
		Scene scene =new Scene(new Group());
		primaryStage.setTitle("A easy From");
		primaryStage.setWidth(530);
		primaryStage.setHeight(500);
		
		final Label label =new Label("Adddress Book");
		table.setEditable(true);
		
		
		final VBox vbox =new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10,0,0,10));
		vbox.getChildren().addAll(label,table);
		
		((Group) scene.getRoot()).getChildren().addAll(vbox);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	
	public static void main(String[] args){
		launch(args);
	}
}