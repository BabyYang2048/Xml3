package xml3;

import java.io.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class Axml2 {

	public static void main(String[] args) {
		try{
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();//�õ�Dom�������Ĺ���ʵ��
			DocumentBuilder builder=dbf.newDocumentBuilder();//��Dom���������л��Dom������
			Document doc=builder.parse(new File("a.xml"));//��Ҫ������XML�ĵ�����Dom��������
			Element root=doc.getDocumentElement(); //����Dom���ĸ��ڵ����
			NodeList n1=root.getChildNodes();
			//System.out.println("n1.getlength()="+n1.getLength());
			for(int i=0;i<n1.getLength();i++){
				Node node=n1.item(i);
				//System.out.println("n1.item("+i+")="+n1.item(i));
				if(node.getNodeType() == Node.ELEMENT_NODE){
					Element enode=(Element)node;
					if(i==1){
						enode.removeAttribute("�Ա�");
					}
					//System.out.print(i);
					//System.out.print(enode.getTextContent());
					
					/*String str = enode.getTextContent();
					Element email1 = doc.createElement("email"); //������Ԫ��
					 //getTextContent���ش����Է��ش˽ڵ㼰�������ı����ݡ�
					if (str.equals("abc@tom.com")){//��ƥ�䵽abc@tom.com�����޸�
						enode.setTextContent("zs@tom.com");
					}
					str.replaceChild(email1, .getElementsByTagName("Email").item(0));
            		//��EmailԪ���滻��email
            		str.removeChild(.getElementsByTagName("�꼶").item(0));//�Ƴ��꼶Ԫ��
            		*/
						
				}
			}
			
			NodeList studentList = root.getElementsByTagName("ѧ��");//�õ���Ԫ��������ѧ��Ԫ�ص��б�
            Element student1 = (Element) studentList.item(0);
            Element email1 = doc.createElement("email"); //������Ԫ��
            email1.setTextContent("zs@tom.com");
            student1.replaceChild(email1, student1.getElementsByTagName("Email").item(0));
            //��EmailԪ���滻��email
            student1.removeChild(student1.getElementsByTagName("�꼶").item(0));//�Ƴ��꼶Ԫ��
            
			Element student2, name, age, email2;
			
			student2 = doc.createElement("ѧ��");

			student2.setAttribute("�༶", "0802");//����µ�����
			student2.setAttribute("ѧ��", "002");
			
			name = doc.createElement("����");
			name.setTextContent("����");
			student2.appendChild(name);
			
			age = doc.createElement("����");
			age.setTextContent("19");
			student2.appendChild(age);
			
			email2 = doc.createElement("email");
			email2.setTextContent("ls@tom.com");
			student2.appendChild(email2);
			
			root.appendChild(student2);            
            
            
			TransformerFactory transFactory = TransformerFactory.newInstance();
			//ת���������󣬻�ȡ TransformerFactory ����ʵ����
			Transformer transformer = transFactory.newTransformer();
			//����һ���ļ�ת������ִ�д� Source �� Result �ĸ��Ƶ��� Transformer��
			DOMSource domSource = new DOMSource(doc);
			//��document�����װ��domsource���У���������DOM�ڵ��������Դ���ò�����Ӧ�����Դ˽ڵ�Ϊ����������
			File file = new File("b.xml");//�½�xml�ĵ�
			FileOutputStream output = new FileOutputStream(file);
			//����һ����ָ�� File �����ʾ���ļ���д�����ݵ��ļ��������
			StreamResult xmlResult = new StreamResult(output);
			//��Ҫ�任��XML�ĵ�������StreamResult
			transformer.transform(domSource, xmlResult);
			//�� XML Source ת��Ϊ Result(�ڵ���ת����xml�ĵ�)��
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		

	}

	

}
