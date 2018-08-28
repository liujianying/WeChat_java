package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.R;
import com.tencent.mm.l.a;

class c$16 implements Runnable {
    final /* synthetic */ c tOm;

    c$16(c cVar) {
        this.tOm = cVar;
    }

    public final void run() {
        if (!a.gd(this.tOm.bAG.oLT.field_type) && this.tOm.bAG.oLT.ckW()) {
            this.tOm.bAG.tTq.setMMSubTitle(R.l.chatting_biz_not_add);
        }
    }
}
