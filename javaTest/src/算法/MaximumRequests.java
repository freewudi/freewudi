package 算法;
public class MaximumRequests {
    int[] delta;
    int ans = 0, cnt = 0, zero, n;

    public int maximumRequests(int n, int[][] requests) {
        delta = new int[n];
        zero = n;
        this.n = n;
        dfs(requests, 0);
        return ans;
    }

    public void dfs(int[][] requests, int pos) {
        if (pos == requests.length) {
            if (zero == n) {
                ans = Math.max(ans, cnt);
            }
            return;
        }

        // 不选 requests[pos]
        dfs(requests, pos + 1);

        // 选 requests[pos]
        int z = zero;
        ++cnt;
        int[] r = requests[pos];
        int x = r[0], y = r[1];
        zero -= delta[x] == 0 ? 1 : 0;
        --delta[x];
        zero += delta[x] == 0 ? 1 : 0;
        zero -= delta[y] == 0 ? 1 : 0;
        ++delta[y];
        zero += delta[y] == 0 ? 1 : 0;
        dfs(requests, pos + 1);
        --delta[y];
        ++delta[x];
        --cnt;
        zero = z;
    }

    public static void main(String[] args) {
        int[][] requests = new int[][]{{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}};
        int n = 5;
        MaximumRequests maximumRequests = new MaximumRequests();
        System.out.println(maximumRequests.maximumRequests(n, requests));
    }

//    public int maximumRequests(int n, int[][] requests) {
//        // 获取提出更换请求的员工个数
//        int m = requests.length;
//        // max 代表的是员工的状态 -----> 员工请求的请求可以被接受 / 不接受 每个员工有两种状态 那么就有 2^m 次种状态结果
//        int maxStatus = 1 << m, res = 0;
//        // 记录是否成功接受请求的数组
//        int[] netChangeArr = new int[n];
//
//        // 枚举所有状态，二进制中 1 的个数为当前状态的请求个数
//        for (int i = 0; i < maxStatus; i++) {
//            int[] tmp = new int[n];
//            int state = i;
//            // 用于记录当前的员工请求下标
//            int idx = 0;
//            // 用于记录当前状态下的接受的请求个数
//            int cnt = 0;
//            // 用于获取当前状态中二进制数字中1的个数
//            while (state > 0) {
//                // 判断最后一位是否为1
//                int isAccept = state & 1;
//                // 如果为 1 则说明了当前状态被接受了 需要记录住房情况
//                if (isAccept == 1) {
//                    // 获取需要从哪里 搬到 哪里的位置信息
//                    int from = requests[idx][0];
//                    int to = requests[idx][1];
//                    // 记录住房净变化
//                    tmp[from]--;
//                    tmp[to]++;
//                    cnt++;
//                }
//                // 获取前一个员工的状态请求情况
//                state >>= 1;
//                idx++;
//            }
//            // 根据我们上面完成得到记录住房变化 需要满足每栋楼员工净变化为 0
//            // 滚动获取最大值
//            if (Arrays.equals(tmp, netChangeArr)) {
//                res = Math.max(res,cnt);
//            }
//        }
//        return res;
//    }
}
