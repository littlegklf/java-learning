package lambda;

import model.factory.Bond;
import model.factory.Loan;
import model.factory.Product;
import model.factory.Stock;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author kuanglifang
 * @date 2021/3/3 11:06
 */
public class FactoryLambdaExercise {
    final static Map<String, Supplier<Product>> map = new HashMap<>();
    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }
    public static Product createProduct(String name) {
        Supplier<Product> p = map.get(name);
        if (p != null) {
            return p.get();
        }
        throw new IllegalArgumentException("No such product" + name);
    }
    public static void main(String[] args) {
        Product loan = createProduct("loan");
        System.out.println(loan);
    }
}
