package com.tencent.map.lib.thread;

import com.tencent.map.lib.thread.AsyncTask.c;

class AsyncTask$c$1 implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ c b;

    AsyncTask$c$1(c cVar, Runnable runnable) {
        this.b = cVar;
        this.a = runnable;
    }

    public void run() {
        try {
            this.a.run();
        } finally {
            this.b.a();
        }
    }
}
