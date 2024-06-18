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
    /**
     * Read the XML file and print the content to STDOUT.
     *
     * @param filePath
     */
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
        // what is DefaultHandler?????

        List<Person> people;
        Map<String, String> current;
        StringBuffer buffer = new StringBuffer();

        SimpleXMLHandler(List<Person> people) {
            this.people = people;
        }


        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) {
            System.out.println("running startElement");
            buffer.setLength(0); // reset the buffer
            if (qName.equalsIgnoreCase("person")) {
                current = new HashMap<>();
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("running endElement");
            if (qName.equalsIgnoreCase("person")) {
                // end tag, add the current person to the list
                people.add(Person.fromMap(current));
                current = null;
            } else {
                if (current != null) {
                    // add person's data to current map
                    current.put(qName, buffer.toString());
                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            /// Then between the start of a tag such as <person> and the end tag,
            // characters(char[] ch, int start, int length) is called,
            // so you add the contents of char[] ch to your buffer. = so basically adding content to buffer

            System.out.println("running characters: ch=" + new String(ch).substring(0, 10) + " start=" + start + " length=" + length);
            buffer.append(ch, start, length);
        }

    }

    public static void main(String[] args) {
        // instantiate reader and read XML
        SimpleXMLReader reader = new SimpleXMLReader();
        reader.read("simple.xml");
    }
}
