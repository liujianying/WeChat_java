package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.b.g;
import com.tencent.mm.pluginsdk.ui.applet.e.a;

class a$5 implements a {
    final /* synthetic */ a hqX;
    final /* synthetic */ c$e hqY;

    a$5(a aVar, c$e c_e) {
        this.hqX = aVar;
        this.hqY = c_e;
    }

    public final void onFinish() {
        this.hqY.hrC.hrq.setVisibility(0);
        this.hqY.hrC.hrM.setTextColor(a.b(this.hqX).getResources().getColor(b.a.white));
        this.hqY.hrC.gwj.setBackgroundResource(g.chatting_item_biz_pic_icon);
    }
}
