package org.example

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    val hotelReservation = HotelReservation()
    hotelReservation.start()
}

data class ReservationInfo(val name: String, var room:Int, var checkIn:String, var checkOut:String)
data class TransactionInfo (val name:String, val info:String, val money:Int)

class HotelReservation {

    private var reservationInfoList = arrayOf<ReservationInfo>()
    private var transactionInfoList = arrayOf<TransactionInfo>()

    fun start() {

        getHotelMenu()

        val userInput = readln().toInt()

        when (userInput) {
            1 -> reservationRoom()
            2 -> reservationList()
            3 -> reservationSortedList()
            4 -> {
                endSystem()
                return
            }

            5 -> moneyList()
            6 -> reservationChange()
            else -> println("일치하는 메뉴가 존재하지 않습니다.")
        }
    }

    private fun getHotelMenu() {

        println("┌─────────────────────────────────┐")
        println("    호텔 예약 프로그램입니다.")
        println("    1. 방 예약")
        println("    2. 예약목록 출력")
        println("    3. 예약목록(정렬) 출력")
        println("    4. 시스템 종료")
        println("    5. 금액 입금·출금 내역 목록 출력")
        println("    6. 예약 변경/취소")
        println("└─────────────────────────────────┘")
        print("원하는 메뉴의 번호를 입력해주세요. : ")
    }


    private fun reservationRoom() {

        println("예약자분의 성함을 입력해주세요.")
        val name = readLine() ?: ""

        val room = 0

        while (room > 99 || room < 1000) {
            println("예약할 방번호를 입력해주세요.")
            val room = readln().toInt()

            if (room < 99 || room > 1000) {
                println("$room 는 올바르지 않은 방번호 입니다. 방번호는 100-999 영역 이내입니다.")
            } else {
                break
            }
        }

        val nowDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
        val nowDateStr = nowDate.format(formatter)

        var checkIn: String = ""
        var checkOut: String = ""

        while (true) {

            var checkIn = "00000000"

            while (checkIn.toInt() < nowDateStr.toInt()) {
                println("체크인 날짜를 입력해주세요. (표기형식 : ${nowDate} (-제외))")
                checkIn = readln()

                if (checkIn.toInt() < nowDateStr.toInt()) {
                    println("체크인은 지난 날은 선택할 수 없습니다.")
                }
            }

            var checkOut = "00000000"

            while (checkOut.toInt() <= checkIn.toInt()) {
                println("체크아웃 날짜를 입력해주세요. (표기형식 : ${nowDate} (-제외))")
                checkOut = readln()

                if (checkOut.toInt() <= checkIn.toInt()) {
                    println("체크아웃은 체크인 날짜보다 이전이거나 같을 수 없습니다")
                }
            }
            break
        }

        transactionInfoList += TransactionInfo(name, "예약비 입금", 79000)
        transactionInfoList += TransactionInfo(name, "예약비 출금", -79000)

        //(5) 호텔 예약 내역 저장하기
        val newReservationInfo = ReservationInfo(name, room, checkIn, checkOut)
        reservationInfoList += newReservationInfo

        println("호텔 예약이 완료되었습니다.")
    } // 방 예약 함수

    private fun reservationList() {

    } // 예약목록 출력

    private fun reservationSortedList() {

    } // 예약목록(정렬) 출력

    private fun endSystem() {
        println("시스템을 종료합니다.")
    } // 시스템 종료

    private fun moneyList() {

    } // 금액 입금출금 내역 목록 출력

    private fun reservationChange() {

    } // 예약 변경/취소

}