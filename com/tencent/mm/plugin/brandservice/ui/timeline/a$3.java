package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.c.e;
import com.tencent.mm.pluginsdk.ui.applet.e.a;

class a$3 implements a {
    final /* synthetic */ a hqX;
    final /* synthetic */ e hqY;

    a$3(a aVar, e eVar) {
        this.hqX = aVar;
        this.hqY = eVar;
    }

    public final void onFinish() {
        this.hqY.hrB.hrq.setVisibility(0);
        this.hqY.hrB.hrP.setTextColor(a.b(this.hqX).getResources().getColor(b.a.white));
    }
}
