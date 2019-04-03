package xml3;

import java.io.*;

import javafx.stage.Stage;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class MainXml {
	
	public static File xmlfile = new File("datastorage.xml");  
	public static DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	public static DocumentBuilder builder ;
	public static Document doc;
	public static TransformerFactory transformerFactory = TransformerFactory.newInstance();
    public static Transformer transformer;
	

	public static void add(Document doc,String sno, String n,String s,String a,String p){  //添加
		Node node = doc.getFirstChild();
		Element student = doc.createElement("学生");
		try {
			Element schoolno =doc.createElement("学号");
			Element name = doc.createElement("姓名");
			Element sex = doc.createElement("性别");
			Element age = doc.createElement("年龄");
			Element phone = doc.createElement("电话");
		    
			schoolno.setTextContent(sno);
			name.setTextContent(n);
			sex.setTextContent(s);
			age.setTextContent(a);
			phone.setTextContent(p);
			
			student.appendChild(schoolno);
			student.appendChild(name);
			student.appendChild(sex);
			student.appendChild(age);
			student.appendChild(phone);
			
			node.appendChild(student);
			
			transformer = transformerFactory.newTransformer();
			DOMSource newDomSource = new DOMSource(node);
	        transformer.transform(newDomSource,new StreamResult(new FileOutputStream(xmlfile)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String[] search(Document doc,String n){ //查找
		String name=null,s=null ,a=null ,p=null ,sno=null;
		String del = " " ;
		int flag=0;
		boolean result=false;
        NodeList nodelist = doc.getElementsByTagName("学号");
        for(int i = 0;i < nodelist.getLength();i++){
        		flag++;
        	    del = nodelist.item(i).getFirstChild().getTextContent();
        		//System.out.println("i="+i+"del="+del);
        		if(del.equals(n)){
        			sno = doc.getElementsByTagName("学号").item(i).getFirstChild().getNodeValue();
        			name = doc.getElementsByTagName("姓名").item(i).getFirstChild().getNodeValue(); 
        			s = doc.getElementsByTagName("性别").item(i).getFirstChild().getNodeValue();
        			a = doc.getElementsByTagName("年龄").item(i).getFirstChild().getNodeValue(); 
        			p = doc.getElementsByTagName("电话").item(i).getFirstChild().getNodeValue();
    			    System.out.println(name+" "+s+" "+a+" "+p);
    			    result=true;
    			    break;
        			}
        	
        		}
        if(flag==nodelist.getLength()&&result==false){
        	try {
				new Error().start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
        	//System.out.println("error!!");
        }
       // System.out.println("!!!"+name+" "+s+" "+a+" "+p);
        String[] info = {sno,name,s,a,p};
//        System.out.println("info="+info);
		return info;
	}

	public static void delete(Document doc,String n){
        try{
        	NodeList nodelist = doc.getElementsByTagName("学号");
        	for(int i = 0;i < nodelist.getLength();i++){
        		String del = null;
        		del = nodelist.item(i).getFirstChild().getTextContent();
        		if(del.equals(n)){
        			Node node = nodelist.item(i).getParentNode();
        			doc.getFirstChild().removeChild(node);
        			transformer = transformerFactory.newTransformer();
        			DOMSource newDomSource = new DOMSource(doc);
        	        transformer.transform(newDomSource,new StreamResult(new FileOutputStream(xmlfile)));
        		}
        	}
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
	
	
	
	public static void Change(Document doc,String schoolno,String sno,String n,String s,String a,String p){
        try{
        	NodeList nodelist = doc.getElementsByTagName("学生");
        	for(int i = 0;i < nodelist.getLength();i++){

        		String newSchoolno = doc.getElementsByTagName("学号").item(i).getFirstChild().getNodeValue(); 
           		
        		if(newSchoolno.equals(sno)){
        			doc.getElementsByTagName("学号").item(i).getFirstChild().setNodeValue(sno);
        			doc.getElementsByTagName("姓名").item(i).getFirstChild().setNodeValue(n);
        			doc.getElementsByTagName("性别").item(i).getFirstChild().setNodeValue(s);
        			doc.getElementsByTagName("年龄").item(i).getFirstChild().setNodeValue(a);
        			doc.getElementsByTagName("电话").item(i).getFirstChild().setNodeValue(p);
        			DOMSource newDomSource = new DOMSource(doc);
        			transformer = transformerFactory.newTransformer();
        	        transformer.transform(newDomSource,new StreamResult(new FileOutputStream(xmlfile)));
        			}
        	
        	}
        }catch(Exception e){
        	e.printStackTrace();
        }
	}

}
