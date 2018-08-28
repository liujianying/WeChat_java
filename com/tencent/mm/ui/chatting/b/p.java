package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.ag;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.k;
import com.tencent.mm.ui.chatting.b.b.l;
import com.tencent.mm.ui.chatting.b.b.m;
import com.tencent.mm.ui.chatting.b.b.w;
import com.tencent.mm.ui.chatting.o;

@a(cwo = l.class)
public class p extends a implements l {
    private long[] tIX = null;
    private boolean tPG = false;
    private o tPH = null;

    public final void cpF() {
        this.tPG = this.bAG.tTq.getBooleanExtra("expose_edit_mode", false).booleanValue();
        this.tIX = this.bAG.tTq.getArguments().getLongArray("expose_selected_ids");
    }

    public final void cpG() {
        if (this.tPG && this.tPH == null) {
            this.tPH = new o(this.bAG, this.tIX);
        }
    }

    public final void cpH() {
        super.cpH();
        if (this.tPH != null) {
            o oVar = this.tPH;
            g gVar = (g) oVar.bAG.O(g.class);
            ((w) oVar.bAG.O(w.class)).cvN();
            gVar.ctP();
            gVar.ctM();
            if (oVar.tIX != null) {
                for (long gt : oVar.tIX) {
                    gVar.gt(gt);
                }
            }
            ChatFooter cvb = ((m) oVar.bAG.O(m.class)).cvb();
            if (cvb != null) {
                cvb.setVisibility(8);
            }
            ChatFooterCustom cvc = ((m) oVar.bAG.O(m.class)).cvc();
            if (cvc != null) {
                cvc.setVisibility(8);
            }
            ((k) oVar.bAG.O(k.class)).cuY();
            oVar.bAG.YC();
            ((ag) oVar.bAG.O(ag.class)).cwm();
            oVar.bAG.lZ(true);
        }
    }

    public final boolean cva() {
        return this.tPG;
    }
}
