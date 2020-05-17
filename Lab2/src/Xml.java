import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.*;

public class Xml {

    public static List<String> getDriverNameByLicense(Document doc, XPath xpath, String license) {
        List<String> names = new ArrayList<>();
        try {
            String expression = "/orders/order/delivery/driver[license = " + "'" + license + "']/full_name/text()";
            XPathExpression expr = xpath.compile(expression);
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++) {
                names.add(nodes.item(i).getTextContent());
            }
        }catch(XPathExpressionException e){
            e.printStackTrace();
        }
        return names;

    }

    public static List<String> getOrderDateByCargoType(Document doc, XPath xpath, String cargoType){
        List<String> orderDates = new ArrayList<>();
        try {
            String expression = "/orders/order[delivery/cargo/cargotype = " + "'" + cargoType + "']/order_date/text()";
            XPathExpression expr = xpath.compile(expression);
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++) {
                orderDates.add(nodes.item(i).getTextContent());
            }
        }catch(XPathExpressionException e){
            e.printStackTrace();
        }
        return orderDates;
    }
}
