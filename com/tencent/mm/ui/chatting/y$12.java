package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;

class y$12 implements Runnable {
    final /* synthetic */ y tMm;

    y$12(y yVar) {
        this.tMm = yVar;
    }

    public final void run() {
        if (y.b(this.tMm) || y.c(this.tMm) != 0) {
            y.d(this.tMm);
            x.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect userTouched: %s state: %s", new Object[]{Boolean.valueOf(y.b(this.tMm)), Integer.valueOf(y.c(this.tMm))});
            return;
        }
        x.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect tryScrollTimes : %s, lastvisible/total=%s/%s", new Object[]{Integer.valueOf(y.e(this.tMm)), Integer.valueOf(y.a(this.tMm).getLastVisiblePosition()), Integer.valueOf(y.a(this.tMm).getCount() - 1)});
        if (y.a(this.tMm).getLastVisiblePosition() < y.a(this.tMm).getCount() - 1) {
            y.a(this.tMm, true);
            this.tMm.cue();
            return;
        }
        y.d(this.tMm);
    }
}
