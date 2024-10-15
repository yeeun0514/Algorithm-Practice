package leetcode

class Question14 {
    fun longestCommonPrefix(strs: Array<String>): String {
        var prefix = strs[0]
        for (i in 0..strs.size-2){
            prefix = prefix.commonPrefixWith(strs[i+1])
        }
        return prefix
    }
}

fun main(){
    val question = Question14()
    val case1 = arrayOf("flower","flow","flight")
    val case2 = arrayOf("dog","racecar","car")
    val case3 = arrayOf("ab", "a")
    val answer = question.longestCommonPrefix(case3)
    println("answer: $answer")
}