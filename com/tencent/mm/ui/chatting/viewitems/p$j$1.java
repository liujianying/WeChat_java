package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.viewitems.p.c;
import com.tencent.mm.ui.chatting.viewitems.p.j;
import com.tencent.mm.y.m;

class p$j$1 implements a {
    final /* synthetic */ bd dAs;
    final /* synthetic */ m hrc;
    final /* synthetic */ int hrd;
    final /* synthetic */ c ubU;
    final /* synthetic */ p.a ubV;
    final /* synthetic */ j ubW;

    p$j$1(j jVar, c cVar, p.a aVar, m mVar, bd bdVar, int i) {
        this.ubW = jVar;
        this.ubU = cVar;
        this.ubV = aVar;
        this.hrc = mVar;
        this.dAs = bdVar;
        this.hrd = i;
    }

    public final void onFinish() {
        j.a(this.ubW, this.ubU, this.ubV, this.hrc, this.dAs, this.hrd);
    }
}
