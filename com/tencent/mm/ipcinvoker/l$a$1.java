package com.tencent.mm.ipcinvoker;

import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.ipcinvoker.l.a;
import java.util.concurrent.ThreadFactory;

class l$a$1 implements ThreadFactory {
    final /* synthetic */ a dmR;
    int index = 0;

    l$a$1(a aVar) {
        this.dmR = aVar;
    }

    public final Thread newThread(Runnable runnable) {
        StringBuilder stringBuilder = new StringBuilder("ThreadPool#Thread-");
        int i = this.index;
        this.index = i + 1;
        Thread thread = new Thread(new 1(this, runnable), stringBuilder.append(i).toString());
        b.i("IPC.ExecutorServiceCreatorImpl", "newThread(thread : %s)", new Object[]{r0});
        return thread;
    }
}
