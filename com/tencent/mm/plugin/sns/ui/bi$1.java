package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class bi$1 implements Runnable {
    final /* synthetic */ bi ohY;

    bi$1(bi biVar) {
        this.ohY = biVar;
    }

    public final void run() {
        if (this.ohY.kww != null && this.ohY.kww.getCount() > this.ohY.position) {
            int i;
            int top = this.ohY.nLN.getTop();
            x.d("MicroMsg.TimeLineScrollAnimation", "limitCount: " + this.ohY.ohT + " footerHeight:" + this.ohY.nLN.getHeight() + " listOriginalBottom: " + this.ohY.nUa);
            if (bi.a(this.ohY) > 0 && (this.ohY.nVx != top || top > this.ohY.nUa - 200 || this.ohY.kww.getBottom() > (this.ohY.nUa - this.ohY.nLN.getHeight()) - 150)) {
                i = 10;
                if (this.ohY.ohT == 0) {
                    i = 200;
                }
                new ag().postDelayed(this, (long) i);
            }
            this.ohY.nVx = top;
            i = (this.ohY.nVx - this.ohY.ohR) - this.ohY.ohP;
            x.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + this.ohY.ohP + " footerTop" + this.ohY.nVx + " list.bottom:" + this.ohY.kww.getBottom() + " position: " + this.ohY.position + " topselection: " + i);
            x.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + this.ohY.kww.getTop() + " marginTop: " + this.ohY.ohR + " footerTop " + this.ohY.nVx);
            this.ohY.kww.setSelectionFromTop(this.ohY.position + this.ohY.kww.getHeaderViewsCount(), i);
        }
    }
}
