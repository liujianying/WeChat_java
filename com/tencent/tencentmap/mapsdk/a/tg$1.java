package com.tencent.tencentmap.mapsdk.a;

import java.util.concurrent.ThreadFactory;

class tg$1 implements ThreadFactory {
    private int a = 0;

    tg$1(tg tgVar) {
    }

    public final Thread newThread(Runnable runnable) {
        StringBuilder stringBuilder = new StringBuilder("TileFetchThread#");
        int i = this.a;
        this.a = i + 1;
        Thread thread = new Thread(runnable, stringBuilder.append(i).toString());
        thread.setPriority(10);
        return thread;
    }
}
