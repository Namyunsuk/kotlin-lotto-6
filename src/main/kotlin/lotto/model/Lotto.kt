package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun matchCount(prizeNumbers: List<Int>, bonusNumber: Int): Pair<Int, Boolean> {
        val count = prizeNumbers.filter { numbers.contains(it) }.count()
        val bonusNum = numbers.contains(bonusNumber)
        return Pair(count, bonusNum)
    }
}
