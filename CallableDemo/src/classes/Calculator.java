package classes;

import java.util.concurrent.Callable;

public class Calculator implements Callable<Integer> {
    int num;

    public Calculator(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= num; i++) {
            sum += i;
        }
        return sum;
    }
}
