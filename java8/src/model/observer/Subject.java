package model.observer;

import model.observer.Observer;

/**
 * @author kuanglifang
 * @date 2021/3/2 16:36
 */
public interface Subject {
    /**
     * 加入观察者
     * @param o
     */
    void registerObserver(Observer o);

    /**
     * 通知观察者
     * @param tweet
     */
    void noticeObservers(String tweet);
}
