class Question2938 {
    fun minimumSteps(s: String): Long {
        val oneCount = s.count{ it == '1'}
        val sLength = s.length
        val sArray = s.toCharArray()
        var totalCount = 0L
        for (i in sArray.indices){
            if (sArray[i] == '1'){
                totalCount += (sLength-1-i)
            }
        }

        for (i in 1 until  oneCount){
            totalCount -= i
        }

        return totalCount
    }
}

fun main(){
    val question = Question2938()
    val case1 = "101"
    val case2 = "0111"
    val answer = question.minimumSteps(case2)
    println(answer)
}