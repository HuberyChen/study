package java.test;

import java.io.FileOutputStream;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

public class Java2XML {

    public void BuildXMLDoc() {
        Element root = new Element("list");
        Document doc = new Document(root);
        for (int i = 0; i < 5; i++) {
            Element elements = new Element("user");
            elements.setAttribute("id", "" + i);
            elements.addContent(new Element("name").setText("hubery"));
            elements.addContent(new Element("age").setText("22"));
            elements.addContent(new Element("sex").setText("male"));

            root.addContent(elements);
        }
        XMLOutputter XMLOut = new XMLOutputter();
        try (FileOutputStream os = new FileOutputStream("user.xml")) {

            XMLOut.output(doc, os);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
