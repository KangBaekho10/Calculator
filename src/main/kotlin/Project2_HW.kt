package org.example

fun main() {
    var isValid = false
    var selectedMenu = 0


    while (isValid == false) {
        try {
            selectedMenu = getMenu()
            isValid = true
        } catch (e: Exception) {
            isValid = false
        }
    }

    when (selectedMenu) {
        1 -> startGame()
        2 -> createCharacter()
        3 -> endGame()
    }
} // 게임 메뉴

fun getMenu(): Int {

    println("메뉴를 입력해주세요")
    println("1. 게임 시작하기")
    println("2. 캐릭터 추가")
    println("3. 게임 끝내기")

    val userInput = readLine()!!.toInt()

    if (userInput < 1 || userInput > 3) {
        println("입력이 잘못되었습니다. : $userInput 는 메뉴에 존재하지 않습니다.")
    }

    return userInput

}

fun startGame() {
    println("게임이 시작되었습니다.")
}   // 게임 시작 함수

fun createCharacter() {

    val characterList: MutableList<Map<String, String>> = mutableListOf()

    var needMoreCharacter = "Y"

    while (needMoreCharacter == "Y") {

        println("추가할 캐릭터의 이름을 입력해주세요.")
        val name = readLine() ?: ""

        println("추가할 캐릭터의 직업을 입력해주세요.")
        val job = readLine() ?: ""

        val character = mapOf("name" to name, "job" to job)

        characterList.add(character)

        println("사용자를 더 추가하시겠습니까? (Y : Yes, N : No)")

        needMoreCharacter = readLine() ?: "N"

    }

    characterList.forEach {
        println(it)
    }

}   //캐릭터 추가 함수

fun endGame() {
    println("게임이 종료되었습니다.")
}   // 게임 종료 함수
