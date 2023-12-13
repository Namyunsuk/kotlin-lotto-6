package lotto.model

class LottoCalculation {
    fun calculateProfitRate(purchaseAmount: Int, totalPrize: Int): Float {
        return (totalPrize.toFloat() / purchaseAmount) * 100
    }
}