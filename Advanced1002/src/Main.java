import java.text.DecimalFormat;
import java.util.*;
/**
 * 5 2 3.4 3 3.3 1 2.8 5 -3.2 5 3.2
 * 5 2 3.4 3 3.3 1 2.8 5 3.2 5 -3.2
 *
 * 5 (2 3.4) (3 3.3) (1 2.8) (5 -3.2) (6 3.2)
 * 5 (2 3.4) (3 3.3) (1 2.8) (5 3.2) (6 -3.2)
 *
 * 自己的错误还是在于输入，自己把系数为0的项也输出出来了。这是不可以的。改进后也可以对系数相同的做处理了
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        HashMap<Integer,Double> map1 = new HashMap(line1.charAt(0));
        HashMap<Integer,Double> map2 = new HashMap(line2.charAt(0));
        TreeSet<Integer> exponents = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(Integer.valueOf(o1.toString())<Integer.valueOf(o2.toString())){
                    return 1;
                }else if(Integer.valueOf(o1.toString())==Integer.valueOf(o2.toString())){
                    return 0;
                }else{
                    return -1;
                }
            }
        });//保存下来所有的指数，且从大到小排列好
        String[] sp1 = line1.split(" ");
        String[] sp2 = line2.split(" ");
        for (int i = 1; i < sp1.length; i+=2) {
            Integer ex = Integer.parseInt(String.valueOf(sp1[i]));
            map1.put(ex
                    , Double.parseDouble(map1.get(ex)==null?"0":map1.get(ex).toString())+Double.parseDouble(String.valueOf(sp1[i+1]))//如果指数已经相同了，则直接相加系数
            );
            exponents.add(Integer.parseInt(String.valueOf(sp1[i])));
        }
        for (int i = 1; i < sp2.length; i+=2) {
            Integer ex = Integer.parseInt(String.valueOf(sp2[i]));
            map2.put(ex
                    , Double.parseDouble(map2.get(ex)==null?"0":map2.get(ex).toString())+Double.parseDouble(String.valueOf(sp2[i+1]))//如果指数已经相同了，则直接相加系数
            );
            exponents.add(Integer.parseInt(String.valueOf(sp2[i])));//如果指数已经相同了，则直接相加系数
        }
        StringBuffer resultBuffer = new StringBuffer();
        Integer coefficients = 0;//非零系数项的个数
        DecimalFormat format = new DecimalFormat("0.0");
        for (Integer exponent : exponents) {
            //从第一个指数(最大的)开始计算
            Double d1 = map1.get(exponent)==null?0d:map1.get(exponent);
            Double d2 = map2.get(exponent)==null?0d:map2.get(exponent);
            //d1 d2 不会同时为Null
            Double t = d1+d2;
            t = Double.valueOf(format.format(t));
            //注意系数项为0，则K不能增加
            if(t!=0){
                coefficients++;
                resultBuffer.append(" "+exponent + " " +t);
            }
        }
        System.out.print(coefficients+resultBuffer.toString());
    }
}
