package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        String studentNr = "013449315";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats.herokuapp.com/students/"+studentNr+"/submissions";

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);

        InputStream stream =  method.getResponseBodyAsStream();

        String bodyText = IOUtils.toString(stream);

        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        System.out.println("opiskelijanumero " + studentNr);

        //System.out.println("Oliot:");
        int tunnitYhteensa =0;
        int tehtaviaYhteensa =0;
        for (Submission submission : subs) {
            System.out.println(submission);
            tunnitYhteensa += submission.getHours();
            tehtaviaYhteensa += submission.tehtaviaYhteensa();
        }
        
        System.out.println("yhteensa: " + tehtaviaYhteensa + " tehtävää " + tunnitYhteensa + " tuntia");

    }
}