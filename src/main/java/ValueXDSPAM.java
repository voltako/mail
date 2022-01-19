import java.io.IOException;
public class ValueXDSPAM {
    public void xdSPAM(String[] args) throws IOException {
        SenderXDSPAM senderXDSPAM = new SenderXDSPAM();
        Float answer_xds = senderXDSPAM.findXDSPAM(args);
        System.out.println("Среднее значение X-DSPAM-Probability = " + answer_xds.toString());
    }
}
