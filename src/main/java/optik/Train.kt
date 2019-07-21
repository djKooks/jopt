package optik

class Train constructor(targetValue: Int = 0) {

    private val targetValue: Int = targetValue

    fun run(turn: Int, trainFunction: ITrainFunction): Float {
        var largest = 0.0f

        for (i in 0..turn) {
            val data = trainFunction.run()
            if (largest < data) {
                largest = data
            }
        }

        return largest
    }
}
