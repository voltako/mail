import java.io.BufferedReader;
import java.io.IOException;

public class SenderSpam {
    public String[] findSpam(String[] args) throws IOException {
        ConnectURL connectURL = new ConnectURL();
        BufferedReader in = connectURL.connect(args);

        String inputLine;

        String cnf = null;
        String prob;
        String res;

        Float[] cnf_arr = new Float[10000];
        Integer number_cnf = 0;

        Float[] prb_arr = new Float[10000];
        Integer number_prb = 0;

        String[] res_arr = new String[10000];
        Integer number_res = 0;

        String[] mail_arr = new String[10000];
        String mail;
        Integer number_mail = 0;


        while((inputLine = in.readLine()) != null){
            StringBuilder confidence = new StringBuilder();
            StringBuilder probability = new StringBuilder();
            StringBuilder result = new StringBuilder();

            StringBuilder line_cnf = new StringBuilder();
            StringBuilder line_prob = new StringBuilder();
            StringBuilder line_res = new StringBuilder();

            StringBuilder test_ch = new StringBuilder();
            StringBuilder test = new StringBuilder();



            if(inputLine.length() > 21) {
                for (int i = 0; i <= 19; i++) {
                    confidence.append(inputLine.charAt(i));
                }
                for (int i = 0; i <= 20; i++) {
                    probability.append(inputLine.charAt(i));
                }
                for (int i = 0; i <= 15; i++) {
                    result.append(inputLine.charAt(i));
                }
                if(inputLine.length() > 6){
                    for(int i=0; i<=4; i++){
                        test_ch.append(inputLine.charAt(i));
                    }
                }

                if (test_ch.toString().equals("From:")){
                    test.append(inputLine.toString().replace("From:", ""));
                    mail = inputLine.toString().replace("From:", "");
                    mail_arr[number_cnf] = mail.toString();
                    number_mail += 1;
                }

                if(confidence.toString().equals("X-DSPAM-Confidence: ")){
                    for(int i=0; i<inputLine.length(); i++){
                        line_cnf.append(inputLine.charAt(i));
                    }
                    cnf = line_cnf.toString().replace("X-DSPAM-Confidence: ", "");
                    cnf_arr[number_cnf] = Float.parseFloat(cnf);
                    number_cnf += 1;
                }
                if(probability.toString().equals("X-DSPAM-Probability: ")){
                    for(int i=0; i<inputLine.length(); i++){
                        line_prob.append(inputLine.charAt(i));
                    }
                    prob = line_prob.toString().replace("X-DSPAM-Probability: ", "");
                    prb_arr[number_prb] = Float.parseFloat(prob);
                    number_prb += 1;
                }
                if(result.toString().equals("X-DSPAM-Result: ")){
                    for(int i=0; i<inputLine.length(); i++){
                        line_res.append(inputLine.charAt(i));
                    }
                    res = line_res.toString().replace("X-DSPAM-Result: ", "");
                    res_arr[number_res] = res;
                    number_res += 1;
                }
            }
        }

        String[] answer = new String[10000];
        ComparisonSpam comparisonSpam = new ComparisonSpam();
        answer = comparisonSpam.compare(cnf_arr, prb_arr, res_arr, mail_arr);
        in.close();

        return answer;
    }
}
