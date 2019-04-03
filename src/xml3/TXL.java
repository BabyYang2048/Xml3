package xml3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javafx.beans.property.SimpleStringProperty;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

//public class TXL {
//	public static void main(Document doc,String Sno,String Sname,String Ssex,String Sage,String Sphone) throws Exception{
//		TransformerFactory transformerFactory = TransformerFactory.newInstance();
//	    Transformer transformer;
//	    File xmlfile = new File("datastorage.xml");  
//		
//		NodeList nodelist = doc.getElementsByTagName("学号");
//    
//		for(int i = 0;i < nodelist.getLength();i++){
//    		doc.getElementsByTagName("学号").item(i).getFirstChild().setNodeValue(Sno);
//        	doc.getElementsByTagName("姓名").item(i).getFirstChild().setNodeValue(Sname);
//       		doc.getElementsByTagName("性别").item(i).getFirstChild().setNodeValue(Ssex);
//      		doc.getElementsByTagName("年龄").item(i).getFirstChild().setNodeValue(Sage);
//   			doc.getElementsByTagName("电话").item(i).getFirstChild().setNodeValue(Sphone);
//   	        String[] info = {Sno,Sname,Ssex,Sage,Sphone};
//   	        System.out.println("info="+info);
//   	        DOMSource newDomSource = new DOMSource(doc);
//        	transformer = transformerFactory.newTransformer();
//        	transformer.transform(newDomSource,new StreamResult(new FileOutputStream(xmlfile)));    		
//    	}
//	 }
//}

	public class TXL {
	
	private SimpleStringProperty Sno;
	private SimpleStringProperty Sname;
	private SimpleStringProperty Ssex;
	private SimpleStringProperty Sage;
	private SimpleStringProperty Sphone;
	
	TXL(String sno, String sname, String ssex,String sage,String sphone) {
	    this.Sno = new SimpleStringProperty(sno);
	    this.Sname = new SimpleStringProperty(sname);
	    this.Ssex = new SimpleStringProperty(ssex);
	    this.Sage = new SimpleStringProperty(sage);
	    this.Sphone = new SimpleStringProperty(sphone);
	    
	}
	TXL(){
		
	}

		public String getSno() {
		    return Sno.get();
		}
		public void setFiSno(String sno) {
		    Sno.set(sno);
		}
		public String getSname() {
		    return Sname.get();
		}
		public void setsname(String sno) {
		    Sname.set(sno);
		}
		
		public String getSsex() {
		    return Ssex.get();
		}
		public void setSsex(String sno) {
		    Ssex.set(sno);
		}
		    
	    public String getSage() {
	        return Sage.get();
	    }
	    public void setSage(String sno) {
	        Sage.set(sno);
	    }
	    public String getSphone() {
	        return Sphone.get();
	    }
	    public void setSphone(String sno) {
	        Sphone.set(sno);
	    }
	    
}