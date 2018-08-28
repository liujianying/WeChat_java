package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.al.2;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;

class al$2$1 implements Runnable {
    final /* synthetic */ int oCo;
    final /* synthetic */ String sk;
    final /* synthetic */ 2 tSZ;

    al$2$1(2 2, int i, String str) {
        this.tSZ = 2;
        this.oCo = i;
        this.sk = str;
    }

    public final void run() {
        if (this.oCo == 0) {
            this.tSZ.tSY.a(bi.WV(this.sk), b.ues);
            al.a(this.tSZ.tSY, bi.WV(this.sk));
            return;
        }
        if (this.oCo == 3) {
            h.bA(this.tSZ.tSY.bAG.tTq.getContext(), this.tSZ.tSY.bAG.tTq.getMMResources().getString(R.l.chatting_translate_too_long));
        } else if (this.oCo != 5) {
            h.bA(this.tSZ.tSY.bAG.tTq.getContext(), this.tSZ.tSY.bAG.tTq.getMMResources().getString(R.l.chatting_translate_comm_error));
        }
        this.tSZ.tSY.a(bi.WV(this.sk), b.uep);
        this.tSZ.tSY.bAG.avj();
    }
}
