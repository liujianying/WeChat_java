package com.tencent.mm.ipcinvoker;

import com.tencent.mm.ipcinvoker.l.a.2;
import java.lang.Thread.UncaughtExceptionHandler;

class l$a$2$1 implements Runnable {
    final /* synthetic */ 2 dmU;
    final /* synthetic */ Runnable val$command;

    l$a$2$1(2 2, Runnable runnable) {
        this.dmU = 2;
        this.val$command = runnable;
    }

    public final void run() {
        try {
            this.val$command.run();
        } catch (Throwable th) {
            UncaughtExceptionHandler uncaughtExceptionHandler = Thread.currentThread().getUncaughtExceptionHandler();
            if (uncaughtExceptionHandler == null) {
                uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            }
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
        }
    }
}
