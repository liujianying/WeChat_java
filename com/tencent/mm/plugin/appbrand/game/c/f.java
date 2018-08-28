package com.tencent.mm.plugin.appbrand.game.c;

import android.os.Process;
import com.tencent.mm.plugin.appbrand.performance.c;
import com.tencent.mm.sdk.platformtools.al;

public final class f {
    public al eVk;
    c fBP;
    volatile int fBQ;
    public int fBR;

    public f() {
        this.fBQ = 0;
        this.fBR = 1000;
        this.fBQ = 0;
        this.fBP = new c(Process.myPid());
    }
}
