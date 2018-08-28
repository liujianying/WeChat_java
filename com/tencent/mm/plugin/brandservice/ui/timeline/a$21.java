package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.plugin.brandservice.ui.timeline.c.b;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.storage.q;
import com.tencent.mm.y.m;

class a$21 implements a {
    final /* synthetic */ q her;
    final /* synthetic */ a hqX;
    final /* synthetic */ c$e hqY;
    final /* synthetic */ b hra;
    final /* synthetic */ m hrc;
    final /* synthetic */ int hrd;

    a$21(a aVar, c$e c_e, b bVar, m mVar, q qVar, int i) {
        this.hqX = aVar;
        this.hqY = c_e;
        this.hra = bVar;
        this.hrc = mVar;
        this.her = qVar;
        this.hrd = i;
    }

    public final void onFinish() {
        a.a(this.hqX, this.hra, this.hrc, this.her, this.hrd);
    }
}
