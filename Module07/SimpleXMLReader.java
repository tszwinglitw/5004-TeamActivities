import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

public class SimpleXMLReader {
    public void read(String filePath) {
        try {
            File inputFile = new File(filePath);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            List<Person> people = new ArrayList<>();
            SimpleXMLHandler handler = new SimpleXMLHandler(people);
            saxParser.parse(inputFile, handler);

            System.out.println(people);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SimpleXMLHandler extends DefaultHandler {
        List<Person> people;
        Map<String, String> current;
        StringBuffer buffer = new StringBuffer();

        SimpleXMLHandler(List<Person> people) {
            this.people = people;
        }


        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) {
            buffer.setLength(0); // reset the buffer
            if (qName.equalsIgnoreCase("person")) {
                current = new HashMap<>();
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // student to add
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            buffer.append(ch, start, length);
        }

    }

    public static void main(String[] args) {
        SimpleXMLReader reader = new SimpleXMLReader();
        reader.read("simple.xml");
    }
}
