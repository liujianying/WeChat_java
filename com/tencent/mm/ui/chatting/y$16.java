package com.tencent.mm.ui.chatting;

import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView$g;
import com.tencent.mm.ui.chatting.b.b.w;
import com.tencent.mm.ui.chatting.b.b.z;

class y$16 implements MMPullDownView$g {
    final /* synthetic */ y tMm;

    y$16(y yVar) {
        this.tMm = yVar;
    }

    public final boolean aCj() {
        w wVar = (w) this.tMm.bAG.O(w.class);
        x.i("MicroMsg.ChattingUIFragment", "summerbadcr onTopLoadData isChatroomChat[%b], talker[%s]", new Object[]{Boolean.valueOf(this.tMm.bAG.cwr()), this.tMm.bAG.getTalkerUserName()});
        if (wVar.cvQ() || wVar.cvT() || wVar.cvS()) {
            this.tMm.tMc.tKe = true;
        }
        this.tMm.tMc.tKj = true;
        int count = this.tMm.tMc.getCount();
        boolean ctJ = this.tMm.tMc.ctJ();
        z zVar = (z) this.tMm.bAG.O(z.class);
        if (zVar.cvW()) {
            return false;
        }
        if (zVar.cvY()) {
            zVar.cvZ();
            x.i("MicroMsg.ChattingUIFragment", "summerbadcr silenceMsgImp.skipNextTopLoad is true");
            return true;
        } else if (ctJ) {
            x.i("MicroMsg.ChattingUIFragment", "pullDownView showTopAll on set position %d, set pullDownView.getTopHeight() %d", new Object[]{Integer.valueOf(1), Integer.valueOf(y.f(this.tMm).getTopHeight())});
            j.a(y.a(this.tMm), 1, y.f(this.tMm).getTopHeight(), false);
            y.f(this.tMm).setIsTopShowAll(true);
            return true;
        } else {
            this.tMm.tMc.EP(18);
            this.tMm.tMc.ctG();
            int count2 = this.tMm.tMc.getCount();
            x.d("MicroMsg.ChattingUIFragment", "onTopLoadData talker[%s], nowCount:%d, preCount:%d", new Object[]{this.tMm.bAG.getTalkerUserName(), Integer.valueOf(count2), Integer.valueOf(count)});
            if (count2 > count) {
                count2 -= count;
                this.tMm.tMc.EQ(count2);
                x.i("MicroMsg.ChattingUIFragment", "pullDownView nowCount > preCount on set position %d, set pullDownView.getTopHeight() %d", new Object[]{Integer.valueOf(count2 + 1), Integer.valueOf(y.h(this.tMm) + y.f(this.tMm).getTopHeight())});
                j.a(y.a(this.tMm), count2 + 1, y.h(this.tMm) + y.f(this.tMm).getTopHeight(), false);
            }
            return true;
        }
    }
}
