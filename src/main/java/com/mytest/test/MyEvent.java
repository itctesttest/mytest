package com.mytest.test;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by itconsultant.ind@gmail on 31-Aug-17.
 */
public class MyEvent implements Callable<Integer> {

     private String symbol;

    public MyEvent(final String symbol) {
        this.symbol = symbol;
    }

    public Integer call() throws Exception {

        System.out.println("Running Thread for Symbol ->"+ this.getSymbol());

        if(symbol.equalsIgnoreCase("symbol1")) {
            Thread.sleep(10000);
        }
        //Your update method code here

        //Ex.
       /* String tree = null;
        String symbol = null;
        AcReplicatorResponse response = ACKNOWLEDGE;

        try {
            if (acEvent.isDatafileTransaction()) {
                final AcEventDatafileTransaction datafileTransaction = acEvent.getDatafileTransaction();
                tree = datafileTransaction.getTreeId();
                symbol = datafileTransaction.getSymbol();
                if (datafileTreesOfInterest.contains(tree)) {
                    log.info("DatafileTransaction received [" + tree + "] [" + symbol + "]");
                    if (symbol.startsWith("DF.")) {
                        final List<AcStreamAble> transactions = getDatafileTransactions(datafileTransaction);
                        for (final Object transaction : transactions) {
                            if (transaction instanceof AcFileAttributes) {
                                final AcFileAttributes fa = (AcFileAttributes)transaction;
                                if (fa.getOperation()== AcOperation.CHANGEFLD ||
                                        fa.getOperation()== AcOperation.ADD ||
                                        fa.getOperation()== AcOperation.INSERT ||
                                        fa.getOperation()== AcOperation.UPDATE) {
                                    for (final FileOperationListener listener : acFileOperationListeners) {
                                        listener.handleObservationTemplateChange(symbol);
                                    }
                                }
                            }
                        }
                    } else {
                        final List<AcStreamAble> transactions = getDatafileTransactions(datafileTransaction);
                        final List<AcEventRecordOperation> recordOperations = getTransactionsAsListOfRecordOperations(datafileTransaction, transactions);
                        if (recordOperations != null  && recordOperations.size() > 0) {
                            for (final RecordOperationListener listener : acRecordOperationListeners) {
                                listener.handle(tree, symbol, recordOperations);
                            }
                        }
                    }
                }*/


               // return response.getValue();

        return 1;
    }

    public String getSymbol() {
        return symbol;
    }


}
