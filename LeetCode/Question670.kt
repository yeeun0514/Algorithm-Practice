import java.util.PriorityQueue

class Question670 {
    fun maximumSwap(num: Int): Int {
        val pq = PriorityQueue<Pair<Int, Int>>{ a, b ->
            if (b.second == a.second) {
                b.first - a.first
            } else {
                b.second - a.second
            }
        }
        val arr = arrayOfNulls<Int>(num.toString().length)
        var number = num
        var numArrIndex = num.toString().length -1
        var answer = ""

        while(numArrIndex>=0){
            val n = number%10
            arr[numArrIndex] = n
            pq.add(Pair(numArrIndex, n))
            number /= 10
            numArrIndex--
        }
        numArrIndex = 0

        while (pq.isNotEmpty()){
            val n = pq.poll()
            if (arr[numArrIndex]!! < n.second){
                val tmp = arr[numArrIndex]
                arr[numArrIndex] = n.second
                arr[n.first] = tmp
                break;
            }else if(arr[numArrIndex] == n.second && numArrIndex != n.first){
                pq.poll()
                pq.add(n)
            }
            numArrIndex++
        }

        for (i in arr.indices){
            answer+=arr[i].toString()
        }

        return answer.toInt()
    }
}

fun main(){
    val question = Question670()
    val case1 = 2736
    val case2 = 9973
    val case3 = 99088
    val case4 = 98368
    val answer = question.maximumSwap(case4)
    println(answer)
}