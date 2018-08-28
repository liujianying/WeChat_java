package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.ui.chatting.viewitems.p.c;
import com.tencent.mm.ui.chatting.viewitems.p.j;

class p$j$5 implements a {
    final /* synthetic */ c ubU;
    final /* synthetic */ j ubW;

    p$j$5(j jVar, c cVar) {
        this.ubW = jVar;
        this.ubU = cVar;
    }

    public final void onFinish() {
        this.ubU.ubO.hrq.setVisibility(0);
        this.ubU.ubO.mof.setVisibility(0);
        this.ubU.ubO.eGX.setTextColor(j.a(this.ubW).tTq.getContext().getResources().getColor(R.e.white));
        this.ubU.ubO.gwj.setBackgroundResource(R.k.chatting_item_biz_pic_icon);
    }
}
