package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.ui.chatting.viewitems.p.c;
import com.tencent.mm.ui.chatting.viewitems.p.j;

class p$j$2 implements a {
    final /* synthetic */ int dhD;
    final /* synthetic */ c ubU;
    final /* synthetic */ j ubW;

    p$j$2(j jVar, int i, c cVar) {
        this.ubW = jVar;
        this.dhD = i;
        this.ubU = cVar;
    }

    public final void onFinish() {
        if (this.dhD > 1) {
            this.ubU.ubM.moe.setTextColor(j.a(this.ubW).tTq.getContext().getResources().getColor(R.e.white));
            this.ubU.ubM.moe.setBackgroundResource(R.g.biz_item_cover_gradient_bg);
        }
        this.ubU.ubM.mof.setVisibility(0);
    }
}
