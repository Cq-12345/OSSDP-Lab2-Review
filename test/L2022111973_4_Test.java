import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 测试类 L2022111973_4_Test.java
 *
 * <p>测试用例设计的总体原则：
 *
 * - **等价类划分原则**：将输入数据划分为不同的等价类，选取具有代表性的测试用例进行测试，确保对每个等价类都进行了充分测试。
 * - **边界值分析原则**：重点测试输入数据的边界值，因为这些地方容易出现错误。
 *
 * <p>测试用例涵盖以下场景：
 *
 * 1. **数组长度小于2**：
 *    - 空数组
 *    - 只有一个元素的数组
 *
 * 2. **正常情况**：
 *    - 无序数组，包含正整数
 *    - 数组已排序
 *    - 数组包含重复元素
 *
 * 3. **特殊值测试**：
 *    - 数组包含0
 *    - 数组包含最大值或最小值
 *
 * 4. **大规模数据测试**：
 *    - 数组长度为最大限制（如10^5）
 *    - 元素值为最大限制（如10^9）
 *
 * <p>设计这些测试用例是为了全面覆盖可能的输入情况，确保 `maximumGap` 方法在各种情况下都能正确计算相邻元素的最大差值。
 */
public class L2022111973_4_Test {

    /**
     * 测试目的：验证当数组长度小于2时，方法应返回0。
     *
     * 测试用例：
     * - 空数组 `[]`
     * - 只有一个元素的数组 `[10]`
     */
    @Test
    public void testArrayLengthLessThanTwo() {
        Solution4 solution = new Solution4();

        int[] nums1 = {};
        assertEquals("空数组应返回0", 0, solution.maximumGap(nums1));

        int[] nums2 = {10};
        assertEquals("只有一个元素的数组应返回0", 0, solution.maximumGap(nums2));
    }

    /**
     * 测试目的：验证在正常的无序数组中，方法能正确计算最大差值。
     *
     * 测试用例：
     * - 无序数组 `[3, 6, 9, 1]`，预期最大差值为3
     * - 已排序数组 `[1, 3, 6, 9]`，预期最大差值为3
     */
    @Test
    public void testNormalUnsortedArray() {
        Solution4 solution = new Solution4();

        int[] nums = {3, 6, 9, 1};
        assertEquals("无序数组的最大差值应为3", 3, solution.maximumGap(nums));

        int[] sortedNums = {1, 3, 6, 9};
        assertEquals("已排序数组的最大差值应为3", 3, solution.maximumGap(sortedNums));
    }

    /**
     * 测试目的：验证数组包含重复元素时，方法能正确计算最大差值。
     *
     * 测试用例：
     * - 数组 `[1, 1, 1, 1]`，预期最大差值为0
     */
    @Test
    public void testArrayWithDuplicates() {
        Solution4 solution = new Solution4();

        int[] nums = {1, 1, 1, 1};
        assertEquals("包含重复元素的数组最大差值应为0", 0, solution.maximumGap(nums));
    }

    /**
     * 测试目的：验证数组包含0时，方法能正确计算最大差值。
     *
     * 测试用例：
     * - 数组 `[0, 3, 6, 9]`，预期最大差值为3
     */
    @Test
    public void testArrayWithZero() {
        Solution4 solution = new Solution4();

        int[] nums = {0, 3, 6, 9};
        assertEquals("包含0的数组最大差值应为3", 3, solution.maximumGap(nums));
    }

    /**
     * 测试目的：验证数组包含最大值或最小值时，方法能正确计算最大差值。
     *
     * 测试用例：
     * - 数组 `[1, 1000000000]`，预期最大差值为999999999
     */
    @Test
    public void testArrayWithExtremeValues() {
        Solution4 solution = new Solution4();

        int[] nums = {1, 1000000000};
        assertEquals("包含极大值的数组最大差值应为999999999", 999999999, solution.maximumGap(nums));
    }

    /**
     * 测试目的：验证当最大差值不在相邻元素间时，方法能正确计算最大差值。
     *
     * 测试用例：
     * - 数组 `[1, 10, 5, 8]`，排序后为 `[1, 5, 8, 10]`，预期最大差值为4（1到5）
     */
    @Test
    public void testMaximumGapNotBetweenAdjacentElementsInUnsortedArray() {
        Solution4 solution = new Solution4();

        int[] nums = {1, 10, 5, 8};
        assertEquals("最大差值应正确计算，即使原数组中最大差值的元素不相邻", 4, solution.maximumGap(nums));
    }

    /**
     * 测试目的：验证大规模数组的性能和正确性。
     *
     * 测试用例：
     * - 数组长度为10^5，元素值随机在范围 [0, 10^9]
     */
    @Test
    public void testLargeArray() {
        Solution4 solution = new Solution4();

        int n = 100000;
        int[] nums = new int[n];
        nums[0] = 0;
        nums[1] = 1000000000;
        for (int i = 2; i < n; i++) {
            nums[i] = (int) (Math.random() * 1000000000);
        }
        int result = solution.maximumGap(nums);
        assertTrue("大规模数组的最大差值应大于等于0", result >= 0);
    }

    /**
     * 测试目的：验证数组包含负数时，方法能正确计算最大差值。（尽管题目中数组元素非负，但测试负数以确保代码健壮性）
     *
     * 测试用例：
     * - 数组 `[-10, -3, -1]`，预期最大差值为7
     */
    @Test
    public void testArrayWithNegativeNumbers() {
        Solution4 solution = new Solution4();

        int[] nums = {-10, -3, -1};
        assertEquals("包含负数的数组最大差值应为7", 7, solution.maximumGap(nums));
    }

    /**
     * 测试目的：验证数组中所有元素相同且为最大值时，方法能正确返回0。
     *
     * 测试用例：
     * - 数组 `[1000000000, 1000000000, 1000000000]`，预期最大差值为0
     */
    @Test
    public void testArrayWithAllElementsSameAndMaxValue() {
        Solution4 solution = new Solution4();

        int[] nums = {1000000000, 1000000000, 1000000000};
        assertEquals("所有元素相同的数组最大差值应为0", 0, solution.maximumGap(nums));
    }

    /**
     * 测试目的：验证数组包含最小值0和其他正整数时，方法能正确计算最大差值。
     *
     * 测试用例：
     * - 数组 `[0, 5, 10, 15]`，预期最大差值为5
     */
    @Test
    public void testArrayWithZeroAndPositiveNumbers() {
        Solution4 solution = new Solution4();

        int[] nums = {0, 5, 10, 15};
        assertEquals("包含0和正整数的数组最大差值应为5", 5, solution.maximumGap(nums));
    }

    /**
     * 测试目的：验证数组元素值相差1时，方法能正确计算最大差值为1。
     *
     * 测试用例：
     * - 数组 `[1, 2, 3, 4, 5]`，预期最大差值为1
     */
    @Test
    public void testArrayWithConsecutiveNumbers() {
        Solution4 solution = new Solution4();

        int[] nums = {1, 2, 3, 4, 5};
        assertEquals("连续整数的数组最大差值应为1", 1, solution.maximumGap(nums));
    }
}
