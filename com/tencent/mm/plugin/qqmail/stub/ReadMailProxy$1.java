package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.mm.plugin.downloader.model.l;

class ReadMailProxy$1 implements l {
    final /* synthetic */ ReadMailProxy mej;

    ReadMailProxy$1(ReadMailProxy readMailProxy) {
        this.mej = readMailProxy;
    }

    public final void onTaskStarted(long j, String str) {
        this.mej.CLIENT_CALL("onTaskStarted", new Object[]{Long.valueOf(j), str});
    }

    public final void onTaskRemoved(long j) {
        this.mej.CLIENT_CALL("onTaskRemoved", new Object[]{Long.valueOf(j)});
    }

    public final void b(long j, String str, boolean z) {
        this.mej.CLIENT_CALL("onTaskFinished", new Object[]{Long.valueOf(j)});
    }

    public final void b(long j, int i, boolean z) {
        this.mej.CLIENT_CALL("onTaskFailed", new Object[]{Long.valueOf(j)});
    }

    public final void onTaskPaused(long j) {
        this.mej.CLIENT_CALL("onTaskPaused", new Object[]{Long.valueOf(j)});
    }

    public final void bP(long j) {
    }

    public final void h(long j, String str) {
    }
}
