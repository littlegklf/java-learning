package stream;

import model.Trader;
import model.Transaction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * @author kuanglifang
 * @date 2021/3/2 10:36
 */
public class TraderExercise {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        /**
         * (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
         * (2) 交易员都在哪些不同的城市工作过？
         * (3) 查找所有来自于剑桥的交易员，并按姓名排序。
         * (4) 返回所有交易员的姓名字符串，按字母顺序排序。
         * (5) 有没有交易员是在米兰工作的？
         * (6) 打印生活在剑桥的交易员的所有交易额。
         * (7) 所有交易中，最高的交易额是多少？
         * (8) 找到交易额最小的交易。
         */

        System.out.println("(1) 2011年发生的所有交易，并按交易额排序");
        transactions.stream().filter(transaction -> 2011 == transaction.getYear())
                .sorted(comparing(Transaction::getValue))
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("(2) 交易员都在哪些不同的城市工作过");
        transactions.stream().map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("(3) 查找所有来自于剑桥的交易员，并按姓名排序");
        transactions.stream().map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity())).sorted(comparing(Trader::getName))
                .distinct()
                .forEach(System.out::println);

        System.out.println("(4) 返回所有交易员的姓名字符串，按字母顺序排序");
        String nameStr = transactions.stream().map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());
        System.out.println(nameStr);

        System.out.println("(5) 有没有交易员是在米兰工作的");
        boolean b = transactions.stream().anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));
        System.out.println(b);

        System.out.println("(6) 打印生活在剑桥的交易员的所有交易额");
        transactions.stream().filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        System.out.println("(7) 所有交易中，最高的交易额是多少");
        //这个reduce暗含装箱成本
        Optional<Integer> max = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        max.ifPresent((t) -> System.out.println("max:" + t));

        Optional<Transaction> max2 = transactions.stream().collect(maxBy(comparing(Transaction::getValue)));
        max2.ifPresent((t) -> System.out.println("max2:" + t.getValue()));

        Optional<Transaction> max3 = transactions.stream().max(comparing(Transaction::getValue));
        max3.ifPresent((t) -> System.out.println("max3:" + t.getValue()));

        System.out.println("(8) 找到交易额最小的交易");
        Optional<Transaction> min = transactions.stream().min(comparing(Transaction::getValue));
        min.ifPresent(System.out::println);

        System.out.println("(9) 计算所有交易的总金额");
        Integer sum = transactions.stream().collect(summingInt(Transaction::getValue));
        System.out.println(sum);
    }
}
