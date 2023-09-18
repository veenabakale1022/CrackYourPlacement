import java.util.*;

class RandomizedCollection {
    private List<Integer> elements;
    private Map<Integer, Set<Integer>> indexMap;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        elements = new ArrayList<>();
        indexMap = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean isNew = !indexMap.containsKey(val);
        if (isNew) {
            indexMap.put(val, new LinkedHashSet<>());
        }
        indexMap.get(val).add(elements.size());
        elements.add(val);
        return isNew;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (indexMap.containsKey(val)) {
            Set<Integer> indices = indexMap.get(val);
            int indexToRemove = indices.iterator().next();
            indices.remove(indexToRemove);

            if (indices.isEmpty()) {
                indexMap.remove(val);
            }

            if (indexToRemove < elements.size() - 1) {
                int lastElement = elements.get(elements.size() - 1);
                elements.set(indexToRemove, lastElement);

                Set<Integer> lastElementIndices = indexMap.get(lastElement);
                lastElementIndices.remove(elements.size() - 1);
                lastElementIndices.add(indexToRemove);
            }

            elements.remove(elements.size() - 1);
            return true;
        }

        return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return elements.get(random.nextInt(elements.size()));
    }
}
