package com.tencent.mm.pluginsdk.g.a.c;

import android.os.Process;
import com.tencent.mm.pluginsdk.g.a.c.f.b;

protected abstract class f$d<Req extends b> implements Runnable {
    private final Req qCX;

    public Req ach() {
        return this.qCX;
    }

    public f$d(Req req) {
        this.qCX = req;
    }

    public void run() {
        if (Process.getThreadPriority(Process.myTid()) != 10) {
            Process.setThreadPriority(10);
        }
    }
}
