package lambda;

import model.observer.Feed;

/**
 * @author kuanglifang
 * @date 2021/2/26 11:51
 */
public class ObserverLambdaExercise {
    public static void main(String[] args) {
        Feed feed = new Feed();
        feed.registerObserver((String tweet) -> {
            if(tweet != null && tweet.contains("money")){
                System.out.println("Breaking news in NY! " + tweet);
            }
        });
        feed.registerObserver((String tweet) -> {
            if(tweet != null && tweet.contains("queen")){
                System.out.println("Yet another news in London... " + tweet);
            }
        });
        feed.noticeObservers("The queen said her favourite book is Java 8 in Action!");
    }
}
