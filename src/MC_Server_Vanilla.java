import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

// MAIN VANILLA SERVER UPDATER. This runs after the Modded Server Updater if there is not a "mods" folder present.
public class MC_Server_Vanilla extends MC_Server {
  public static void main() throws IOException {

    //Variables for Vanilla Server update
    String Link = "o";
    String y = "o";
    String x = "o";
    String t = "o";
    Document doc;

    //USING JSOUP = Connects to Minecraft server download URL, and Stores the latest download link in (Link)
    doc = Jsoup.connect("https://minecraft.net/en-us/download/server/").get();
    Elements links = doc.select("a[href]");
    for (Element link : links) {
      y = (link.attr("href"));
      //System.out.println(y);
      if (y.contains("https://launcher.mojang.com/v1/objects/")) {
        Link = (y);
        System.out.println(Link);
      } else {
        continue;
      }
    }


    //USING JSOUP = using the same method for finding the download link, this finds the specific file/version id (ex: minecraft_server.1.1.1.jar)
    for (Element Ver_link : links) {
      t = Ver_link.attr("href");
      String Ver_Node = Ver_link.childNode(0).toString();
      if (t.contains("https://launcher.mojang.com/v1/objects")) {
        System.out.println(Ver_Node);
      } else {
        continue;
      }


      //Finds current directory
      System.out.println("Working Directory = " +
              System.getProperty("user.dir"));


      //Finds variable for server.jar location
      String filePathString = System.getProperty("user.dir");
      String ServerPath = (filePathString + "/" + Ver_Node);


      //Checks Server Version, checks if ServerPath is currently in the directory
      File f = new File(ServerPath);
      System.out.print("\nChecking Server Version...");
      if (f.exists()) {
        //Found latest server.jar and will terminate
        System.out.print("\nVanilla Server is already up to date! Closing Program.");
        System.exit(10);
      } else {
        //Found older/no server.jar and update server
        System.out.println("Updating Server!");
        System.out.println("\nPrepping for download");


        //Downloads latest server.jar
        System.out.println("Downloading: " + Ver_Node);
        URL website = new URL(Link);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream(Ver_Node);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        System.out.println("Download for: "+ Ver_Node + "has completed");


        //Creates eula.txt file
        System.out.println("Creating: eula.txt");
        PrintWriter Eula_Writer = new PrintWriter("eula.txt", "UTF-8");
        Eula_Writer.println("eula=true");
        Eula_Writer.close();
        System.out.println("Created: eula.txt");


        //Creates Start.bat file that has latest server.jar in content
        System.out.println("Creating: Start" + Ver_Node + ".txt...");
        PrintWriter Start_Writer = new PrintWriter("Start -" + Ver_Node +"-.bat", "UTF-8");
        Start_Writer.println("java -Xmx1024M -Xms1024M -jar " + Ver_Node + " nogui");
        Start_Writer.close();
        System.out.println("Start -" + Ver_Node +"-.bat Created");
        System.out.println("\nYour Vanilla Server is now updated! :)");


        //ends program
        System.exit(10);
      }
    }
  }
}




//BUNCH OF JUNK
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






























