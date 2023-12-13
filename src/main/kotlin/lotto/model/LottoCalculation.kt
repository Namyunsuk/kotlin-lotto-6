package lotto.model

class LottoCalculation {
    fun calculateProfitRate(purchaseAmount: Int, totalPrize: Int): Float {
        return (totalPrize.toFloat() / purchaseAmount) * 100
    }

    fun calculateLottoAmount(money: Int): Int {
        return money/LOTTO_PRICE
    }

    companion object{
        const val LOTTO_PRICE = 1000
    }
}