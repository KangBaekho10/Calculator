# 나만의 계산기 만들기

프로젝트 과제로 나만의 계산기를 만들었습니다. <br/>

숫자와 연산자를 입력받아 간단한 계산을 할 수 있게 만들었습니다. <br/>

또한 사용자가 다른 계산을 원할 때, 다시 처음으로 돌아갈 수 있도록 구현하였습니다.

## 필수 구현 기능
  > **Lv. 1**
  > - 더하기, 빼기, 나누기, 곱하기 연산을 수행할 수 있는 Calculator 클래스를 만들기
  > - 생성한 클래스를 이용하여 연산을 진행하고 출력

  > **Lv. 2**
  > - Calculator 클래스에 “나머지 연산”이 가능하도록 코드를 추가하고, 연산 진행 후 출력

  > **Lv. 3**
  > - 클래스 간의 관계를 고려하여 Calculator 클래스와 관계 맺기

## 선택 구현 기능
  > **Lv. 4**
  > - 연산 클래스들을 AbstractOperation라는 클래스명으로 만들어 사용하여 추상 클래스로 정의, Calculator 클래스의 내부 코드를 변경

## 코드 구조

코드는 `AbstractOperation`와 `Calculator` 클래스가 주로 사용됩니다. <br/>

연산자로 정의된 클래스는 다음과 같습니다. <br/>

-> 덧셈 : `AddOperation`, 뺄셈 : `SubtractOperation`, 곱셈 : `MultiplyOperation`, 나눗셈 : `DivideOperation`, <br>
나머지 값 : `RemainderOperation`

- `AbstractOperation` : 연산자들의 부모 클래스 역할로 연산자 클래스들이 사용될 일반 메소드를 추상적으로 정의해두었습니다.
- `Calculator` : 사용자의 입력으로 호출된 클래스의 실제 계산이 진행되는 클래스입니다.

  > **코드 작동 과정**
  > 1) 프로그램이 시작되고 사용자로부터 숫자와 연산자를 입력받기 위해 안내 문장을 출력합니다.
  > 2) 첫 번째 숫자는 실수의 형태로 변수(num1)에 저장됩니다.
  > 3) 연산자는 사용자가 입력한 연산 기호를 문장으로 인식하고 이를 변수(operator)에 저장합니다. 
  > 4) 해당 변수에 값과 상응하는 연산자 클래스를 찾고 해당 클래스의 위치 정보를 변수(selectedOperator)에 저장합니다.
  > 5) 실제 계산이 이루어지는 클래스의 위치정보를 변수(calc)에 저장합니다.
  > 6) 두 번째 숫자도 실수의 형태로 변수(num2)에 저장됩니다.
  > 7) calc를 통해 num1과 num2가 selectedOperator에 의해 연산된 값을 출력

``` Kotlin
        // 연산자 인식
        val selectedOperator = when (operator) {
            "+" -> AddOperation()
            "-" -> SubtractOperation()
            "*" -> MultiplyOperation()
            "/" -> DivideOperation()
            "%" -> RemainderOperation()
            else -> {
                println("잘못된 연산자입니다.")
                return
            }
        }
```

## 구현 화면
1. 프로그램 시작 시 화면
    - 프로그램이 시작되면 프로젝트의 이름이 출력 됩니다.
    - 문장에 가시성을 높이기 위해 빈 줄이 삽입되었습니다.
    - `첫 번째 숫자`를 입력해달라는 문장이 출력되고, 이에 맞춰 사용자는 숫자를 입력할 수 있게 됩니다.

``` Kotlin
▶ 나만의 계산기입니다 ◀
 
☞ 첫 번째 숫자를 입력해주세요. :
```

2. 연산자 요청 화면
    - 숫자가 입력되면 나오는 문장입니다.
    - 연산자는 `+, -, *, /, %`로 이루어져 있습니다.
    - 연산자 기호와 다른 값을 입력했을 경우 `'잘못된 연산자입니다.'`라는 문장 출력됩니다.
  
``` Kotlin
☞ 연산자를 고르세요 ( +, -, *, /, % ) : 
```

3. 결과 화면
    - `두 번째 숫자`를 입력해달라는 문장이 출력되고, 이에 맞춰 사용자는 숫자를 입력할 수 있게 됩니다.
    - 입력 후 ENTER 시 `'(첫 번째 숫자) (연산자) (두 번째 숫자)의 결과는 : '` 이라는 문장이 출력됩니다.
    - 재계산 여부에 관한 문장이 출력되고, 사용자는 문장에 맞춰 재계산 여부를 결정할 수 있습니다.
    - 재계산 여부에서 `Y`를 입력한 사용자는 다시 첫 번째 숫자를 입력할 수 있습니다.
    - 재계산 여부에서 `N`를 입력한 사용자는 프로그램이 종료됩니다.

``` Kotlin
☞ 두 번째 숫자를 입력해주세요. : 
 
☞ ~의 결과는: 
 
☞ 다시 계산하시겠습니까? ('Y' : Yes / 'N' : No) : 
```

## 환경 설정<br>
Language : Kotlin<br/>
IDLE : IntelliJ IDEA Ultimate<br/>
JDK : 18.0.2 <br/>

