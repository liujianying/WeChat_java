package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.mm.plugin.qqmail.b.w;

class ReadMailProxy$5 implements Runnable {
    final /* synthetic */ ReadMailProxy mej;
    final /* synthetic */ long mek;

    ReadMailProxy$5(ReadMailProxy readMailProxy, long j) {
        this.mej = readMailProxy;
        this.mek = j;
    }

    public final void run() {
        w.bow().cancel(this.mek);
    }
}
