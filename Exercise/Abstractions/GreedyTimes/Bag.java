package Exercise.Abstractions.GreedyTimes;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Bag {
    private final long capacity;
    private final Map<String, Long> gold;
    private long goldSum;
    private final Map<String, Long> gems;
    private long gemsSum;
    private final Map<String, Long> cash;
    private long cashSum;

    public Bag(long capacity) {
        this.capacity = capacity;
        gold = new TreeMap<>();
        goldSum = 0;
        gems = new TreeMap<>(Comparator.reverseOrder());
        gemsSum = 0;
        cash = new TreeMap<>(Comparator.reverseOrder());
        cashSum = 0;
    }

    public void addGold(long amount) {
        if (addItem(gold, "Gold", amount)) {
            goldSum += amount;
        }
    }

    public void addGem(String name, long amount) {
        if (gemsSum + amount <= goldSum) {
            if (addItem(gems, name, amount)) {
                gemsSum += amount;
            }
        }
    }

    public void addCash(String name, long amount) {
        if (cashSum + amount <= gemsSum) {
            if (addItem(cash, name, amount)) {
                cashSum += amount;
            }
        }
    }

    private boolean addItem(Map<String, Long> map, String name, long amount) {
        if (map.containsKey(name)) {
            map.put(name, map.get(name) + amount);
            return true;
        } else {
            if (map.size() < capacity) {
                map.put(name, amount);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (capacity < (goldSum + gemsSum + cashSum)) {
            gold.clear();
            gems.clear();
            cash.clear();
        }
        StringBuilder sb = new StringBuilder();
        printMap(sb, "<Gold> $", goldSum, gold);
        printMap(sb, "<Gem> $", gemsSum, gems);
        printMap(sb, "<Cash> $", cashSum, cash);
        return sb.toString();
    }

    private void printMap(StringBuilder sb, String str, long sum, Map<String, Long> map) {
        if (map.isEmpty())
            return;
        sb.append(str).append(sum).append(System.lineSeparator());
        for (var gem : map.entrySet()) {
            sb.append("##").append(gem.getKey()).append(" - ").append(gem.getValue()).append(System.lineSeparator());
        }
    }
}
