import com.sun.org.apache.bcel.internal.generic.ALOAD;
import lombok.ToString;
import netscape.javascript.JSObject;
import org.junit.Test;
import sun.security.util.ArrayUtil;

import java.awt.font.NumericShaper;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

//「力扣挑战赛」心算项目的挑战比赛中，要求选手从 `N` 张卡牌中选出 `cnt` 张卡牌，若这 `cnt` 张卡牌数字总和为偶数，则选手成绩「有效」且得分为
// `cnt` 张卡牌数字总和。
//给定数组 `cards` 和 `cnt`，其中 `cards[i]` 表示第 `i` 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分
//的卡牌方案，则返回 0。
//
//**示例 1：**
//>输入：`cards = [1,2,8,9], cnt = 3`
//>
//>输出：`18`
//>
//>解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。
//
//**示例 2：**
//>输入：`cards = [3,3,1], cnt = 1`
//>
//>输出：`0`
//>
//>解释：不存在获取有效得分的卡牌方案。
//
//**提示：**
//- `1 <= cnt <= cards.length <= 10^5`
//- `1 <= cards[i] <= 1000`
//
//
// Related Topics 贪心 数组 排序
// 👍 20 👎 0
public class Solution15 {


    @Test
    public void test01(){
        Integer[] cards = {3,5,1,2,4,22,4,2,32};
        int i = maxmiumScore(cards, 3);
        System.out.println("总数为：" + i);
    }

    public int maxmiumScore(Integer[] cards, int cnt) {

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(cards));
        arrayList.sort(Comparator.reverseOrder());
        ArrayList<Integer> even = new ArrayList<>();//偶数集合
        ArrayList<Integer> odd = new ArrayList<>();//奇数集合
        ArrayList<Integer> results = new ArrayList<>();//选出数的集合
        ArrayList<Integer> results2 = new ArrayList<>();//保存最终的数集
        int result = 0;//输出结果

        arrayList.forEach(num -> {
            if (num % 2 == 0)even.add(num);
            else odd.add(num);
        });

        //当原数组中只有1个奇数
        if (odd.size() % 2 != 0) for(int i=0;i < even.size();i++) result += even.get(i);
        //当原数组中原为奇数，且cnt也为奇数时
        if (even.size() == 0 && cnt % 2 ==1)return result;
        //当原数组中有奇数个奇数，且cnt为原数组长度时
        if (odd.size() % 2 == 1 && cnt == arrayList.size())return result;

        //取oddCount个奇数，oddCount为偶数
        for(int oddCount = 0;oddCount <= odd.size();oddCount += 2){
            if (even.size() < cnt - oddCount)continue;//保证even中有足够的偶数供选择
            int o = odd.subList(0, oddCount).stream()
                       .mapToInt(num -> num)
                       .sum();
            int e = even.subList(0, cnt - oddCount).stream()
                        .mapToInt(num -> num)
                        .sum();
            if (result < o+e){
                result = o+e;
            }
        }
        return result;
    }
}
