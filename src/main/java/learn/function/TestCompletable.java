package learn.function;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TestCompletable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Result> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            Result result = new Result();
            try {
                System.out.println(Thread.currentThread().getName() + " start");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " over");
            } catch (InterruptedException e) {
                ;
            }
            result.setSuccess(true);
            completableFuture.complete(result);
        }).start();

        CompletableFuture<Void> completableFuture1 = completableFuture.thenRun(() -> {
            System.out.println(Thread.currentThread().getName() + " completed, then run other task");
        });

        CompletableFuture<Void> completableFuture2 = completableFuture.thenAccept(result -> {
            System.out.println(Thread.currentThread().getName() + " consume " + result);
        });

        CompletableFuture<ApplyResult> applyResultCompletableFuture = completableFuture.thenApply(result -> {
            ApplyResult applyResult = new ApplyResult();
            applyResult.setId("123");
            applyResult.setResult(result);
            System.out.println(Thread.currentThread().getName() + " apply " + result);
            return applyResult;
        });

        CompletableFuture<CombineResult> combineResultCompletableFuture =
            completableFuture.thenCombine(applyResultCompletableFuture, (result, applyResult) -> {
                CombineResult combineResult = new CombineResult();
                combineResult.setApplyResult(applyResult);
                combineResult.setResult(result);
                System.out.println(Thread.currentThread().getName() + " combine " + result + " with " + applyResult);
                return combineResult;
            });

        CompletableFuture<ComposeResult> composeResultCompletableFuture = completableFuture.thenCompose(result -> {
            ComposeResult composeResult = new ComposeResult();
            composeResult.setResult(result);

            CompletableFuture<ComposeResult> ret = new CompletableFuture<>();
//            ret.complete(composeResult);
            System.out.println(Thread.currentThread().getName() + " compose " + result);
            return ret;
        });

        System.out.println("main over");

        System.out.println(completableFuture1.isDone());
        System.out.println(completableFuture2.isDone());
        System.out.println(applyResultCompletableFuture.isDone());
        System.out.println(combineResultCompletableFuture.isDone());
        System.out.println(composeResultCompletableFuture.isDone());

        System.out.println("-------------sleep 5s----------------");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("-------------check----------------");
        System.out.println(completableFuture1.isDone());
        System.out.println(completableFuture2.isDone());
        System.out.println(applyResultCompletableFuture.isDone());
        System.out.println(combineResultCompletableFuture.isDone());
        System.out.println(composeResultCompletableFuture.isDone());

    }
}
