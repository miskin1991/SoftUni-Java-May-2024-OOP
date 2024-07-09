package Exercise.Abstractions._06_GreedyTimes;

import java.util.*;

public class Bag implements Iterable<Map.Entry<String, LinkedHashMap<String, Long>>> {
    private LinkedHashMap<String, LinkedHashMap<String, Long>> bag;

    public Bag() {
        bag = new LinkedHashMap<>();
    }

    public boolean containsResource(String resourceName) {
        return bag.containsKey(resourceName);
    }

    public long getResourceSumByName(String resourceName) {
        return bag.get(resourceName).values().stream().mapToLong(e -> e).sum();
    }

    public long getAllResourcesSum() {
        return bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum();
    }

    public LinkedHashMap<String, Long> getResource(String resourceName) {
        return bag.get(resourceName);
    }

    public void createNewResource(String resourceName) {
        bag.putIfAbsent(resourceName, new LinkedHashMap<>());
    }

    public String getResourcesStats(String resourceName) {
        StringBuilder output = new StringBuilder();
        bag.get(resourceName).entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> output.append(String.format("##" + i.getKey() + " - " + i.getValue())));
        return output.toString();
    }

    @Override
    public Iterator<Map.Entry<String, LinkedHashMap<String, Long>>> iterator() {
        return new Iterator<Map.Entry<String, LinkedHashMap<String, Long>>>() {
            private final Iterator<Map.Entry<String, LinkedHashMap<String, Long>>> iterator = bag.entrySet().iterator();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Map.Entry<String, LinkedHashMap<String, Long>> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return iterator.next();
            }
        };
    }
}
