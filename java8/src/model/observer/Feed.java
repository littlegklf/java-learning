package model.observer;

import model.observer.Observer;
import model.observer.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kuanglifang
 * @date 2021/3/2 17:34
 */
public class Feed implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void noticeObservers(String tweet) {
        observers.forEach(o -> o.notice(tweet));
    }
}
