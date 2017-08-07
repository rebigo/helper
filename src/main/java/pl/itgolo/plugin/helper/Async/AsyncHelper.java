package pl.itgolo.plugin.helper.Async;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import pl.itgolo.plugin.helper.Async.Exceptions.AsyncHelperException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by ITGolo on 01.03.2017.
 */
public class AsyncHelper {

    /**
     * Run asynchronous task
     *
     * @param task       tas
     * @param threadName thread name
     * @param daemon     daemon
     * @param priority   priority thread
     *                   @return executor service
     */
    public static ExecutorService async(Runnable task, String threadName, Boolean daemon, Integer priority) {
        String threadNameFormat = threadName + "-%d";
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat(threadNameFormat)
                .setDaemon(daemon)
                .setPriority(priority)
                .build();

        ExecutorService executorService = Executors.newFixedThreadPool(1, threadFactory);
        executorService.execute(() -> {
            task.run();
        });
        executorService.shutdown();
        return executorService;
    }

    /**
     * Run asynchronous callables and wait for results from futures
     *
     * @param callables  callables to run
     * @param threads    quantity threads max
     * @param threadName thread name
     * @param daemon     daemon
     * @param priority   priority threads
     * @return list with objects return from futures of callables
     * @throws AsyncHelperException error inside callable or not allowed operation of thread
     */
    public static List<Object> asyncMultiWait(List<Callable<Object>> callables, Integer threads, String threadName, Boolean daemon, Integer priority) throws AsyncHelperException {
        String threadNameFormat = threadName + "-%d";
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat(threadNameFormat)
                .setDaemon(daemon)
                .setPriority(priority)
                .build();

        ExecutorService executorService = Executors.newFixedThreadPool(threads, threadFactory);
        List<Future<Object>> futures = new ArrayList<>();
        for (Callable<Object> callable : callables) {
            Future<Object> future = executorService.submit(callable);
            futures.add(future);
        }
        List<Object> resultFutures = new ArrayList<>();
        try {
            for (Future<Object> future : futures) {
                resultFutures.add(future.get());
            }
        } catch (Throwable t) {
            throw new AsyncHelperException("Error inside callable or not allowed operation in thread: " + Thread.currentThread().getName() + ".", t);
        }
        executorService.shutdown();
        return resultFutures;
    }

    /**
     * Call synchronous to callable
     *
     * @param callable callable
     * @param lock     lock object
     * @return result callable
     * @throws AsyncHelperException error inside callable for call method
     */
    public static Object sync(Callable<Object> callable, Object lock) throws AsyncHelperException {
        synchronized (lock) {
            try {
                return callable.call();
            } catch (Throwable t) {
                throw new AsyncHelperException("Error inside callable for call method in thread: " + Thread.currentThread().getName() + ".", t);
            }
        }
    }
}
