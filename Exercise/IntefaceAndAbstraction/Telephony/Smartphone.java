package Exercise.IntefaceAndAbstraction.Telephony;

import java.util.List;
import java.util.function.Predicate;

public class Smartphone implements Browsable, Callable {
    private final List<String> numbers;
    private final List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        return getListContent(urls, Character::isDigit, true, "Browsing: %s!", "Invalid URL!");
    }

    @Override
    public String call() {
        return getListContent(numbers, Character::isDigit, false, "Calling... %s", "Invalid number!");
    }

    private static String getListContent(List<String> list, Predicate<Character> predicate, boolean negate,
                                         String action, String errorMsg) {
        StringBuilder sb = new StringBuilder();
        if (!list.isEmpty()) {
            for (String element : list) {
                boolean valid = true;
                for (Character d : element.toCharArray()) {
                    if (negate) {
                        valid = !predicate.test(d);
                    } else {
                        valid = predicate.test(d);
                    }
                    if (!valid) break;
                }
                if (valid)
                    sb.append(action.formatted(element)).append(System.lineSeparator());
                else
                    sb.append(errorMsg).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
