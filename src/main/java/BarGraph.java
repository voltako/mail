import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BarGraph {
    public void barGraphConstructor(String args[]) throws IOException {
        SenderGraph senderGraph = new SenderGraph();
        ConstructionGraph.construction(senderGraph.senderGraph(args));
    }
}

