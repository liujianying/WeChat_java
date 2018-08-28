package com.tencent.map.lib.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class AsyncTask$2 extends FutureTask<Result> {
    final /* synthetic */ AsyncTask a;

    AsyncTask$2(AsyncTask asyncTask, Callable callable) {
        this.a = asyncTask;
        super(callable);
    }

    protected void done() {
        try {
            AsyncTask.b(this.a, get());
        } catch (InterruptedException e) {
        } catch (ExecutionException e2) {
            throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
        } catch (CancellationException e3) {
            AsyncTask.b(this.a, null);
        }
    }
}
