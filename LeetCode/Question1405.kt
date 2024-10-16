import java.util.*

class Question1405 {
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val pq = PriorityQueue<Pair<Char, Int>>(compareByDescending { it.second })
        val str = StringBuilder()
        if(a > 0) pq.add(Pair('a', a))
        if(b > 0) pq.add(Pair('b', b))
        if(c > 0) pq.add(Pair('c', c))

        while (pq.isNotEmpty()){
            val (word1, count1) = pq.poll()
            if(str.length >=2 && str[str.length-1] == word1 && str[str.length-2] == word1){
                if (pq.isEmpty()) break

                val (word2, count2) = pq.poll()
                str.append(word2)

                pq.add(Pair(word1, count1))
                if(count2 > 1) pq.add(Pair(word2, count2-1))
            }else{
                str.append(word1)
                if (count1>1) pq.add(Pair(word1, count1-1))
            }
        }

        return str.toString()
    }
}

fun main(){
    val question = Question1405()
    val case1 = arrayOf(1, 1, 7)
    val case2 = arrayOf(7, 1, 0)
    val case3 = arrayOf(4, 42, 7)
    val answer = question.longestDiverseString(case3[0], case3[1], case3[2])
    println(answer)
}