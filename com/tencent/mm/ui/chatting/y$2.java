package com.tencent.mm.ui.chatting;

import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.chatting.b.b.o;
import com.tencent.mm.ui.chatting.b.b.w;
import com.tencent.mm.ui.chatting.b.b.z;

class y$2 implements e {
    final /* synthetic */ y tMm;

    y$2(y yVar) {
        this.tMm = yVar;
    }

    public final boolean aCg() {
        w wVar = (w) this.tMm.bAG.O(w.class);
        x.i("MicroMsg.ChattingUIFragment", "summerbadcr onBottomLoadData isChatroomChat[%b], needCheckHistoryTips[%b]", new Object[]{Boolean.valueOf(this.tMm.bAG.cwr()), Boolean.valueOf(((z) this.tMm.bAG.O(z.class)).cwa())});
        if (wVar.cvQ() || wVar.cvT()) {
            this.tMm.tMc.tKf = true;
        }
        this.tMm.tMc.tKj = false;
        if (this.tMm.bAG.cwr() && ((z) this.tMm.bAG.O(z.class)).cwa()) {
            return false;
        }
        if (this.tMm.tMc.ctK()) {
            x.i("MicroMsg.ChattingUIFragment", "pullDownView showButtomAll on set position %d", new Object[]{Integer.valueOf(this.tMm.tMc.getCount() - 1)});
            y.a(this.tMm).setSelection(this.tMm.tMc.getCount() - 1);
            y.f(this.tMm).setIsBottomShowAll(true);
            return true;
        }
        int count = this.tMm.tMc.getCount();
        this.tMm.tMc.a(null);
        if (this.tMm.tMc.getCount() > count) {
            x.i("MicroMsg.ChattingUIFragment", "pullDownView height: " + y.f(this.tMm).getHeight() + ", chatHistoryList height: " + y.a(this.tMm).getHeight() + " header height: " + ((o) this.tMm.bAG.O(o.class)).cvy() + " topHeight: " + y.f(this.tMm).getTopHeight());
            j.a(y.a(this.tMm), count + 1, (y.a(this.tMm).getHeight() - y.h(this.tMm)) - y.f(this.tMm).getTopHeight(), false);
        }
        return true;
    }
}
