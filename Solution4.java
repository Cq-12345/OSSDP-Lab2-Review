import java.util.Arrays;

/**
 * @description:
 *
 * 给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值 。如果数组元素个数小于 2，则返回 0 。
 *
 * 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 *
 * 输入: nums = [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 *
 */
import java.util.Arrays;

/**
 * @description:
 *
 * 给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值 。如果数组元素个数小于 2，则返回 0 。
 *
 * 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
 *
 */
class Solution4 {

    // 优化说明：
    // 去除冗余代码：保留了使用前缀和方法的桶计数，只保留了必要的逻辑，减少了重复计算。
    // 增加错误处理：在方法开头添加了对输入数组的合法性检查，如果输入为 null 则抛出 IllegalArgumentException。
    // 简化了桶排序的流程：添加了必要的注释，清晰地说明了每一步的目的，便于后续维护。
    public int maximumGap(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("输入数组不能为空");
        }

        int n = nums.length;
        if (n < 2) {
            return 0;
        }

        // 基数排序实现
        int maxVal = Arrays.stream(nums).max().orElse(0);
        int[] buf = new int[n];
        int exp = 1; // 初始为个位数

        while (maxVal / exp > 0) {
            int[] cnt = new int[10];

            // 统计各个桶的计数
            for (int num : nums) {
                int digit = (num / exp) % 10;
                cnt[digit]++;
            }

            // 转换为前缀和，确定每个桶的边界
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }

            // 按当前位数排序
            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / exp) % 10;
                buf[--cnt[digit]] = nums[i];
            }

            System.arraycopy(buf, 0, nums, 0, n); // 直接拷贝排序结果回原数组

            exp *= 10; // 处理下一个位数
        }

        // 计算相邻元素最大差值
        int ret = 0;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, nums[i] - nums[i - 1]);
        }
        return ret;
    }
}
