import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskResolver {

    Double moda;

    public Map<Double, Double> calculateEachElementProbability(List<Double> elements) {
        Map<Double, Integer> elementRepeat = new HashMap<>();

        for (Double e : elements) {
            elementRepeat.computeIfPresent(e, (k, v) -> ++v);
            elementRepeat.putIfAbsent(e, 1);
        }
        printMap(elementRepeat);

        long countElements = elements.size();
        Integer maxRepeats = 0;
        Map<Double, Double> resultMap = new HashMap<>();

        for (Double e: elements) {
            Integer repeats = elementRepeat.get(e);

            if (repeats > maxRepeats) {
                maxRepeats = repeats;
                moda = e;
            }

            Double probability = repeats.doubleValue() / countElements;
            resultMap.put(e, probability);
        }

        printMap(resultMap);
        return resultMap;
    }

    public Double findAverage(List<Double> elements) {
        Double sum = 0D;
        int count = elements.size();
        for (Double e: elements) {
            sum += e;
        }

        return sum / (double) count;
    }

    public Double findScope(List<Double> elements) {
        Double max = elements.stream().max(Comparator.comparingDouble(value -> value)).get();
        Double min = elements.stream().min(Comparator.comparingDouble(value -> value)).get();

        return max - min;
    }

    public Double getModa() {
        return moda;
    }

    private void printMap(Map<?, ?> map) {
        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
