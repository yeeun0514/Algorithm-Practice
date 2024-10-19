class Question1545 {
    fun findKthBit(n: Int, k: Int): Char {
        val str = StringBuilder()
        str.append("0")

        for (i in 2..n){
            if (str.length >= k) break
            str.append(1)
            for (s in str.length-2 downTo 0){
                val a = if(str[s] == '1') '0' else '1'
                str.append(a)
            }
        }
        return str[k-1]
    }
}

fun main() {
    val question = Question1545()
    val case1 = arrayOf(3, 1)
    val case2 = arrayOf(4, 11)
    val answer = question.findKthBit(case2[0], case2[1])
    println("answer : $answer")
}