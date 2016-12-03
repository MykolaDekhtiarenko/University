package com.mdekhtiarenko.universitysignin.xml;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
/**
 * Created by mykola.dekhtiarenko on 30.11.16.
 */
public class XMLParser {
    DocumentBuilder builder;


    public XMLParser(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void createInfoFile(int id, String teacher, String description){
        StringBuilder xmlStringBuilder = new StringBuilder();
        xmlStringBuilder.append("<xml>\n");
        xmlStringBuilder.append("   <Item teacher='"+teacher+"' description='"+description+"'></Item>\n");
        xmlStringBuilder.append("</xml>\n");
        try{
            FileWriter writer = new FileWriter("/Users/mykola.dekhtiarenko/Documents/workspace/UniversitySignIn/src/main/xml-info/"+id+"-info.xml", false);
            writer.write(xmlStringBuilder.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTeacher(int disciplineId){
        File inputFile = new File("/Users/mykola.dekhtiarenko/Documents/workspace/UniversitySignIn/src/main/xml-info/"+disciplineId+"-info.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        Document document = null;
        try {
            db = dbf.newDocumentBuilder();
            document = db.parse(inputFile);
            NodeList nodeList = document.getElementsByTagName("Item");
            for(int x=0,size= nodeList.getLength(); x<size; x++) {
                return nodeList.item(x).getAttributes().getNamedItem("teacher").getNodeValue();
            }
        } catch (ParserConfigurationException e) {
           // e.printStackTrace();
            return "Not Defined";
        }catch (FileNotFoundException e){
            //e.printStackTrace();
            return "Not Defined";
        }catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Not Defined";
    }

    public String getDescription(int disciplineId){
        File inputFile = new File("/Users/mykola.dekhtiarenko/Documents/workspace/UniversitySignIn/src/main/xml-info/"+disciplineId+"-info.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        Document document = null;
        try {
            db = dbf.newDocumentBuilder();
            document = db.parse(inputFile);
            NodeList nodeList = document.getElementsByTagName("Item");
            for(int x=0, size= nodeList.getLength(); x<size; x++) {
                return nodeList.item(x).getAttributes().getNamedItem("description").getNodeValue();
            }
        } catch (ParserConfigurationException e) {
            //e.printStackTrace();
            return "Not Defined";
        }catch (FileNotFoundException e){
            //e.printStackTrace();
            return "Not Defined";
        }catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Not Defined";
    }
}
