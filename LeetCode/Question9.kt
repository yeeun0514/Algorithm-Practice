package leetcode

class Question9 {
    fun isPalindrome(x: Int): Boolean {
        val reverse = x.toString().reversed()

        return x.toString() == reverse
    }
}

fun main(){
    val question = Question9()
    val case1 = 121
    val result = question.isPalindrome(case1)
    println(result)
}
