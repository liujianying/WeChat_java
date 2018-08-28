package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.chatting.p.10;

class p$10$1 implements c {
    final /* synthetic */ boolean tJm;
    final /* synthetic */ 10 tJn;

    p$10$1(10 10, boolean z) {
        this.tJn = 10;
        this.tJm = z;
    }

    public final void a(l lVar) {
        lVar.ak(2, R.l.app_field_voip, R.k.sharemore_videovoip);
        if (!this.tJm) {
            lVar.ak(1, R.l.app_field_voipaudio, R.k.sharemore_voipvoice);
        }
    }
}
