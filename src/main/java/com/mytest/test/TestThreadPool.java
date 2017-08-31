package com.mytest.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by itconsultant.ind@gmail.com on 31-Aug-17.
 */
public class TestThreadPool {

    Map<String, ExecutorService> tpTable = new ConcurrentHashMap<String, ExecutorService>();

    ExecutorService tp1 = Executors.newSingleThreadExecutor();
    ExecutorService tp2 = Executors.newSingleThreadExecutor();
    ExecutorService tp3 = Executors.newSingleThreadExecutor();
    ExecutorService tp4 = Executors.newSingleThreadExecutor();
    ExecutorService tp5 = Executors.newSingleThreadExecutor();
    
    public TestThreadPool(){
        tpTable.put("symbol1", tp1);
        tpTable.put("symbol2", tp2);
        tpTable.put("symbol3", tp3);
        tpTable.put("symbol4", tp4);
        tpTable.put("symbol5", tp5);
    }


    public static void main(String args[]) {

        TestThreadPool testThreadPool = new TestThreadPool();

        Map<String, ExecutorService> cacheTPTable = new ConcurrentHashMap<String, ExecutorService>();


        MyEvent event1 = new MyEvent("symbol1");
        MyEvent event2 = new MyEvent("symbol2");
        MyEvent event3 = new MyEvent("symbol3");
        MyEvent event4 = new MyEvent("symbol4");
        MyEvent event5 = new MyEvent("symbol5");

        MyEvent event6 = new MyEvent("symbol1");

        List<MyEvent> listEvents = new ArrayList<MyEvent>();
        listEvents.add(event1);
        listEvents.add(event2);
        listEvents.add(event3);
        listEvents.add(event4);
        listEvents.add(event5);
        listEvents.add(event6);

        for (MyEvent event : listEvents) {

            if(event.getSymbol().equalsIgnoreCase("symbol1")) {
                if(!cacheTPTable.containsKey(event.getSymbol())) {
                    ExecutorService tp1 = testThreadPool.getThreadPool(event.getSymbol());
                    cacheTPTable.put(event.getSymbol(), tp1);
                    Future<Integer> response = tp1.submit(event);
                    cacheTPTable.remove(event.getSymbol());

                    try {
                        System.out.print("Got response for symbol1 :" + response.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }

            if(event.getSymbol().equalsIgnoreCase("symbol2")) {
                if(!cacheTPTable.containsKey(event.getSymbol())) {
                    ExecutorService tp2 = testThreadPool.getThreadPool(event.getSymbol());
                    cacheTPTable.put(event.getSymbol(), tp2);
                    Future<Integer> response = tp2.submit(event);
                    cacheTPTable.remove(event.getSymbol());

                    try {
                        System.out.print("Got response for symbol2 :" + response.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }

            if(event.getSymbol().equalsIgnoreCase("symbol3")) {
                if(!cacheTPTable.containsKey(event.getSymbol())) {
                    ExecutorService tp3 = testThreadPool.getThreadPool(event.getSymbol());
                    cacheTPTable.put(event.getSymbol(), tp3);
                    Future<Integer> response = tp3.submit(event);
                    cacheTPTable.remove(event.getSymbol());

                    try {
                        System.out.print("Got response for symbol3 :" + response.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }

            if(event.getSymbol().equalsIgnoreCase("symbol4")) {
                if(!cacheTPTable.containsKey(event.getSymbol())) {
                    ExecutorService tp4 = testThreadPool.getThreadPool(event.getSymbol());
                    cacheTPTable.put(event.getSymbol(), tp4);
                    Future<Integer> response = tp4.submit(event);
                    cacheTPTable.remove(event.getSymbol());

                    try {
                        System.out.print("Got response for symbol4 :" + response.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }

            if(event.getSymbol().equalsIgnoreCase("symbol5")) {
                if(!cacheTPTable.containsKey(event.getSymbol())) {
                    ExecutorService tp5 = testThreadPool.getThreadPool(event.getSymbol());
                    cacheTPTable.put(event.getSymbol(), tp5);
                    Future<Integer> response = tp5.submit(event);
                    cacheTPTable.remove(event.getSymbol());

                    try {
                        System.out.print("Got response for symbol5 :" + response.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    private ExecutorService getThreadPool(final String symbol) {
        return tpTable.get(symbol);
    }
}
