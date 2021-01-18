package assincrono;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class SingleThreadExecutor {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> testeFuture = executor.submit(new Callable<String>() {
                                                         public String call() {
                                                             return "Teste de execução!!";
                                                         }
                                                     }
        );
        if (testeFuture.isDone()) {
            System.out.println(testeFuture.get());
        }

        List<FutureTask<Boolean>> lFutureTask = getFutureTask();
        for (FutureTask<Boolean> futureTask: lFutureTask) {
            executor.execute(futureTask);
        }
        boolean isFinished = false;
        while (!isFinished){
            final int qtdTask = lFutureTask.size();
            int qtdTaskFinished = 0;
            for (FutureTask<Boolean> futureTask: lFutureTask) {
                if(futureTask.isDone()){
                    qtdTaskFinished++;
                }
            }
            if(qtdTask == qtdTaskFinished){
                isFinished = true;
            }
        }
        System.out.println("Finish Him!!");
    }

    private static List<FutureTask<Boolean>> getFutureTask() {
        List<FutureTask<Boolean>> list = new ArrayList<>();
        final FutureTask<Boolean> booleanFutureTask = new FutureTask<>(new Callable<Boolean>() {
            public Boolean call() {
                System.out.println("Teste de execução 1!!");
                return Boolean.TRUE;
            }
        });
        list.add(booleanFutureTask);
        final FutureTask<Boolean> booleanFutureTask2 = new FutureTask<>(new Callable<Boolean>() {
            public Boolean call() {
                try {
                    Thread.sleep(60000); // sleep for 1 millisecond
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Teste de execução 2!!");
                return Boolean.TRUE;
            }
        });
        list.add(booleanFutureTask2);

        return list;
    }

}
