package optik

import java.util.*

class Search {

    private val rand = Random()
    private val tempStorage: TreeMap<String, MutableSet<Any>> = TreeMap()

    fun uniform(key: String, min: Float, max: Float): Float {
        val suggested: Float = min + rand.nextFloat() * (max - min)
        
        if (!tempStorage.containsKey(key)) {
            tempStorage[key] = mutableSetOf()
        }

        val keySet = tempStorage[key]

        if (keySet != null) {
            if (keySet.contains(suggested)) {
                uniform(key, min, max)
            }

            tempStorage[key] = keySet
        }

        return suggested
    }

    fun categorical(category: Array<String>): String {
        val randomIndex = rand.nextInt(category.size)
        return category[randomIndex]
    }
}