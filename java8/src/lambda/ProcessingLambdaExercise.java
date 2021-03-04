package lambda;

import model.ProcessingObject.HeaderTextProcessing;
import model.ProcessingObject.ProcessingObject;
import model.ProcessingObject.SpellCheckerProcessing;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author kuanglifang
 * @date 2021/3/3 10:03
 */
public class ProcessingLambdaExercise {
    public static void main(String[] args) {
        /**
         * lambda之前的写法
         */
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);
        String result = p1.handle("Aren't labdas really sexy?!!");
        System.out.println(result);

        /**
         * 用lambda表达式
         */
        UnaryOperator<String> headerProcessing =
                (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing =
                (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline =
                headerProcessing.andThen(spellCheckerProcessing);
        String result2 = pipeline.apply("Aren't labdas really sexy?!!");
        System.out.println(result2);
    }
}
