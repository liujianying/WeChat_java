package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.n;

class y$9 implements Runnable {
    final /* synthetic */ int eKj;
    final /* synthetic */ y tMm;

    y$9(y yVar, int i) {
        this.tMm = yVar;
        this.eKj = i;
    }

    public final void run() {
        x.i("MicroMsg.ChattingUIFragment", "[scrollToPosition] scroll to pos:%d", new Object[]{Integer.valueOf(this.eKj)});
        n nVar = new n(this.tMm.tMd);
        int headerViewsCount = y.a(this.tMm).getHeaderViewsCount() + this.eKj;
        nVar.lPD.removeCallbacks(nVar);
        nVar.uBk = System.currentTimeMillis();
        nVar.uBp = 0;
        int firstVisiblePosition = nVar.lPD.getFirstVisiblePosition();
        int childCount = (nVar.lPD.getChildCount() + firstVisiblePosition) - 1;
        if (headerViewsCount <= firstVisiblePosition) {
            firstVisiblePosition = (firstVisiblePosition - headerViewsCount) + 1;
            nVar.mMode = 2;
        } else if (headerViewsCount >= childCount) {
            firstVisiblePosition = (headerViewsCount - childCount) + 1;
            nVar.mMode = 1;
        } else {
            return;
        }
        if (firstVisiblePosition > 0) {
            nVar.uBn = 1000 / firstVisiblePosition;
        } else {
            nVar.uBn = 1000;
        }
        nVar.uBl = headerViewsCount;
        nVar.uBm = -1;
        nVar.lPD.post(nVar);
    }
}
