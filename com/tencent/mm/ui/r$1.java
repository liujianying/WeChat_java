package com.tencent.mm.ui;

import com.tencent.mm.sdk.platformtools.x;

class r$1 implements Runnable {
    final /* synthetic */ r tlL;

    r$1(r rVar) {
        this.tlL = rVar;
    }

    public final void run() {
        if (r.a(this.tlL) != 0) {
            x.v("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, post resetCursorJob, retryTimes %d", new Object[]{Integer.valueOf(r.a(this.tlL)), Integer.valueOf(r.b(this.tlL))});
            r.d(this.tlL).removeCallbacks(r.c(this.tlL));
            if (20 > r.e(this.tlL)) {
                r.d(this.tlL).postDelayed(r.c(this.tlL), 100);
                return;
            } else {
                x.w("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, do resetCursorJob, retryTimes %d", new Object[]{Integer.valueOf(r.a(this.tlL)), Integer.valueOf(r.e(this.tlL))});
            }
        }
        x.d("MicroMsg.MListAdapter", "ashutest:: do resetCursorJob");
        r.f(this.tlL);
        r.g(this.tlL);
    }
}
