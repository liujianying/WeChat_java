package com.tencent.mm.by;

import com.tencent.mm.vending.h.d;

public final class e extends d {
    public final void g(Runnable runnable) {
        runnable.run();
    }

    public final void g(Runnable runnable, long j) {
        runnable.run();
    }

    public final String getType() {
        return "WxNoLooperScheduler";
    }

    public final void cancel() {
    }
}
