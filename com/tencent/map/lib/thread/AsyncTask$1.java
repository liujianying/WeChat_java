package com.tencent.map.lib.thread;

import com.tencent.map.lib.thread.AsyncTask.e;

class AsyncTask$1 extends e<Params, Result> {
    final /* synthetic */ AsyncTask a;

    AsyncTask$1(AsyncTask asyncTask) {
        this.a = asyncTask;
        super(null);
    }

    public Result call() {
        AsyncTask.a(this.a).set(true);
        return AsyncTask.a(this.a, this.a.doInBackground(this.b));
    }
}
