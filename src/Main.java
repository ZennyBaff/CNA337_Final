
//https://stackoverflow.com/questions/921262/how-to-download-and-save-a-file-from-internet-using-java
//https://alvinalexander.com/blog/post/java/how-open-read-url-java-url-class-example-code
//https://www.youtube.com/watch?v=JcZwlpV1rMc
//https://chortle.ccsu.edu/java5/Notes/chap54/ch54_11.html
//https://www.youtube.com/watch?v=v-myixc6C0I
//https://www.youtube.com/watch?v=1PipslRY0bc
//https://coderanch.com/t/406173/java/determine-string-array-string
//https://docs.oracle.com/javase/7/docs/api/java/io/PrintWriter.html
//https://stackoverflow.com/questions/7301764/how-to-get-contents-of-a-folder-and-put-into-an-arraylist
//https://www.youtube.com/watch?v=CSifkubnE-E
//https://www.youtube.com/watch?v=7MBgaF8wXls


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String Ver_Num) throws IOException {

//----------------MC_Server_Vanilla.java---------------------------------

    MC_Server_Vanilla Vanilla = new MC_Server_Vanilla();

    //Vanilla.main();


//----------------MC_Server_Modded.java---------------------------------

        MC_Server_Modded Modded = new MC_Server_Modded.();
        Unzip unzip = new Unzip();

        Modded.main(Ver_Num);
        unzip.main(Ver_Num);



        /*System.out.println("Hello World!");
        URL website = new URL("https://launcher.mojang.com/v1/objects/3737db93722a9e39eeada7c27e7aca28b144ffa7/server.jar");
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream("information.jar");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
*/

        }


        // close our reader

/*
        String str = line;
        String findStr = "hello";
        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1){

            lastIndex = str.indexOf(findStr,lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex += findStr.length();
            }
        }
        System.out.println(count);
*/
        }
