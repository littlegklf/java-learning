package model.defaultMethod;

/**
 * @author kuanglifang
 * @date 2021/3/3 17:13
 */
public interface Moveable {
    int getX();
    int getY();
    void setX(int x);
    void setY(int y);
    default void moveHorizontally(int distance){
        setX(getX() + distance);
    }
    default void moveVertically(int distance){
        setY(getY() + distance);
    }
}
