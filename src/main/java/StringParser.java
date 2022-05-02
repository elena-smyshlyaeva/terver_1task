import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    public List<Double> parseToIntList(String string) {
        String[] splittingStrings = string.split(", |,|. |; ");

        return Arrays.stream(splittingStrings).map(Double::parseDouble)
            .collect(Collectors.toList());
    }

    private void printResultList(List<Integer> list) {
        list.forEach(System.out::println);
    }
}
