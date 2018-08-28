package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.ui.chatting.viewitems.p.c;
import com.tencent.mm.ui.chatting.viewitems.p.j;

class p$j$3 implements a {
    final /* synthetic */ c ubU;
    final /* synthetic */ j ubW;

    p$j$3(j jVar, c cVar) {
        this.ubW = jVar;
        this.ubU = cVar;
    }

    public final void onFinish() {
        this.ubU.ubN.hrq.setVisibility(0);
        this.ubU.ubN.eGX.setTextColor(j.a(this.ubW).tTq.getContext().getResources().getColor(R.e.white));
        this.ubU.ubN.hrV.setTextColor(j.a(this.ubW).tTq.getContext().getResources().getColor(R.e.white));
        this.ubU.ubN.gwj.setImageResource(R.k.chatting_item_biz_video_icon);
    }
}
