class Question2044 {
    var count = 0;
    fun countMaxOrSubsets(nums: IntArray): Int {
        var maximun = 0
        for(i in nums) maximun = maximun or i

        for (s in 1 .. nums.size){
            combination(nums, maximun, 0, 0, 0, s)
        }

        return count
    }

    fun combination(nums: IntArray, maxValue: Int, value: Int, start: Int, nowCount: Int, cNum: Int){
        if (nowCount == cNum){
            if (value == maxValue) count++
            return
        }
        for (i in start..nums.size-cNum+nowCount){
            val v = value or nums[i]
            combination(nums, maxValue, v, i + 1, nowCount+1, cNum)
        }
    }
}

fun main() {
    val question = Question2044()
    val case1 = intArrayOf(2, 2, 2)
    val case2 = intArrayOf(3, 1)
    val case3 = intArrayOf(3,2,1,5)
    val answer = question.countMaxOrSubsets(case1)
    println(answer)
}