package cn.lgwen.arithmetic;

/**
 * @Author aven.wu
 * @Date 2021/1/6
 * 33. 搜索旋转排序数组
 * （例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
 */
public class RevolveSearch {


    public static void main(String[] args) {
        int vule = new RevolveSearch().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println(vule);
    }


    /*
    取 mid 如果 nums[0] > nums[mid - 1] 表示旋转的是 0 -> mid - 1, mid -> len -1 单调递增。
    然后根据 nums[0] 和 nums[len - 1] 来确定target 所在的分段。
    重复上面操作。直至
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                // 表示 左侧是单调递增，旋转点在 mid的右侧
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int start, int end, int target) {
        if (start == end) {
            return nums[start] == target ? start : -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return mid;

        // 判断当前面是否递增范围
        if (nums[0] <= nums[mid]) {
            if (nums[0] <= target && target < nums[mid]) {
                return search(nums, start, mid - 1, target);
            } else {
                return search(nums, mid + 1, end, target);
            }
        } else {
            if (nums[mid] < target && target <= nums[nums.length - 1]) {
                return search(nums, start, mid + 1, target);
            } else {
                return search(nums, mid - 1, end, target);
            }
        }

    }
}
