package model.ProcessingObject;

/**
 * @author kuanglifang
 * @date 2021/3/3 10:52
 */
public class HeaderTextProcessing extends ProcessingObject<String> {
    @Override
    public String handleWork(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }
}
