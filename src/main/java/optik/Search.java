package optik;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeMap;

public class Search {

    Random rand = new Random();
    private TreeMap<String, HashSet<?>> tempStorage;

    public Search() {
        tempStorage = new TreeMap<>();
    }

    public float uniform(String key, float min, float max) {
        float suggested = min + rand.nextFloat() * (max - min);
        if (!tempStorage.containsKey(key)) {
            tempStorage.put(key, new HashSet<>());
        }

        HashSet<?> keySet = tempStorage.get(key);
        if (keySet.contains(suggested)) {
            uniform(key, min, max);
        }

        tempStorage.put(key, keySet);

        return suggested;
    }

    public String categorical(String[] category) {
        int randomIndex = rand.nextInt(category.length);
        return category[randomIndex];
    }


}
