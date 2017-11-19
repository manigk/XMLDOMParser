package com.xmldomparser;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MyDomParser {
	
	public static void main(String[] args)
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("catalog.xml");
			NodeList personlist = doc.getElementsByTagName("dataset");
			for(int i=0;i<personlist.getLength();i++)
			{
				Node p = personlist.item(i);
				if(p.getNodeType()==Node.ELEMENT_NODE)
				{
					Element person = (Element) p;
					NodeList namelist = person.getChildNodes();
					for(int j=0;j<namelist.getLength();j++)
					{
						Node n = namelist.item(j);
						if(n.getNodeType() == Node.ELEMENT_NODE)
						{
							Element name=(Element) n;
							/*String n1 = name.getElementsByTagName("name").item(j).getTextContent();
							String n2 = name.getElementsByTagName("metadata-url").item(j).getTextContent();
							String n3 = name.getElementsByTagName("teaser").item(j).getTextContent();
							String n4 = name.getElementsByTagName("rating").item(j).getTextContent();
							String n5 = name.getElementsByTagName("agency").item(j).getTextContent();
							String n6 = name.getElementsByTagName("kml-kmz-url").item(j).getTextContent();
							System.out.println("name :"+ n1);*/
							System.out.println( " "+ name.getTagName() + ":" + name.getTextContent());
						}
					}
					System.out.println("-----------------------------------------------------");
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
