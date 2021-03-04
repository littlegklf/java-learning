package model.defaultMethod;

/**
 * @author kuanglifang
 * @date 2021/3/3 17:12
 */
public interface Rotatable {
    void setRotationAngle(int angleInDegrees);
    int getRotationAngle();
    default void rotateBy(int angleInDegrees){
        setRotationAngle((getRotationAngle () + angleInDegrees) % 360);
    }
}
