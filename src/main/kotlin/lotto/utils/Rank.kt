package lotto.utils

enum class Rank(val matchNum: Int, val prize: Int, val bonusNum: Boolean) {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5,1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    companion object{
        fun matchCount(matchNum: Int, bonusNum: Boolean):Rank{
            return entries.firstOrNull { it.matchNum==matchNum&&it.bonusNum== bonusNum}?:MISS
        }
    }
}