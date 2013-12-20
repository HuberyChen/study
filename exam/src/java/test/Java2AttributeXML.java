package java.test;

import java.io.FileOutputStream;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

public class Java2AttributeXML {

    public void BuildAttributeXMLDoc() {
        Element root = new Element("attributes");
        Document doc = new Document(root);
        for (int i = 0; i < 5; i++) {
            Element elements = new Element("attribute");
            elements.addContent(new Element("name"));
            elements.addContent(new Element("multi-select"));
            elements.addContent(new Element("result-sort"));
            elements.addContent(new Element("search-sort"));

            root.addContent(elements);
        }
        XMLOutputter XMLOut = new XMLOutputter();

        try (FileOutputStream os = new FileOutputStream("attribute.xml")) {

            XMLOut.output(doc, os);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
