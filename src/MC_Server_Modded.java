import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;



public class MC_Server_Modded extends MC_Server {
  public static void main() throws Exception {


    //Variables for Modded Server update
    String Ver_Num = "o";
    String Link = "o";
    String y = "o";
    String x = "o";
    String t = "o";
    Document doc;


    //USING JSOUP = Connects to Minecraft server download URL, and Stores the latest download link in (Link)
    doc = Jsoup.connect("http://the-1710-pack.com/repo").get();
    Elements links = doc.select("a[href]");
    for (Element link : links) {
      y = (link.attr("href"));
      if (y.contains("http://solder.endermedia.com/repository/downloads/the-1710-pack/the-1710-pack")) {
        Link = (y);
        break;
      }
    }


    //USING JSOUP = using the same method for finding the download link, this finds the specific file/version number (ex: 1.1.1)
    for (Element Ver_link : links) {
      t = Ver_link.attr("href");
      if (t.contains("http://solder.endermedia.com/repository/downloads/the-1710-pack/the-1710-pack")) {
        String Ver_Node = Ver_link.childNode(1).childNode(0).toString();
        Ver_Num = Ver_Node;
        break;
      }
    }


    //Finds current directory
    System.out.println("Checking Working Directory: " + System.getProperty("user.dir"));


    //Finds variable for Modded Server - zipped folder location
    String filePathString = System.getProperty("user.dir");
    String ServerPath = (filePathString + "/" + "the-1710-pack_"+ Ver_Num +".zip");


    //Finds variable for mod folder location
    String Mods_FolderPath = (filePathString + "/mods");


    //Checks for mod folder to determine if server is modded or vanilla
    String path= Mods_FolderPath;
    File file = new File(path);
    if (!file.exists()) {


      //NO MODS FOLDER FOUND, skips rest of modded and goes back to main to start vanilla
      System.out.println("\nThis is a Vanilla Server. Switching to Vanilla Automatic Server Updater.");
    }else{


      //Checks Server version
      System.out.print("Sorry! Automatic Modded Server updating is not an option!");
      System.out.print("\nChecking Server Version...");
      String filePath = (ServerPath);
      File f = new File(filePath);
      if (f.exists()) {


        //Server version is up to date, closes program
        System.out.print("\nModded Server is already up to date! Closing Program.");
        System.exit(10);
      } else {


        //Server version is older, starts to download new .zip folder with all content for new server
        System.out.println("\nPrepping for download");

        System.out.println("\nDownloading: " + Ver_Num);
        java.net.URL website = new URL(Link);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream("the-1710-pack_"+ Ver_Num +".zip");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        System.out.println("\nDownload for :" + "the-1710-pack_"+ Ver_Num +".zip" + " has completed, Now get configuring!");


        //ends program
        System.exit(10);
    }
    }
    }
  }



//BUNCH OF JUNK
/*  Object destDirectory = "o";
    String zipFilePath = "o";
    String Ver_Num = "o";
    Main main = new Main();
*/

    /*
    //Main Main_Server_Modded = new Main();
    //Main_Server_Modded.main3(Ver_Num);
    //main.main3(Ver_Num);
    //unzip.main();


    */

/*
    File f = new File(ServerPath);
    if (f.exists()) {
      //System.out.println("Server is already up to date!");
      // } else {
      System.out.println("Updating Server!");

      System.out.println("Downloading: " + Ver_Num);
      java.net.URL website = new URL(Link);
      ReadableByteChannel rbc = Channels.newChannel(website.openStream());
      FileOutputStream fos = new FileOutputStream("the-1710-pack_" + Ver_Num + ".zip");
      fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
      System.out.println("Download for" + Ver_Num + "has completed");


      ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
      ArrayList namesoffiles = names;
      //System.out.print(names);


    }
    public static void unzip(){

      String source = "some/compressed/file.zip";
      String destination = "some/destination/folder";
      String password = "password";

      try {
        ZipFile zipFile = new ZipFile(source);
        if (zipFile.isEncrypted()) {
          zipFile.setPassword(password);
        }
        zipFile.extractAll(destination);
      } catch (ZipException e) {
        e.printStackTrace();
      }



String finalVer_Num = Ver_Num;
      public void () throws IOException {
        String fileZip = (ServerPath + "the-1710-pack_" + finalVer_Num + ".zip");
        File destDir = new File(ServerPath);
        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
          File newFile = newFile(destDir, zipEntry);
          FileOutputStream fos = new FileOutputStream(newFile);
          int len;
          while ((len = zis.read(buffer)) > 0) {
            fos.write(buffer, 0, len);
          }
          fos.close();
          zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
      }

      public File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
          throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;



      }




    List<String> srcFiles = Arrays.asList(f.list());
    FileOutputStream fos = new FileOutputStream("the-1710-pack_0.9.8.zip");
    System.out.print(srcFiles);
    ZipOutputStream zipOut = new ZipOutputStream(fos);
    for (String srcFile : srcFiles) {
      File fileToZip = new File(srcFile);
      FileInputStream fis = new FileInputStream(fileToZip);
      ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
      zipOut.putNextEntry(zipEntry);

      byte[] bytes = new byte[1024];
      int length;
      while((length = fis.read(bytes)) >= 0) {
        zipOut.write(bytes, 0, length);
      }
      fis.close();
    }
    zipOut.close();
    fos.close();



    String filePathString = System.getProperty("user.dir");
    String filePath = (filePathString + "/" + test);

    File f = new File(filePath);

    if (f.exists()) {
      System.out.println("Server is already up to date!");
    } else {
      System.out.println("Updating Server!");

      System.out.println("Downloading: " + Ver_Node);
      java.net.URL website = new URL(Link);
      ReadableByteChannel rbc = Channels.newChannel(website.openStream());
      FileOutputStream fos = new FileOutputStream(Ver_Node);
      fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
      System.out.println("Download for" + Ver_Node + "has completed");

      System.out.println("Creating: eula.txt");
      PrintWriter Eula_Writer = new PrintWriter("eula.txt", "UTF-8");
      Eula_Writer.println("eula=true");
      Eula_Writer.close();
      System.out.println("Created: eula.txt");


      System.out.println("Creating: Start" + Ver_Node + ".txt...");
      PrintWriter Start_Writer = new PrintWriter("Start -" + Ver_Node + "-.bat", "UTF-8");
      Start_Writer.println("java -Xmx1024M -Xms1024M -jar " + Ver_Node + " nogui");
      Start_Writer.close();
      System.out.println("Start -" + Ver_Node + "-.bat Created");


*/