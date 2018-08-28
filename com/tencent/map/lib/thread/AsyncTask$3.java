package com.tencent.map.lib.thread;

import com.tencent.map.lib.thread.AsyncTask.d;

class AsyncTask$3 implements Runnable {
    final /* synthetic */ Object[] a;
    final /* synthetic */ AsyncTask b;

    AsyncTask$3(AsyncTask asyncTask, Object[] objArr) {
        this.b = asyncTask;
        this.a = objArr;
    }

    public void run() {
        if (AsyncTask.b(this.b) == d.a) {
            this.b.execute(this.a);
        }
    }
}
