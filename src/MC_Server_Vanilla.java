import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator.ContainsText;





public class MC_Server_Vanilla extends MC_Server {
  public static void main() throws IOException {


    String Link = "o";
    String y = "o";
    String x = "o";
    Document doc;


    doc = Jsoup.connect("https://minecraft.net/en-us/download/server/").get();
    Elements links = doc.select("a[href]");
    for (Element link : links) {
      y = (link.attr("href"));
      //System.out.println(y);
      if (y.contains("https://launcher.mojang.com/v1/objects/")) {
        Link = (y);
        //System.out.println(Link);
      } else {
        continue;
      }
    }
    doc = Jsoup.connect("https://minecraft.net/en-us/download/server/").get();
    System.out.print(doc);

      URL website = new URL(Link);
      ReadableByteChannel rbc = Channels.newChannel(website.openStream());
      FileOutputStream fos = new FileOutputStream("Server.jar");
      fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    }

  }







 /* String html = "<html><head><title>Sample Title</title></head>"
          + "<body>"
          + "<p>Sample Content</p>"
          + "<div id='sampleDiv'><a href='www.google.com'>Google</a>"
          + "<h3><a>Sample</a><h3>"
          +"</div>"
          +"</body></html>";
  Document doc2 = Jsoup.parse(html);

  //a with href
  Element link = doc2.select("a").first();

    System.out.println("Outer HTML: " + link.outerHtml());
            System.out.println("Inner HTML: " + link.html());

//    for(Element link: links) {
//      String 1 = Integer.parseInt(link.attr("href"));
//      if(1.length()>0){
//        if(1.length()<4)
//          1 = doc.baseUri()+1.substring(1);
//        else if(!1.substring(0, 4).equals("https"))
//          1 = doc.baseUri()+1.substring(1);
//      }






/*
    MC_Server V = new MC_Server();
    V.URL = "https://minecraft.net/en-us/download/server/";

    URL u;
    Scanner s;

    u = new URL(V.URL);
    s = new Scanner(u.openStream());
    ArrayList<String> y = new ArrayList<>();
    while (s.hasNext()) {
      y.add(s.nextLine());


    }
    System.out.print(y);


      //int http = y.indexOf("https://");
      //System.out.println(http);
 */










    /*
      URL url = new URL("https://minecraft.net/en-us/download/server/");

      // read text returned by server

      BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

      String line;
    List y = null;
      while ((line = in.readLine()) != null) {

        y.add(line);

      }

      in.close();
      System.out.print(y);
    } */






























