package combinationsum


import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner

@RunWith(BlockJUnit4ClassRunner::class)
class SolutionTest {

    private val solution = Solution()

    private fun run(arr: IntArray, target: Int, expectedResults: List<List<Int>>) {
        val combinationSum = solution.combinationSum(arr, target)

        assert(expectedResults.size == combinationSum.size)
        expectedResults.forEach {
            assert(combinationSum.contains(it)) {
                "combination sum should contain $it"
            }
        }
    }

    @Test
    fun `when all positives and target can be found then expect all combinations found`() {
        run(
            intArrayOf(1, 2, 5),
            5,
            listOf(
                listOf(1, 1, 1, 1, 1),
                listOf(1, 1, 1, 2),
                listOf(1, 2, 2),
                listOf(5)
            )
        )
    }

    @Test
    fun `when only one element and target can Be Found Expect Combination Found`() {
        run(
            intArrayOf(1),
            2,
            listOf(
                listOf(1, 1)
            )
        )
    }

    @Test
    fun `when only one element and target can not be found expect empty`() {
        run(
            intArrayOf(3),
            2,
            emptyList()
        )
    }

    @Test
    fun `when Contains Not Distinct Expect Correct Result`() {
        run(
            intArrayOf(1, 1),
            2,
            listOf(
                listOf(1, 1)
            )
        )
    }

    @Test
    fun `when Contains Negatives And Target Can Be Found Expect Combinations Found`() {
        run(
            intArrayOf(-2, 1, 2),
            2,
            listOf(
                listOf(1, 1),
                listOf(2)
            )
        )
    }

    @Test
    fun `when Combination Can Not Be Found Expect Empty`() {
        run(
            intArrayOf(0, 3, 7),
            2,
            emptyList()
        )
    }

    @Test
    fun `base test`() {
        val combinationSum = solution.combinationSum(
            intArrayOf(2, 3, 4),
            5,
        )
        println(combinationSum)
    }


}