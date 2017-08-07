package pl.itgolo.plugin.helper.Async;

/**
 * Created by ITGolo on 25.02.2017.
 */
public class TestAsyncHelper {

//    @Test
//    public void test_async_with_wait_helper() throws InterruptedException, ExecutionException, AsyncHelperException {
//        int quantityCallables = 100;
//        SimpleIntegerProperty counter = new SimpleIntegerProperty(0);
//        List<Callable<Object>> callables = new ArrayList<>();
//        for (Integer i = 0; i < quantityCallables; i++) {
//            callables.add(() -> {
//                counter.set(counter.get() + 1);
//                System.out.println(counter.get());
//                return 0;
//            });
//        }
//        List<Object> result = AsyncHelper.asyncMultiWait(callables, 10, "ThreadName", false, Thread.MAX_PRIORITY);
//        Assert.assertEquals(result.size(), quantityCallables);
//    }
//
//    @Test
//    public void test_async_helper() throws AsyncHelperException {
//        AsyncHelper.async(()->{
//            int quantityCallables = 20000;
//            SimpleIntegerProperty counter = new SimpleIntegerProperty(0);
//            List<Callable<Object>> callables = new ArrayList<>();
//            for (Integer i = 0; i < quantityCallables; i++) {
//                callables.add(() -> {
//                    Thread.sleep(10);
//                        AsyncHelper.sync(()->{
//                            counter.set(counter.get() + 1);
//                            return null;
//                        }, counter);
//                        System.out.println(counter.get());
//                        return 0;
//                });
//            }
//            try {
//                List<Object> results = AsyncHelper.asyncMultiWait(callables, 10, "ThreadName", true, Thread.MAX_PRIORITY);
//                System.out.println("Finish async thread.");
//            } catch (AsyncHelperException e) {
//                e.printStackTrace();
//            }
//        }, "AsyncThread", false, 5);
//    }
//
//    @Test
//    public void test_sync_helper() throws InterruptedException, ExecutionException, AsyncHelperException {
//        int quantityCallables = 50;
//        SimpleIntegerProperty counter = new SimpleIntegerProperty(0);
//        List<Callable<Object>> callables = new ArrayList<>();
//        for (Integer i = 0; i < quantityCallables; i++) {
//            callables.add(() -> {
//                return AsyncHelper.sync(() -> {
//                    counter.set(counter.get() + 1);
//                    System.out.println(counter.get());
//                    return 0;
//                }, AsyncHelper.class);
//            });
//        }
//        List<Object> results = AsyncHelper.asyncMultiWait(callables, 10, "ThreadName", false, Thread.MAX_PRIORITY);
//        System.out.println("Finish results.");
//        Assert.assertEquals(results.size(), quantityCallables);
//    }
//
//    @Test
//    public void test_async_one_runnable_helper() {
//System.out.println("Start method");
//        AsyncHelper.async(()->{
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Run method");
//        }, "ThreadName", true, Thread.MAX_PRIORITY);
//        System.out.println("After async.");
//    }

}
