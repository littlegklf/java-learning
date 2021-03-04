package model.ProcessingObject;

import model.ProcessingObject.ProcessingObject;

/**
 * @author kuanglifang
 * @date 2021/3/3 10:54
 */
public class SpellCheckerProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
