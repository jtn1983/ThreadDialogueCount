import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<MyCallable> tasks = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            MyCallable myCallable = new MyCallable("MyThread" + (i + 1));
            tasks.add(myCallable);
        }

        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        final List<Future<String>> task = threadPool.invokeAll(tasks);

//        final String taskAny = threadPool.invokeAny(tasks);
//        System.out.println(taskAny);

        for (int i = 0; i < task.size(); i++) {
            Future<String> future = task.get(i);
            System.out.println(future.get());
        }

        threadPool.shutdown();
    }
}
