package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    fun generateLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}