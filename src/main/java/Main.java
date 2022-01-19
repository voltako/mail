import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("1:XDSPAM\n" + "2:BarGraph\n" + "3:Spammer");
        Scanner scanner = new Scanner(System.in);
        Integer number = Integer.valueOf(scanner.nextLine());
        ValueXDSPAM valueXDSPAM = new ValueXDSPAM();
        BarGraph barGraph = new BarGraph();
        Spammer spammer = new Spammer();
        if (number == 1){
            valueXDSPAM.xdSPAM(args);
        }
        else if (number == 2){
            barGraph.barGraphConstructor(args);
        }
        else if (number == 3){
            spammer.findSpammer(args);
        }
        else{
            System.out.println("ERROR");
        }
    }
}
