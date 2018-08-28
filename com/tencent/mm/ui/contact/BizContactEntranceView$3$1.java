package com.tencent.mm.ui.contact;

import android.widget.TextView;
import com.tencent.mm.ui.contact.BizContactEntranceView.3;

class BizContactEntranceView$3$1 implements Runnable {
    final /* synthetic */ long uim;
    final /* synthetic */ long uio;
    final /* synthetic */ 3 uip;

    BizContactEntranceView$3$1(3 3, long j, long j2) {
        this.uip = 3;
        this.uim = j;
        this.uio = j2;
    }

    public final void run() {
        TextView c = BizContactEntranceView.c(this.uip.uil);
        int i = (!BizContactEntranceView.b(this.uip.uil) || this.uim <= this.uio) ? 4 : 0;
        c.setVisibility(i);
    }
}
