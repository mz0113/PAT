/**
 * 0-1背包问题
 * 本质就是构建出那个表格,容量从0-最大，物品数量从0到全部的那个表格。递归一棵二叉树来遍历每一种情况
 *
 * https://www.bilibili.com/video/BV1jt411m7Rc?from=search&seid=10176631325411617682
 */
public class Main {
    /**
     * 递归公式 一棵二叉树，每一步都选择拿或不拿产生分叉，最终计算叶子
     *
     *  B(K,C) = B(K-1,C) 如果第k件太重
     *  B(K,C) = B(K-1,C-Wk) + Vk 拿第k件
     *  B(K,C) = B(K-1,C) 不拿第k件
     *
     */

    //背包容量最大是W-1,因为表格横轴包含0,实则表示21个列
    static int W = 21;
    //物品数量最大是N-1,因为表格纵轴包含0，实则表示6行
    static int N = 6;
    //物品重量
    static int[] w = {0,2,3,4,5,9};
    //物品价值
    static int[] v = {0,3,4,5,8,10};
    //最后要生成的0-1背包表格。共计N*M大小,每个元素表示当前物品数量和背包容量限制下可以拿到的最大价值
    static int[][] B = new int[N][W];

    /**
     * 创建0-1背包的表格,横轴表示当前背包容量大小，纵轴表示可以拿的物品
     * B[0][0] = 0,因为是int数组，其实没必要设置递归结束的出口
     */
    static void knapsack(){
        //k 当前物品索引
        //c 当前背包容量
        for(int k=1 ; k<N ; k++){
            for(int c=1 ; c<W ; c++){
                if(w[k]>c){
                    //第k件物品重量大于当前背包容量 不拿
                    B[k][c] = B[k-1][c];
                }else{
                    //拿第k件
                    int value1 = B[k-1][c-w[k]] + v[k];
                    //不拿第k件
                    int value2 = B[k-1][c];
                    if(value1>value2){
                        B[k][c] = value1;
                    }else{
                        B[k][c] = value2;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // write your code here
        knapsack();
        System.out.println(B[5][20]);
    }
}
