package optik

import java.util.Random
import java.util.TreeMap

class Search {

    private val rand = Random()
    private val tempStorage: TreeMap<String, MutableSet<Any>> = TreeMap()

    fun uniform(key: String, min: Float, max: Float): Float {
        val suggested: Float = min + rand.nextFloat() * (max - min)
        val label = "$key-uniform"

        if (!tempStorage.containsKey(label)) {
            tempStorage[label] = mutableSetOf()
        }

        val keySet = tempStorage[label]

        if (keySet != null) {
            if (keySet.contains(suggested)) {
                uniform(key, min, max)
            }

            tempStorage[label] = keySet
        }

        return suggested
    }

    fun categorical(category: Array<String>): String {
        val randomIndex = rand.nextInt(category.size)
        return category[randomIndex]
    }

    /*
    fun randInt(key: String,  max: Int): Int {
        val suggested: Int = rand.nextInt(max)
        val label = key + "-randInt"

        if (!tempStorage.containsKey(label)) {
            tempStorage[label] = mutableSetOf()
        }

        val keySet = tempStorage[label]

        if (keySet != null) {
            if (keySet.contains(suggested)) {
                randInt(key, max)
            }

            tempStorage[label] = keySet
        }

        print("randInt: $suggested")

        return suggested
    }
    */
}