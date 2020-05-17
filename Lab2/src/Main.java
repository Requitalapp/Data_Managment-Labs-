import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try{
            builder = builderFactory.newDocumentBuilder();
            doc = (Document) builder.parse("./src/Lab2.xml");
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();
            String license;
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the driver license: ");
            license = in.nextLine();
            List<String> driverName = Xml.getDriverNameByLicense(doc, xpath, license);
            for(int i = 0; i<driverName.size(); i++){
                System.out.println(driverName.get(i));
           }

            System.out.println("Enter type of cargo");
            String cargoType = in.nextLine();
            List<String> orderDates = Xml.getOrderDateByCargoType(doc, xpath, cargoType);
            for(int i = 0; i<orderDates.size(); i++){
                System.out.println(orderDates.get(i));
            }

        } catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }
    }
}
