package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ui.chatting.viewitems.ah.b;
import com.tencent.mm.ui.chatting.viewitems.ah.e;
import com.tencent.mm.ui.widget.MMNeatTextView.a;

class ah$b$1 implements a {
    final /* synthetic */ e udY;
    final /* synthetic */ b uea;

    ah$b$1(b bVar, e eVar) {
        this.uea = bVar;
        this.udY = eVar;
    }

    public final void P(CharSequence charSequence) {
        if (((Boolean) this.udY.ueb.getTag(b.bB())).booleanValue()) {
            com.tencent.mm.ui.chatting.h.a.a.cxI();
            com.tencent.mm.ui.chatting.h.a.a.cxJ().a(charSequence, ((Long) this.udY.ueb.getTag(b.KD())).longValue());
        }
    }
}
