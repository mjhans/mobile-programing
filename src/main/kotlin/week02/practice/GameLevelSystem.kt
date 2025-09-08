package com.bible.week02.practice

data class Player(
    val name: String,
    var level: Int = 1,
    var experience: Int = 0,
    var gold: Int = 100
)

class GameSystem {

    // 레벨별 필요 경험치 계산 (반복문 활용)
    fun getRequiredExpForLevel(targetLevel: Int): Int {
        var totalExp = 0
        // 각 레벨당 필요 경험치: level * 100
        // 예: 레벨 1→2 = 100, 레벨 2→3 = 200, 레벨 3→4 = 300
        // for문을 사용해 1부터 targetLevel-1까지 누적
        return totalExp
    }

    // 경험치에 따른 현재 레벨 계산
    fun calculateLevel(experience: Int): Int {
        var currentLevel = 1
        // while문을 사용해 경험치가 충분한 동안 레벨업
        while (experience >= getRequiredExpForLevel(currentLevel + 1)) {
            currentLevel++
        }
        return currentLevel
    }

    // 레벨업 보상 계산 (when + range 활용)
    fun getLevelUpReward(newLevel: Int): Int {
        return when (newLevel) {
            in 2..5 -> 50      // 초급: 50골드
            in 6..10 -> 100    // 중급: 100골드
            in 11..20 -> 200   // 고급: 200골드
            in 21..50 -> 500   // 전문가: 500골드
            else -> 1000       // 마스터: 1000골드
        }
    }

    // 경험치 획득 및 레벨업 처리
    fun gainExperience(player: Player, expGained: Int) {
        val oldLevel = player.level
        player.experience += expGained
        player.level = calculateLevel(player.experience)

        // 레벨업이 발생했다면
        if (player.level > oldLevel) {
            // 여러 레벨을 한번에 올랐을 수 있으므로 for문으로 처리
            for (level in (oldLevel + 1)..player.level) {
                val reward = getLevelUpReward(level)
                player.gold += reward
                println("🎉 ${player.name} 레벨 $level 달성! 보상: ${reward}골드")
            }
        }

        println("${player.name}: 경험치 +$expGained (총 ${player.experience})")
    }
}

fun main() {
    val player = Player("용사김코틀린")
    val gameSystem = GameSystem()

    // 다양한 경험치 획득 시나리오
    val expGains = listOf(150, 250, 400, 300, 500, 800)

    for ((day, exp) in expGains.withIndex()) {
        println("\n=== Day ${day + 1} ===")
        gameSystem.gainExperience(player, exp)
        println("현재 상태: 레벨 ${player.level}, 골드 ${player.gold}")
    }
}