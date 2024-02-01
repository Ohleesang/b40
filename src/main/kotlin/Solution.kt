/**
 *  유한소수 : 소수점 아래숫자가 계속되징낳고 유한개인 소수
 *  - 기약 분수로 나타내었을때, 분모의 소인수가 2와 5만 존재
 *  1. 최대 공약수를 구한다.
 *  2. 들어온 a,b 에 최대 공약수를 나눈다.
 *  3. 이때, 분모가 2와 5로 구성되어있는지 파악한다.
 */

class Solution {
    private fun gcd(a: Int, b: Int): Int = if (b != 0) gcd(b, a % b) else a

    private fun isDivided(a : Int):Boolean{
        var res = a
        while(res!=1){
            res /= if(res%2==0) 2
            else if(res%5==0) 5
            else return false
        }
        return true
    }
    fun solution(a: Int, b: Int): Int {
        var answer: Int = 0
        val gcd = gcd(a, b)
        val dividedA = a / gcd
        val dividedB = b / gcd

        answer = if(isDivided(dividedB)) 1
        else 2


        return answer
    }

}

fun main() {
    val a = Solution()
    a.solution(7, 20) //1
    a.solution(11, 22) // 1
    a.solution(12, 21) // 2
}