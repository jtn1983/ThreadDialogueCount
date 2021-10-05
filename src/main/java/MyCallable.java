import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    private final String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        int count = 0;
        while (count < 5) {
            Thread.sleep(2500);
            System.out.println("Hello, I'm " + name);
            count++;
        }
        return name + " print message " + count + " times";
    }

}
