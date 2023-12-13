package lotto.view

class OutputView {
    companion object {
        fun printPurchaseAmount(purchaseAmount: Int) {
            println()
            println("${purchaseAmount}개를 구매했습니다.")
        }

        fun printPurchaseLotto(lottoNumber: List<Int>) {
            println(lottoNumber)
        }

        fun printResultComment() {
            println()
            println("당첨 통계")
            println("---")
        }

        fun printResult(rankCount: Int, prize: Int, matchCount: Int, isBonus: Boolean) {
            if (isBonus) {
                println("${rankCount}개 일치, 보너스 볼 일치 (${String.format("%,d", prize)}원) - ${matchCount}개")
                return
            }
            println("${rankCount}개 일치 (${String.format("%,d", prize)}원) - ${matchCount}개")
        }

        fun printProfitRate(profitRate: Float){
            print("총 수익률은 ${String.format("%.1f",profitRate)}%입니다.")
        }
    }
}