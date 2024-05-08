package org.example

fun main() {
    val blank:String = " "
    var num1 = 0.0
    var num2 = 0.0
    var operator = ""
    var Op = arrayListOf("+","-","*","/","%")
    println(blank)
    println("★나만의 계산기입니다★")
    var retry = "Y"
    while (retry == "Y") {
        println(blank)
        try {
            print("☞ 첫 번째 숫자를 입력해주세요. : ")
            num1 = readln().toDouble()
            print("☞ 연산자를 고르세요 ( +, -, *, /, % ) : ")
            operator = readln().toString()
            if(!Op.contains(operator)) {
                println(blank)
                println("잘못된 연산자입니다.")
                continue
            }
            print("☞ 두 번째 숫자를 입력해주세요. : ")
            num2 = readln().toDouble()

        } catch (e:NumberFormatException) {
            println(blank)
            println("숫자를 입력해주세요.")
            continue
        }
        val selectedOperator = when (operator) {
            "+" -> AddOperation()
            "-" -> SubtractOperation()
            "*" -> MultiplyOperation()
            "/" -> DivideOperation()
            "%" -> RemainderOperation()
            else -> {
                return
            }
        }

        val calc = Calculator()

        println(blank)
        println("☞ ${num1} ${operator} ${num2}의 결과는: ${calc.operation(selectedOperator, num1, num2)}")
        println(blank)
        print("☞ 다시 계산하시겠습니까? ('Y' : Yes / 'N' : No) : ")
        retry = readLine() ?: "N"
    }
}

abstract class AbstractOperation {
    abstract fun operate(num1: Double, num2: Double): Double
}

class Calculator() {
    fun operation(operator: AbstractOperation, num1: Double, num2: Double): Double = operator.operate(num1, num2)
}

class AddOperation : AbstractOperation() {
    override fun operate(num1: Double, num2: Double): Double = (num1 + num2)
}

class SubtractOperation : AbstractOperation() {
    override fun operate(num1: Double, num2: Double): Double = (num1 - num2)
}

class MultiplyOperation : AbstractOperation() {
    override fun operate(num1: Double, num2: Double): Double = (num1 * num2)
}

class DivideOperation : AbstractOperation() {
    override fun operate(num1: Double, num2: Double): Double = (num1 / num2)
}

class RemainderOperation : AbstractOperation() {
    override fun operate(num1: Double, num2: Double): Double = (num1 % num2)
}