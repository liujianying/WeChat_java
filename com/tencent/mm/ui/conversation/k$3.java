package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.x;

class k$3 implements Runnable {
    final /* synthetic */ k uro;

    k$3(k kVar) {
        this.uro = kVar;
    }

    public final void run() {
        if (!this.uro.urj) {
            int lastVisiblePosition = this.uro.unh.getLastVisiblePosition();
            int firstVisiblePosition = this.uro.unh.getFirstVisiblePosition();
            int i = lastVisiblePosition - firstVisiblePosition;
            if (firstVisiblePosition != this.uro.urn) {
                this.uro.urn = firstVisiblePosition;
                x.d("MicroMsg.PreLoadHelper", "Jacks PreLod to Show, fistVisibleItem: %d, visibleItemCout: %d", new Object[]{Integer.valueOf(firstVisiblePosition), Integer.valueOf(i)});
                int i2 = lastVisiblePosition + 1;
                while (i2 < this.uro.unL.getCount() && i2 < (i * 1) + lastVisiblePosition) {
                    this.uro.unL.FT(i2);
                    i2++;
                }
                i2 = firstVisiblePosition - 1;
                while (i2 >= 0 && i2 > firstVisiblePosition - (i * 1)) {
                    this.uro.unL.FT(i2);
                    i2--;
                }
            }
        }
    }
}
