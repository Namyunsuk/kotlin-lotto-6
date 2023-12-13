package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    companion object {
        fun enterPurchaseAmount(): Int {
            println("구입금액을 입력해 주세요.")
            val amount = Console.readLine()
            return amount.toInt()
        }

        fun enterPrizeNumber(): List<Int> {
            println()
            println("당첨 번호를 입력해 주세요.")
            val userInput = Console.readLine()
            val prizeNumbers = userInput.split(",")
            return prizeNumbers.map { it.toInt() }
        }

        fun enterBonusNumber(): Int {
            println()
            println("보너스 번호를 입력해 주세요.")
            val bonusNumber = Console.readLine()
            return bonusNumber.toInt()
        }
    }
}