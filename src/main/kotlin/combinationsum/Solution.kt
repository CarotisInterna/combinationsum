package combinationsum


import java.util.*
import kotlin.collections.ArrayList


class Solution {

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        Arrays.sort(candidates)
        val map = HashMap<Int, ArrayList<List<Int>>>()
        map[0] = ArrayList()
        map[0]?.add(ArrayList())
        var sum = ArrayList<List<Int>>()
        // идем от 1 до цели
        for (i in 1..target) {
            println("i = $i")
            sum = ArrayList()
            // проходим по всем кандидатам
            for (option in candidates) {
                println("option = $option")
                // если разница между текущим и кандидатом >= 0
                println("($i - $option) >= 0 is ${i - option >= 0}")
                if (i - option >= 0) {
                    val temp = map[i - option]
                    println("temp is $temp")
                    if (temp != null) {
                        for (t in temp) {
                            println("t = $t")
                            val t2: MutableList<Int> = ArrayList()
                            t2.addAll(t)
                            t2.add(option)
                            t2.sort()
                            if (!sum.contains(t2)) {
                                sum.add(t2)
                                println("sum = $sum")
                            }
                        }
                    }
                } else {
                    println("break the options loop")
                    break
                }
            }
            map[i] = sum
            println("map[$i] = $sum")
        }

        return sum
    }


}