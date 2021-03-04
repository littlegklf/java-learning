package lambda;

import model.defaultMethod.Monster;

/**
 * @author kuanglifang
 * @date 2021/3/3 17:10
 */
public class DefaultMethod {
    public static void main(String[] args) {
        Monster m = new Monster();
        m.rotateBy(180);
        m.moveVertically(10);
    }
}
