package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class bi$2 implements Runnable {
    int offset = 0;
    final /* synthetic */ bi ohY;

    bi$2(bi biVar) {
        this.ohY = biVar;
    }

    public final void run() {
        if (this.ohY.kww != null && this.ohY.kww.getCount() > this.ohY.position) {
            this.ohY.nVx = this.ohY.nLN.getTop();
            int i = (this.ohY.nVx - this.ohY.ohR) - this.ohY.ohP;
            x.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + this.ohY.ohP + " footerTop" + this.ohY.nVx + " list.bottom:" + this.ohY.kww.getBottom() + " position: " + this.ohY.position + " topselection: " + i);
            x.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + this.ohY.kww.getTop() + " marginTop: " + this.ohY.ohR + " footerTop " + this.ohY.nVx);
            if (i == this.offset) {
                this.ohY.kww.setSelectionFromTop(this.ohY.position + this.ohY.kww.getHeaderViewsCount(), i);
                this.offset = 0;
                this.ohY.ohT = 0;
            } else if (bi.a(this.ohY) > 0) {
                new ag().postDelayed(this, 100);
                this.offset = i;
            } else {
                this.offset = 0;
                this.ohY.ohT = 0;
            }
        }
    }
}
