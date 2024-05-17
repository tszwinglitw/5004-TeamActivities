import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class BGGeek {
    private static final String URL_STR = "https://www.boardgamegeek.com/xmlapi2/thing?id=%s";

    /**
     * Gets the XML file from the Board Game Geek API.
     * https://boardgamegeek.com/wiki/page/BGG_XML_API2
     * 
     * @param gameId
     * @return
     */
    public static InputStream getXML(String gameIds) {
        String urlStr = String.format(URL_STR, gameIds);
        try {
            URL url = new URL(urlStr);
            System.out.println("Connected to " + urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/xml");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            int status = con.getResponseCode();
            if (status == 200) {
                return con.getInputStream();
            } else {
                System.out.println("Failed to connect to " + urlStr);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return InputStream.nullInputStream();
    }


    public static void main(String[] args) {
        try (InputStream in = getXML("13,14,15,16,17")) {
            var games = BGGeekXMLReader.read(in);
            System.out.println(games);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
