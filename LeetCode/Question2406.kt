package leetcode

import java.util.*

class Question2406 {
    fun minGroups(intervals: Array<IntArray>): Int {
        intervals.sortWith(compareBy { it[0] })
        val groups = PriorityQueue<Int>()
        groups.add(intervals[0][1])
        for (i in 1 until intervals.size){
            if (groups.peek() < intervals[i][0]) {
                groups.poll()
            }
            groups.add(intervals[i][1])
        }
        return groups.size
    }
}

fun main(){
    val question2406 = Question2406()
    val case1 = arrayOf(
        intArrayOf(5, 10),
        intArrayOf(6, 8),
        intArrayOf(1, 5),
        intArrayOf(2, 3),
        intArrayOf(1, 10)
    )
    val case2 = arrayOf(
        intArrayOf(441459, 446342), //2
        intArrayOf(801308, 840640), //6
        intArrayOf(871890, 963447), //8
        intArrayOf(228525, 336985), //1
        intArrayOf(807945, 946787), //7
        intArrayOf(479815, 507766), //3
        intArrayOf(693292, 944029), //4
        intArrayOf(751962, 821744)  //5
    )
    val case3 = arrayOf(
        intArrayOf(351436, 933571),
        intArrayOf(667214, 975379),
        intArrayOf(782454, 919174),
        intArrayOf(231661, 764081),
        intArrayOf(848495, 902497),
        intArrayOf(332817, 520328),
        intArrayOf(740795, 762394),
        intArrayOf(665739, 726786),
        intArrayOf(546865, 686588),
        intArrayOf(360501, 846864)
    )

    val answer = question2406.minGroups(case2)
    print("answer : $answer")
}