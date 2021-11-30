/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class SendoutputSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        String spec = "http://localhost:8080/sample.jsp";
        URL url = new URL(spec);
        URLConnection urlcon = url.openConnection();
        urlcon.setDoInput(true);
        urlcon.setDoOutput(true);
        urlcon.connect();
        try ( OutputStream os = urlcon.getOutputStream()) {
            os.write("user=thuc&password=thuc".getBytes());
            os.flush();
        }
        try ( Scanner in = new Scanner(urlcon.getInputStream())) {
            if (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }
    
}
