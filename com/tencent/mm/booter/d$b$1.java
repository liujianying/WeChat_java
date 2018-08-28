package com.tencent.mm.booter;

import android.os.Process;
import com.tencent.mm.booter.d.b;

class d$b$1 implements Runnable {
    final /* synthetic */ b cWQ;

    d$b$1(b bVar) {
        this.cWQ = bVar;
    }

    public final void run() {
        Process.killProcess(Process.myPid());
    }
}
