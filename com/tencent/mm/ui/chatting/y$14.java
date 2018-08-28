package com.tencent.mm.ui.chatting;

import android.view.ViewGroup;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.chatting.b.ah;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.b.b.h;
import com.tencent.mm.ui.chatting.b.b.n;
import com.tencent.mm.ui.chatting.b.b.w;
import com.tencent.mm.ui.chatting.b.b.z;
import com.tencent.mm.ui.r.a;

class y$14 implements a {
    private int count = 0;
    final /* synthetic */ y tMm;

    y$14(y yVar) {
        this.tMm = yVar;
    }

    public final void Xb() {
        if (this.tMm.bAG.eaR) {
            x.i("MicroMsg.ChattingUIFragment", "summerbadcr onPostReset needCheckHistoryTips[%b], BADCR_SCROLL_DELAY[%d]", new Object[]{Boolean.valueOf(((z) this.tMm.bAG.O(z.class)).cwa()), Integer.valueOf(ah.tSa)});
            if (this.tMm.tMe && com.tencent.mm.l.a.gd(this.tMm.bAG.oLT.field_type) && this.tMm.bAG.oLT.ckW()) {
                this.tMm.tMe = false;
                ((c) this.tMm.bAG.O(c.class)).cuy();
            }
            ((n) this.tMm.bAG.O(n.class)).anA();
            y.a(this.tMm).post(new 1(this));
            y.f(this.tMm).setIsTopShowAll(this.tMm.tMc.ctJ());
            y.f(this.tMm).setIsBottomShowAll(this.tMm.tMc.ctK());
            MMPullDownView f = y.f(this.tMm);
            MMPullDownView.e((ViewGroup) f.twC, 4);
            MMPullDownView.e((ViewGroup) f.tiw, 4);
            w wVar = (w) this.tMm.bAG.O(w.class);
            if (this.tMm.tMc.edl - this.count > 0 && !wVar.cvQ()) {
                x.i("MicroMsg.ChattingUIFragment", "ncnt > 0 && (!isShowSearchChatResult) scroll to last");
                if (!((z) this.tMm.bAG.O(z.class)).cvX()) {
                    this.tMm.Y(false, false);
                }
            }
            h hVar = (h) this.tMm.bAG.O(h.class);
            if (!wVar.cvS() && wVar.cvT() && !hVar.cuS() && this.tMm.tMc.ctB()) {
                x.v("MicroMsg.ChattingUIFragment", "useEditSearchMode && !chattingMoreHelper.inShowMode() && adapter.triggerMoveToLast()");
                this.tMm.Y(false, false);
            }
            if (this.tMm.keyboardState() == 1) {
                x.v("MicroMsg.ChattingUIFragment", "kbshown scroll to last");
                this.tMm.Y(true, false);
            }
            if (this.tMm.bAG.eaR) {
                au.Em().H(new 2(this));
                return;
            }
            return;
        }
        x.i("MicroMsg.ChattingUIFragment", "onPostRset fragment not foreground, return");
    }

    public final void Xa() {
        if (this.tMm.bAG.eaR) {
            g.vu(13);
            this.count = this.tMm.tMc.edl;
            return;
        }
        x.i("MicroMsg.ChattingUIFragment", "onPreReset fragment not foreground, return");
    }
}
