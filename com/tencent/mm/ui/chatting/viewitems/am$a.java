package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.b.b.ag;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t.d;

class am$a extends d {
    final /* synthetic */ am ufd;

    public am$a(am amVar, a aVar) {
        this.ufd = amVar;
        super(aVar);
    }

    public final void a(View view, a aVar, bd bdVar) {
        au auVar = (au) view.getTag();
        au.HU();
        if (c.isSDCardAvailable()) {
            ((ag) this.tKy.O(ag.class)).cwl().a(auVar.position, auVar.bXQ);
        } else {
            s.gH(this.tKy.tTq.getContext());
        }
    }
}
