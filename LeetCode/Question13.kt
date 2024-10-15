package leetcode

class Question13 {
    fun romanToInt(s: String): Int {
        val reverse = s.reversed().toList()
        var past = 'A'
        var answer = 0
        for (i in reverse.indices){
            val value = when(reverse[i]){
                'I' -> {
                    if (past == 'V' || past == 'X') -1
                    else 1
                }
                'V' -> 5
                'X' -> {
                    if (past == 'L' || past == 'C') -10
                    else 10
                }
                'L' -> 50
                'C' -> {
                    if (past == 'D' || past == 'M') -100
                    else 100
                }
                'D' -> 500
                else -> 1000
            }
            answer += value
            past = reverse[i]
        }

        return answer
    }
}

fun main(){
    val question = Question13()
    val answer = question.romanToInt("MCMXCIV")
    println("answer: $answer")
}