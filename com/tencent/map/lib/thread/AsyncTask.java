package com.tencent.map.lib.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AsyncTask<Params, Progress, Result> {
    private static final b a = new b(Looper.getMainLooper());
    public static final Executor sHighThreadExecutor = new HighThreadExecutor();
    public static final Executor sHightSerialExecutor = new c(null);
    public static final Executor sLowSerialExecutor = new c(null);
    public static final Executor sLowThreadExecutor = new LowThreadExecutor();
    private final e<Params, Result> b = new 1(this);
    private final FutureTask<Result> c = new 2(this, this.b);
    private volatile d d = d.a;
    private final AtomicBoolean e = new AtomicBoolean();
    private final AtomicBoolean f = new AtomicBoolean();
    private boolean g = true;

    public abstract Result doInBackground(Params... paramsArr);

    public static void init() {
        a.getLooper();
    }

    private void a(Result result) {
        if (!this.f.get()) {
            b((Object) result);
        }
    }

    private Result b(Result result) {
        Message obtainMessage = a.obtainMessage(1, new a(this, new Object[]{result}));
        if (this.g) {
            obtainMessage.sendToTarget();
        } else {
            a.sendMessageAtFrontOfQueue(obtainMessage);
        }
        return result;
    }

    public final d getStatus() {
        return this.d;
    }

    protected void onPreExecute() {
    }

    protected void onPostExecute(Result result) {
    }

    protected void onProgressUpdate(Progress... progressArr) {
    }

    protected void onCancelled(Result result) {
        onCancelled();
    }

    protected void onCancelled() {
    }

    public final boolean isCancelled() {
        return this.e.get();
    }

    public final boolean cancel(boolean z) {
        this.e.set(true);
        return this.c.cancel(z);
    }

    public final Result get() {
        return this.c.get();
    }

    public final Result get(long j, TimeUnit timeUnit) {
        return this.c.get(j, timeUnit);
    }

    public final AsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return execute(true, (Object[]) paramsArr);
    }

    public final AsyncTask<Params, Progress, Result> execute(boolean z, Params... paramsArr) {
        this.g = z;
        if (this.g) {
            return executeOnExecutor(sLowThreadExecutor, paramsArr);
        }
        return executeOnExecutor(sHighThreadExecutor, paramsArr);
    }

    public final void execute(long j, Params... paramsArr) {
        new Handler(Looper.getMainLooper()).postDelayed(new 3(this, paramsArr), j);
    }

    public final AsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.d != d.a) {
            switch (4.a[this.d.ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.d = d.b;
        onPreExecute();
        this.b.b = paramsArr;
        executor.execute(this.c);
        return this;
    }

    public static void execute(Runnable runnable) {
        sLowThreadExecutor.execute(runnable);
    }

    protected final void publishProgress(Progress... progressArr) {
        if (!isCancelled()) {
            a.obtainMessage(2, new a(this, progressArr)).sendToTarget();
        }
    }

    private void c(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.d = d.c;
    }
}
