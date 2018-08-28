package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a.3;
import com.tencent.mm.ui.chatting.b.b.o;

class AppBrandServiceChattingUI$a$3$1 implements Runnable {
    final /* synthetic */ 3 tGR;

    AppBrandServiceChattingUI$a$3$1(3 3) {
        this.tGR = 3;
    }

    public final void run() {
        if (a.e(this.tGR.tGQ)) {
            x.d("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent refuse:%b, setRejectIcon View.Visible", new Object[]{Boolean.valueOf(a.e(this.tGR.tGQ))});
            ((o) this.tGR.tGQ.bAG.O(o.class)).Fa(0);
            return;
        }
        x.d("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent refuse:%b, setRejectIcon View.GONE", new Object[]{Boolean.valueOf(a.e(this.tGR.tGQ))});
        ((o) this.tGR.tGQ.bAG.O(o.class)).Fa(8);
    }
}
