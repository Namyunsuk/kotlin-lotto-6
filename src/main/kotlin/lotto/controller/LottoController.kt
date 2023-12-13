package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoCalculation
import lotto.model.LottoGenerator
import lotto.utils.Rank
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val lotteries = mutableListOf<Lotto>()
    private val result = makeResult()
    fun start() {
        val lottoGenerator = LottoGenerator()
        val lottoCalculation = LottoCalculation()
        val purchaseMoney = InputView.enterPurchaseAmount()
        addLotto(lottoGenerator, lottoCalculation, purchaseMoney)
        countLottoMatch()
        result(lottoCalculation, purchaseMoney)
    }

    private fun result(lottoCalculation: LottoCalculation, purchaseMoney: Int) {
        printStatistics()
        calculateProfitRate(lottoCalculation, purchaseMoney)
    }

    private fun calculateProfitRate(lottoCalculation: LottoCalculation, purchaseMoney: Int) {
        var totalPrize = 0
        for ((rank, count) in result) {
            totalPrize += rank.prize * count
        }

        val profitRate = lottoCalculation.calculateProfitRate(purchaseMoney, totalPrize)
        OutputView.printProfitRate(profitRate)
    }

    private fun printStatistics() {
        OutputView.printResultComment()
        for ((rank, count) in result) {
            OutputView.printResult(rank.matchNum, rank.prize, count, rank.bonusNum)
        }
    }

    private fun countLottoMatch() {
        val prizeNumber = InputView.enterPrizeNumber()
        val bonusNumber = InputView.enterBonusNumber()
        for (lotto in lotteries) {
            val (matchCount, bonus) = lotto.matchCount(prizeNumber, bonusNumber)
            val rank = Rank.matchRank(matchCount, bonus)
            result[rank] = result.getValue(rank) + 1
        }
    }

    private fun addLotto(lottoGenerator: LottoGenerator, lottoCalculation: LottoCalculation, purchaseMoney: Int) {
        val lottoAmount = lottoCalculation.calculateLottoAmount(purchaseMoney)
        OutputView.printPurchaseAmount(lottoAmount)
        for (i in 0 until lottoAmount) {
            val lotto = lottoGenerator.generateLotto()
            OutputView.printPurchaseLotto(lotto)
            lotteries.add(Lotto(lotto))
        }
    }

    private fun makeResult(): MutableMap<Rank, Int> {
        val result = mutableMapOf<Rank, Int>()
        for (rank in Rank.entries) {
            result[rank] = 0
        }
        result.remove(Rank.MISS)
        return result
    }
}