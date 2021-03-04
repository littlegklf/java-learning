package model.observer;

/**
 * @author kuanglifang
 * @date 2021/3/2 16:35
 */
public interface Observer {
    /**
     * 观察者接收到通知后 作出行为
     * @param tweet
     */
    void notice(String tweet);
}
