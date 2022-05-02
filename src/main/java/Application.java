import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Application {

    static StringParser parser = new StringParser();
    static TaskResolver resolver = new TaskResolver();

    static FileWriter fileWriter;
    static FileReader fileReader;

    public static void main(String[] args) throws Exception {
        fileReader = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int i = 0;
        String line = bufferedReader.readLine();
        while (line != null) {
            System.out.println(line);
            System.out.println("-----");

            fileWriter = new FileWriter("var" + ++i + ".txt");

            List<Double> elements = parser.parseToIntList(line);
            Map<Double, Double> probability = resolver.calculateEachElementProbability(elements);

            Set<Entry<Double, Double>> entries = probability.entrySet();
            entries.forEach(e -> {
                try {
                    fileWriter.write(String.valueOf(e) + "\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

            fileWriter.write("average=" + resolver.findAverage(elements).toString());
            fileWriter.write("\nscope=" + resolver.findScope(elements).toString());
            fileWriter.write("\nmoda=" + resolver.getModa());

            fileWriter.close();

            line = bufferedReader.readLine();
        }
    }
}
