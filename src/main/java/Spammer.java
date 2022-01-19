import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;

public class Spammer {
    public void findSpammer(String args[]) throws IOException {
        SenderSpam senderSpam = new SenderSpam();
        String[] answer = senderSpam.findSpam(args);
        for(int i=0; i<answer.length; i++){
            if(answer[i] != null){
                System.out.println("Spammer is:");
                System.out.println(answer[i]);
            }
        }
    }
}
