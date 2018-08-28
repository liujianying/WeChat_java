package com.tencent.mm.ui;

import com.tencent.mm.g.a.cm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class h$20 extends c<cm> {
    final /* synthetic */ h tiG;

    h$20(h hVar) {
        this.tiG = hVar;
        super(1);
        this.sFo = cm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.FindMoreFriendsUI", "dynamic config file change");
        h.e(this.tiG).sendEmptyMessage(1);
        return true;
    }
}
